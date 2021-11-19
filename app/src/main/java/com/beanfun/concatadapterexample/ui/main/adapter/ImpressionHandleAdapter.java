package com.beanfun.concatadapterexample.ui.main.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ImpressionHandleAdapter<dataType, childViewHolder extends BaseSetterViewHolder<dataType>> extends RecyclerView.Adapter<childViewHolder> {
    protected Boolean canRecordImpression = true;
    protected OnImpressionCallBack<dataType, childViewHolder> onImpressionCallBack;

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
            onImpressionCallBack.onImpressionFire(holder);
        }
    }

    public void setOnImpressionCallBack(OnImpressionCallBack<dataType, childViewHolder> onImpressionCallBack) {
        this.onImpressionCallBack = onImpressionCallBack;
    }
}
