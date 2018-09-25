package test.support.appodeal.com.task3collectionandmap.core;

import android.text.Editable;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import test.support.appodeal.com.task3collectionandmap.util.ResultWork;

public interface MvpContract {

    interface MvpView {
        interface MvpViewActivity {

            void setVisibleButton();

            void setInvisibleButton();

            void setEnableButton();

            void setUnEnableButton();

            void setTextAnswer(String textAnswer);
        }

        interface MvpViewFragment {

            void clearData();

            void updateData(int index, Double result);

            void setVisibleRecyclerView();
        }
    }

    interface MvpPresenter {
        void startComputationOfCollection(Editable editTextValue);

        void startComputationOfMap(Editable editTextValue);

        void setViewActivity(MvpView.MvpViewActivity viewActivity);

        void setViewCollection(MvpView.MvpViewFragment viewCollection);

        void setViewMap(MvpView.MvpViewFragment viewMap);

        void onEditTextChanged(String text);

    }

    interface MvpModel {
        int SIZE_LIST_MIN = 1;
        int SIZE_LIST_MAX = 1000000;

        Observable<Object> create(int sizeList);
        Observable<ResultWork> getResultOfWork();
    }
}
