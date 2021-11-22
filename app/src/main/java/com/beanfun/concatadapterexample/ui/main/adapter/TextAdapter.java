package com.beanfun.concatadapterexample.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beanfun.concatadapterexample.R;
import com.beanfun.concatadapterexample.ui.main.viewholder.TextViewHolder;

import java.util.List;

public class TextAdapter extends WrapperImpressionHandleAdapter<String, TextViewHolder> {
    private List<String> data;

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_string, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
        String obj = data.get(position);
        if (obj != null) {
            holder.onBind(obj);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_type_string;
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
