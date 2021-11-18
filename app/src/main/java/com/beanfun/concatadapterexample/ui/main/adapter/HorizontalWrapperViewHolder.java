package com.beanfun.concatadapterexample.ui.main.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.databinding.RecyclerviewHorizontalWrapperBinding;

public class HorizontalWrapperViewHolder<dataType,childViewHolder extends BaseSetterViewHolder<dataType>> extends RecyclerView.ViewHolder {
    private final RecyclerviewHorizontalWrapperBinding binding;
    public HorizontalWrapperViewHolder(@NonNull RecyclerviewHorizontalWrapperBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(RecyclerView.Adapter<childViewHolder> adapter,int lastScrollPosition, OnScrollCallback onScrollCallback){
        binding.recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(binding.getRoot().getContext(), RecyclerView.HORIZONTAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        OneShotPreDrawListener.add(binding.recyclerView, () -> {
            binding.recyclerView.scrollBy(lastScrollPosition, 0);
            Log.e("yuli", "bind: afterScroll" );
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
