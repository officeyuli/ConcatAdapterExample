package com.beanfun.concatadapterexample.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beanfun.concatadapterexample.R;
import com.beanfun.concatadapterexample.ui.main.viewholder.ButtonViewHolder;

import java.util.List;

public class ButtonAdapter extends WrapperImpressionHandleAdapter<Integer, ButtonViewHolder> {
    private List<Integer> data;

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ButtonViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_button, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        Integer obj = data.get(position);
        if (obj != null) {
            holder.onBind(obj);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return R.layout.item_type_button;
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
