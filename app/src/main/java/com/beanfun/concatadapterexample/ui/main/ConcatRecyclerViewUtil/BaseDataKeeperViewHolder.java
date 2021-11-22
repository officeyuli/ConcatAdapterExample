package com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseDataKeeperViewHolder<DataType> extends RecyclerView.ViewHolder {
    protected DataType data;

    public BaseDataKeeperViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public DataType getData() {
        return data;
    }

    public void setData(DataType data) {
        this.data = data;
    }
}
