package test.support.appodeal.com.task3collectionandmap.ui.main.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.support.appodeal.com.task3collectionandmap.ui.main.fragments.adapter.MyAdapterItem;
import test.support.appodeal.com.task3collectionandmap.R;
import test.support.appodeal.com.task3collectionandmap.core.App;
import test.support.appodeal.com.task3collectionandmap.core.MvpContract;

public class FragmentCollection extends BaseViewFragment {

    public final static String NAMED_INJECT_ADAPTER = "fragmentCollection";

    @BindView(R.id.recycler_view_col)
    RecyclerView recyclerView;
    @Named(NAMED_INJECT_ADAPTER)
    @Inject
    MyAdapterItem adapter;
    @Inject
    MvpContract.MvpPresenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        App.getFragmentComponent().injectFragmentCollection(this);
        initialViews(recyclerView, adapter);
        presenter.setViewCollection(this);
    }
}
