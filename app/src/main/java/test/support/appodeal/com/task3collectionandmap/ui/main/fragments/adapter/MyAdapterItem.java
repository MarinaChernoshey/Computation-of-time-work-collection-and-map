package test.support.appodeal.com.task3collectionandmap.ui.main.fragments.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.support.appodeal.com.task3collectionandmap.R;

public class MyAdapterItem extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_HEADER_LEFT = 1;
    private static final int TYPE_ITEM = 3;

    private double[] data;
    private int countColumn;
    private int countString;
    private String[] nameColumns;
    private boolean isProgressVisible;

    public MyAdapterItem(int countColumn, int countString, String[] nameColumns) {
        this.countColumn = countColumn;
        this.countString = countString;
        this.nameColumns = nameColumns;
        data = new double[countColumn * countString];
    }

    public void updateData(int index, Double newData) {
        data[index] = newData;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_HEADER || viewType == TYPE_HEADER_LEFT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.header_from_recycler, parent, false);
            return new ViewHolderHeader(view);
        }
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_from_recycler, parent, false);

        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderHeader) {
            ((ViewHolderHeader) holder).textView.setText(nameColumns[position]);
        }
        if (holder instanceof ViewHolderItem) {
            if (isProgressVisible) {
                ((ViewHolderItem) holder).progressBar.setVisibility(View.VISIBLE);

            }
            if (data[position - countColumn] != 0) {
                ((ViewHolderItem) holder).progressBar.setVisibility(View.INVISIBLE);
                ((ViewHolderItem) holder).textView.setVisibility(View.VISIBLE);
                ((ViewHolderItem) holder).textView.setText(String.valueOf(data[position - countColumn]));
            } else {
                ((ViewHolderItem) holder).textView.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return data.length + nameColumns.length;
    }

    public void clearData() {
        for (int i = 0; i < data.length; i++)
            data[i] = 0;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < countColumn)
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    public void setProgressVisible(boolean progressVisible) {
        isProgressVisible = progressVisible;
    }
}
