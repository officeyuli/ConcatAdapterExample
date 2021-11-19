package com.beanfun.concatadapterexample.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.R;
import com.beanfun.concatadapterexample.ui.main.adapter.ButtonAdapter;
import com.beanfun.concatadapterexample.ui.main.adapter.HorizontalWrapperAdapter;
import com.beanfun.concatadapterexample.ui.main.adapter.TextAdapter;
import com.beanfun.concatadapterexample.ui.main.viewholder.TextViewHolder;

public class MainFragment extends Fragment {
    private View view;
    private MainViewModel mViewModel;
    private ButtonAdapter buttonAdapter;
    private TextAdapter textAdapter;
    private TextAdapter textAdapter2;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        buttonAdapter = new ButtonAdapter();
        textAdapter = new TextAdapter();
        textAdapter2 = new TextAdapter();
        HorizontalWrapperAdapter<String, TextViewHolder> wrapperAdapter = new HorizontalWrapperAdapter<>(textAdapter2);
        recyclerView.setAdapter(new ConcatAdapter(wrapperAdapter,buttonAdapter));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        view.findViewById(R.id.button1).setOnClickListener(view -> mViewModel.onIntegerIncreaseClick());
        view.findViewById(R.id.button2).setOnClickListener(view -> mViewModel.onStringIncreaseClick());
        initObserver();
    }

    private void initObserver() {
        mViewModel.getButtonData().observe(getViewLifecycleOwner(), dataList -> {
            if (dataList != null && dataList.size() > 0) {
                buttonAdapter.setData(dataList);
                buttonAdapter.notifyDataSetChanged();
            }
        });

        mViewModel.getTextData().observe(getViewLifecycleOwner(), dataList -> {
            if (dataList != null && dataList.size() > 0) {
                textAdapter.setData(dataList);
                textAdapter.notifyDataSetChanged();
                textAdapter2.setData(dataList);
                textAdapter2.notifyDataSetChanged();
            }
        });


    }

}