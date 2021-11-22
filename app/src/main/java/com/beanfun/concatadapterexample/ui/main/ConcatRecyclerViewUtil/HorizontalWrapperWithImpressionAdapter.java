package com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.databinding.RecyclerviewHorizontalWrapperBinding;
import com.beanfun.concatadapterexample.ui.main.adapter.WrapperImpressionHandleAdapter;

public class HorizontalWrapperWithImpressionAdapter<dataType, childVH extends BaseDataKeeperViewHolder<dataType>> extends RecyclerView.Adapter<HorizontalWrapperWithImpressionRecordViewHolder<dataType, childVH>> {
    private static final Integer WRAPPER_VIEW_TYPE = 9496;
    public static final Integer DEFAULT_SCROLL_POSITION = 0;
    private int lastScrollX = DEFAULT_SCROLL_POSITION;
    private final WrapperImpressionHandleAdapter<dataType, childVH> adapter;

    public HorizontalWrapperWithImpressionAdapter(WrapperImpressionHandleAdapter<dataType, childVH> adapter) {
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public HorizontalWrapperWithImpressionRecordViewHolder<dataType, childVH> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HorizontalWrapperWithImpressionRecordViewHolder<>(RecyclerviewHorizontalWrapperBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalWrapperWithImpressionRecordViewHolder<dataType, childVH> holder, int position) {
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
