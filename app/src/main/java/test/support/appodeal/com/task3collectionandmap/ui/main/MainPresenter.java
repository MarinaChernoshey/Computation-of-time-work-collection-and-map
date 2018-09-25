package test.support.appodeal.com.task3collectionandmap.ui.main;

import android.text.Editable;
import android.util.Log;

import io.reactivex.disposables.Disposable;
import test.support.appodeal.com.task3collectionandmap.core.MvpContract;
import test.support.appodeal.com.task3collectionandmap.data.ModelCollection;
import test.support.appodeal.com.task3collectionandmap.data.ModelMap;

public class MainPresenter implements MvpContract.MvpPresenter {

    private static final String TAG = "sdf";
    private ModelCollection modelCollection;
    private ModelMap modelMap;
    private MvpContract.MvpView.MvpViewFragment viewCollection;
    private MvpContract.MvpView.MvpViewFragment viewMap;
    private MvpContract.MvpView.MvpViewActivity viewActivity;
    private byte countObservablesEndWork;

    public MainPresenter(ModelCollection modelCollection, ModelMap modelMap) {
        this.modelCollection = modelCollection;
        this.modelMap = modelMap;
    }

    @Override
    public void onEditTextChanged(String text) {
        int value = Integer.parseInt(text);
        if (value >= MvpContract.MvpModel.SIZE_LIST_MIN && value <= MvpContract.MvpModel.SIZE_LIST_MAX)
            viewActivity.setEnableButton();
        else
            viewActivity.setUnEnableButton();
    }

    @Override
    public void startComputationOfCollection(Editable editTextValue) {
        countObservablesEndWork = 0;
        viewCollection.clearData();
        viewActivity.setInvisibleButton();
        viewCollection.setVisibleRecyclerView();
        startComputation(modelCollection, viewCollection, Integer.parseInt(String.valueOf(editTextValue)));
    }

    @Override
    public void startComputationOfMap(Editable editTextValue) {
        viewMap.setVisibleRecyclerView();
        viewMap.clearData();
        startComputation(modelMap, viewMap, Integer.parseInt(String.valueOf(editTextValue)));
    }

    private void startComputation(MvpContract.MvpModel model,
                                                           MvpContract.MvpView.MvpViewFragment viewFragment,
                                                           int sizeList) {
        Disposable d = model.create(sizeList).subscribe(
                list -> Log.d(TAG, "startComputation: " + list.getClass() + " created"),
                throwable -> {
                    viewActivity.setTextAnswer(throwable.getMessage());
                    viewActivity.setVisibleButton();
                },
                () -> model.getResultOfWork().subscribe(
                        resultWork -> viewFragment.updateData(resultWork.getIndex(), resultWork.getResult()),
                        throwable -> {
                            viewActivity.setVisibleButton();
                            viewActivity.setTextAnswer(throwable.getMessage());
                        },
                        () -> {
                            countObservablesEndWork++;
                            if (countObservablesEndWork == 2)
                                viewActivity.setVisibleButton();
                        }
                )
        );
    }

    @Override
    public void setViewActivity(MvpContract.MvpView.MvpViewActivity viewActivity) {
        this.viewActivity = viewActivity;
    }

    @Override
    public void setViewCollection(MvpContract.MvpView.MvpViewFragment viewCollection) {
        this.viewCollection = viewCollection;
    }

    @Override
    public void setViewMap(MvpContract.MvpView.MvpViewFragment viewMap) {
        this.viewMap = viewMap;
    }
}
