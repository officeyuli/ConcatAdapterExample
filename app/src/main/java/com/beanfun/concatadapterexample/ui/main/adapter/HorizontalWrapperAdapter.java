package com.beanfun.concatadapterexample.ui.main.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.databinding.RecyclerviewHorizontalWrapperBinding;


public class HorizontalWrapperAdapter<dataType, childViewHolder extends BaseSetterViewHolder<dataType>> extends RecyclerView.Adapter<HorizontalWrapperViewHolder<dataType, childViewHolder>> {
    private static final Integer WRAPPER_VIEW_TYPE = 9495;
    private final RecyclerView.Adapter<childViewHolder> adapter;
    private int lastScrollX = 0;


    public HorizontalWrapperAdapter(RecyclerView.Adapter<childViewHolder> adapter) {
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public HorizontalWrapperViewHolder<dataType, childViewHolder> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HorizontalWrapperViewHolder<>(RecyclerviewHorizontalWrapperBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalWrapperViewHolder<dataType, childViewHolder> holder, int position) {
        holder.bind(adapter, lastScrollX, scrollPosition -> lastScrollX = scrollPosition);
    }

    @Override
    public int getItemViewType(int position) {
        return WRAPPER_VIEW_TYPE;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull HorizontalWrapperViewHolder<dataType, childViewHolder> holder) {
        super.onViewAttachedToWindow(holder);
        Log.e("yuli", "WrapperAdapterAttach: ");
    }
}
