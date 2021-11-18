package com.beanfun.concatadapterexample.ui.main.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseSetterViewHolder<DataType> extends RecyclerView.ViewHolder {
    private DataType data;
    public BaseSetterViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    
    public void setData(DataType data){
        this.data = data;
    }
}
