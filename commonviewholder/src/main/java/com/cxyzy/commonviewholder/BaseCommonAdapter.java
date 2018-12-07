package com.cxyzy.commonviewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;


/**
 * 统一adapter基类
 */
public abstract class BaseCommonAdapter extends RecyclerView.Adapter<ViewHolder> {

    protected final List data;

    public BaseCommonAdapter(@NonNull List data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int layoutType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(viewGroup.getContext(),inflater.inflate(getLayoutIdByType(layoutType), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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

    /**
     * 根据viewType获取layoutId。
     * 适用于需要根据数据返回采用不同的布局的场景。
     */
    protected abstract int getLayoutIdByType(int viewType);

    /**
     * 根据当前位置返回不同的viewType，提供给getLayoutIdByType函数用于选择不同的布局文件。
     * 实际使用时，一般需要根据position获取到当前位置对应的数据，根据数据返回不同的viewType。
     */
    @Override
    public abstract int getItemViewType(int position);

    /**
     * 由调用者根据数据设置holder中的所有view。
     * @param holder 当前行所有view的holder
     * @param type viewType，来自getItemViewType返回值，在本函数中并无用处（用于getLayoutIdByType选择layout文件）
     * @param data 当前行对应的数据
     * @param position 当前行位置
     */
    protected abstract void onBindViewHolder(@NonNull ViewHolder holder, int type,Object data, int position);
}