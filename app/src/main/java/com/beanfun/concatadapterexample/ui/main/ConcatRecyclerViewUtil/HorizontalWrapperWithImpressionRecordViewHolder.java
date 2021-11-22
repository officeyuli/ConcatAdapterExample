package com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil;

import static com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil.HorizontalWrapperAdapter.DEFAULT_SCROLL_POSITION;

import androidx.annotation.NonNull;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.databinding.RecyclerviewHorizontalWrapperBinding;
import com.beanfun.concatadapterexample.ui.main.adapter.WrapperImpressionHandleAdapter;

public class HorizontalWrapperWithImpressionRecordViewHolder<dataType, childVH extends BaseDataKeeperViewHolder<dataType>> extends RecyclerView.ViewHolder {
    private final RecyclerviewHorizontalWrapperBinding binding;

    public HorizontalWrapperWithImpressionRecordViewHolder(@NonNull RecyclerviewHorizontalWrapperBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(WrapperImpressionHandleAdapter<dataType, childVH> adapter, int lastScrollPosition, OnScrollCallback onScrollCallback) {
        binding.recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(binding.getRoot().getContext(), RecyclerView.HORIZONTAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        if (lastScrollPosition != DEFAULT_SCROLL_POSITION) {
            adapter.stopRecord();
        }
        OneShotPreDrawListener.add(binding.recyclerView, () -> {
            binding.recyclerView.scrollBy(lastScrollPosition, 0);
            adapter.startRecord();
        });

        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                onScrollCallback.OnScrolled(recyclerView.computeHorizontalScrollOffset());
            }
        });
    }
}
