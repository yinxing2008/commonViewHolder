package com.cxyzy.commonviewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 统一adapter基类
 */
public abstract class BaseCommonAdapter extends RecyclerView.Adapter<ViewHolder> {

    protected final List data;

    public BaseCommonAdapter(@NonNull List data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int layoutType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(viewGroup.getContext(),inflater.inflate(getLayoutIdByType(layoutType), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        onBindViewHolder(holder, getItemViewType(position), data.get(position), position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected abstract int getLayoutIdByType(int viewType);

    @Override
    public abstract int getItemViewType(int position);

    protected abstract void onBindViewHolder(ViewHolder holder, int type, Object data, int position);
}