package com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.databinding.RecyclerviewHorizontalWrapperBinding;

public class HorizontalWrapperAdapter<childVH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<HorizontalWrapperViewHolder<childVH>> {
    private static final Integer WRAPPER_VIEW_TYPE = 9495;
    public static final Integer DEFAULT_SCROLL_POSITION = 0;
    private int lastScrollX = DEFAULT_SCROLL_POSITION;
    private final RecyclerView.Adapter<childVH> adapter;

    public HorizontalWrapperAdapter(RecyclerView.Adapter<childVH> adapter) {
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public HorizontalWrapperViewHolder<childVH> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HorizontalWrapperViewHolder<>(RecyclerviewHorizontalWrapperBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalWrapperViewHolder<childVH> holder, int position) {
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
