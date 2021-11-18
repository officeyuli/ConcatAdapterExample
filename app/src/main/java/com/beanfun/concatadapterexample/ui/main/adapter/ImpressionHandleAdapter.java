package com.beanfun.concatadapterexample.ui.main.adapter;

import androidx.recyclerview.widget.RecyclerView;

public abstract class ImpressionHandleAdapter<childViewHolder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<childViewHolder> {
    protected Boolean canRecordImpression = true;

    public void startRecord() {
        this.canRecordImpression = true;
    }

    public void stopRecord() {
        this.canRecordImpression = false;
    }
}
