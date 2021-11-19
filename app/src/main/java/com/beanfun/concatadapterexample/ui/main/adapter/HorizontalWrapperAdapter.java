package com.beanfun.concatadapterexample.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.databinding.RecyclerviewHorizontalWrapperBinding;
import com.beanfun.concatadapterexample.ui.main.viewholder.HorizontalWrapperViewHolder;


public class HorizontalWrapperAdapter<dataType, childViewHolder extends BaseSetterViewHolder<dataType>> extends RecyclerView.Adapter<HorizontalWrapperViewHolder<dataType, childViewHolder>> {
    private static final Integer WRAPPER_VIEW_TYPE = 9495;
    public static final Integer DEFAULT_SCROLL_POSITION = 0;
    private final ImpressionHandleAdapter<dataType, childViewHolder> adapter;
    private int lastScrollX = DEFAULT_SCROLL_POSITION;


    public HorizontalWrapperAdapter(ImpressionHandleAdapter<dataType, childViewHolder> adapter) {
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
}
