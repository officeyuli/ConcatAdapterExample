package com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil;

import androidx.annotation.NonNull;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.databinding.RecyclerviewHorizontalWrapperBinding;

public class HorizontalWrapperViewHolder<childVH extends RecyclerView.ViewHolder> extends RecyclerView.ViewHolder {
    private final RecyclerviewHorizontalWrapperBinding binding;

    public HorizontalWrapperViewHolder(@NonNull RecyclerviewHorizontalWrapperBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(RecyclerView.Adapter<childVH> adapter, int lastScrollPosition, OnScrollCallback onScrollCallback) {
        binding.recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(binding.getRoot().getContext(), RecyclerView.HORIZONTAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        OneShotPreDrawListener.add(binding.recyclerView, () -> {
            binding.recyclerView.scrollBy(lastScrollPosition, 0);
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
