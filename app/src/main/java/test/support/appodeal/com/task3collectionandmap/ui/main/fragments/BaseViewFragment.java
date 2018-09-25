package test.support.appodeal.com.task3collectionandmap.ui.main.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import test.support.appodeal.com.task3collectionandmap.core.MvpContract;
import test.support.appodeal.com.task3collectionandmap.ui.main.fragments.adapter.MyAdapterItem;

public abstract class BaseViewFragment extends Fragment implements MvpContract.MvpView.MvpViewFragment {

    RecyclerView recyclerView;
    MyAdapterItem adapter;

    protected void initialViews(RecyclerView recyclerView,
                                MyAdapterItem adapter) {
        this.adapter = adapter;
        this.recyclerView = recyclerView;
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateData(int index, Double result) {
        adapter.updateData(index, result);
    }

    @Override
    public void clearData() {
        adapter.clearData();
    }

    @Override
    public void setVisibleRecyclerView() {
        adapter.setProgressVisible(true);
    }
}
