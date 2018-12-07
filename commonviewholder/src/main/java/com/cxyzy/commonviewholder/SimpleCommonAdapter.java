package com.cxyzy.commonviewholder;

import java.util.List;

import androidx.annotation.NonNull;

/**
 * 单一布局统一adapter
 */
public abstract class SimpleCommonAdapter<T> extends BaseCommonAdapter {

    protected int mLayoutId;

    public SimpleCommonAdapter(@NonNull List<T> data, int layoutId) {
        super(data);
        this.mLayoutId = layoutId;
    }

    @Override
    protected int getLayoutIdByType(int viewType) {
        return mLayoutId;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    protected void onBindViewHolder(ViewHolder holder, int type, Object data, int position) {
        onBindViewHolder(holder, (T) data, position);
    }

    protected abstract void onBindViewHolder(ViewHolder holder, T data, int position);

}