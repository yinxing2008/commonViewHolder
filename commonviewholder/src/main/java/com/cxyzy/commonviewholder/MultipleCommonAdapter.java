package com.cxyzy.commonviewholder;

import android.support.annotation.NonNull;

import java.util.List;


/**
 * 多布局统一adapter
 */
public abstract class MultipleCommonAdapter<T> extends BaseCommonAdapter {

    public MultipleCommonAdapter(@NonNull List<T> data) {
        super(data);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int type, Object data, int position) {
        onBindViewHolder(holder, (T) data, position);
    }

    /**
     * 由调用者根据数据设置holder中的所有view。
     * @param holder 当前行所有view的holder
     * @param data 当前行对应的数据
     * @param position 当前行位置
     */
    protected abstract void onBindViewHolder(@NonNull ViewHolder holder, T data, int position);
}
