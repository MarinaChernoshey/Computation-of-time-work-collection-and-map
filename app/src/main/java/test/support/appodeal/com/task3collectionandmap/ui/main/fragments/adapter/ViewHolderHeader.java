package test.support.appodeal.com.task3collectionandmap.ui.main.fragments.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.support.appodeal.com.task3collectionandmap.R;


public class ViewHolderHeader extends RecyclerView.ViewHolder {
    @BindView(R.id.textViewHeader)
    TextView textView;

    ViewHolderHeader(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
