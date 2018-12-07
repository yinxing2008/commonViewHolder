package com.cxyzy.commonviewholder;

import java.util.List;

import androidx.annotation.NonNull;

/**
 * 多布局统一adapter
 */
public abstract class MultipleCommonAdapter<T> extends BaseCommonAdapter {

    public MultipleCommonAdapter(@NonNull List<T> data) {
        super(data);
    }

    @Override
    protected void onBindViewHolder(ViewHolder holder, int type, Object data, int position) {
        onBindViewHolder(holder, (T) data, position);
    }

    protected abstract void onBindViewHolder(ViewHolder holder, T data, int position);
}
