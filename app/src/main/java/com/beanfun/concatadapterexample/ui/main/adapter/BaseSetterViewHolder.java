package com.beanfun.concatadapterexample.ui.main.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseSetterViewHolder<DataType> extends RecyclerView.ViewHolder {
    protected DataType data;

    public BaseSetterViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public DataType getData() {
        return data;
    }

    public void setData(DataType data) {
        this.data = data;
    }
}
