package com.cxyzy.commonviewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * 通用 RecyclerView Holder
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private final Context mContext;
    private final SparseArray<View> mSparseArray;


    public ViewHolder(@NonNull Context context, @NonNull View itemView) {
        super(itemView);
        mSparseArray = new SparseArray<>();
        mContext = context;
    }

    @SuppressWarnings("unchecked")
    public final <T extends View> T getView(@IdRes int viewId) {
        View view = mSparseArray.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);     // 使用 RecyclerView.ViewHolder 保存的 itemView
            mSparseArray.put(viewId, view);
        }
        return (T) view;
    }


    /********************************** 常用函数 ****************************************/

    public ViewHolder setVisibility(int viewId, int visibility) {
        View view = getView(viewId);
        view.setVisibility(visibility);
        return this;
    }

    public ViewHolder setPadding(int viewId, int left, int top, int right, int bottom) {
        View view = getView(viewId);
        view.setPadding(left, top, right, bottom);
        return this;
    }

    public ViewHolder setSelected(int viewId, boolean selected) {
        View view = getView(viewId);
        view.setSelected(selected);
        return this;
    }

    public ViewHolder setBackgroundColor(int viewId, @ColorInt int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public ViewHolder setBackgroundRes(int viewId, @DrawableRes int resId) {
        View view = getView(viewId);
        view.setBackgroundResource(resId);
        return this;
    }

    public ViewHolder setBackgroundDrawable(int viewId, Drawable drawable) {
        View view = getView(viewId);
        view.setBackground(drawable);
        return this;
    }

    public ViewHolder setBackgroundBitmap(int viewId, Bitmap bitmap) {
        View view = getView(viewId);
        view.setBackground(new BitmapDrawable(mContext.getResources(), bitmap));
        return this;
    }

    public ViewHolder setEnabled(int viewId, boolean enabled) {
        View view = getView(viewId);
        view.setEnabled(enabled);
        return this;
    }

    public boolean isEnabled(int viewId) {
        return getView(viewId).isEnabled();
    }


    /********************************** 常用监听 ****************************************/

    public ViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public ViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public ViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

    /**
     * 设置 RecyclerView item 点击监听
     *
     * @param listener
     */
    public ViewHolder setOnItemClickListener(View.OnClickListener listener) {
        itemView.setClickable(true);
        itemView.setOnClickListener(listener);
        return this;
    }

    /**
     * 设置 RecyclerView item 长按监听
     *
     */
    public ViewHolder onItenLongClickListener(View.OnLongClickListener listener) {
        itemView.setLongClickable(true);
        itemView.setOnLongClickListener(listener);
        return this;
    }


    /********************************** TextView 相关函数 ****************************************/

    public ViewHolder setText(int viewId, CharSequence value) {
        TextView view = getView(viewId);
        view.setText(value);
        return this;
    }

    public ViewHolder setTextSize(int viewId, int testSize) {
        TextView view = getView(viewId);
        view.setTextSize(testSize);
        return this;
    }

    public ViewHolder setTextColor(int viewId, @ColorInt int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public ViewHolder setTextColorRes(int viewId, @ColorRes int colorResId) {
        TextView view = getView(viewId);
        view.setTextColor(ContextCompat.getColor(mContext,colorResId));
        return this;
    }

    public ViewHolder setTextDrawable(int viewId, Drawable left, Drawable top, Drawable right, Drawable bottom) {
        TextView textView = getView(viewId);
        textView.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        return this;
    }

    public ViewHolder addTextChangedListener(int viewId, TextWatcher watcher) {
        EditText editText = getView(viewId);
        editText.addTextChangedListener(watcher);
        return this;
    }


    /********************************** CheckBox 相关函数 ****************************************/

    public ViewHolder setOnCheckedChangeListener(int viewId, final CheckBox.OnCheckedChangeListener listener) {
        CheckBox checkBox = getView(viewId);
        checkBox.setOnCheckedChangeListener(listener);
        return this;
    }

    public ViewHolder setChecked(int viewId, boolean checked) {
        Checkable view = getView(viewId);
        view.setChecked(checked);
        return this;
    }

    public boolean isChecked(int viewId) {
        CheckBox checkBox = getView(viewId);
        return checkBox.isChecked();
    }


    /********************************** ProgressBar 相关函数 ****************************************/

    public ViewHolder setMax(int viewId, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        return this;
    }

    public ViewHolder setPressed(int viewId, boolean pressed) {
        View view = getView(viewId);
        view.setPressed(pressed);
        return this;
    }


    /********************************** ImageView 相关函数 *****************************************/

    public ViewHolder setImageResource(int viewId,@DrawableRes int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    public ViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }
}