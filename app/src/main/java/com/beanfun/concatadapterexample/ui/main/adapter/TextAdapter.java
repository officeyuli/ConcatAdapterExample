package com.beanfun.concatadapterexample.ui.main.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.R;
import com.beanfun.concatadapterexample.ui.main.viewholder.ButtonViewHolder;
import com.beanfun.concatadapterexample.ui.main.viewholder.TextViewHolder;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextViewHolder<String>> {
    private List<String> data ;

    @NonNull
    @Override
    public TextViewHolder<String>onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_string, parent, false);
        return new TextViewHolder<>(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder<String> holder, int position) {
        String obj = data.get(position);
        if(obj!=null){
            holder.onBind(obj);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return R.layout.item_type_string;
    }

    @Override
    public int getItemCount() {
        return data == null?0:data.size();
    }

    public void setData(List<String> data){
        this.data = data;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull TextViewHolder<String> holder) {
        super.onViewAttachedToWindow(holder);
        Log.e("yuli", "onViewAttachedToWindow: "+holder.getData());
    }
}
