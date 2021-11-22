package com.beanfun.concatadapterexample.ui.main.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil.BaseDataKeeperViewHolder;
import com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil.WrapperImpressionCallBack;

public abstract class WrapperImpressionHandleAdapter<dataType, childViewHolder extends BaseDataKeeperViewHolder<dataType>> extends RecyclerView.Adapter<childViewHolder> {
    protected Boolean canRecordImpression = true;
    protected WrapperImpressionCallBack<dataType, childViewHolder> onImpressionCallBack;

    public void startRecord() {
        this.canRecordImpression = true;
    }

    public void stopRecord() {
        this.canRecordImpression = false;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull childViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (onImpressionCallBack != null && canRecordImpression) {
            onImpressionCallBack.recordImpression(holder);
        }
    }

    public void setOnImpressionCallBack(WrapperImpressionCallBack<dataType, childViewHolder> onImpressionCallBack) {
        this.onImpressionCallBack = onImpressionCallBack;
    }
}
