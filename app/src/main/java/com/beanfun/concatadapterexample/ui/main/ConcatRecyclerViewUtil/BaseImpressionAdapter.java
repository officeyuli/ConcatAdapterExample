package com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseImpressionAdapter<dataType, VH extends BaseDataKeeperViewHolder<dataType>> extends RecyclerView.Adapter<VH> {
    protected Boolean canRecordImpression = true;
    private WrapperImpressionCallBack<dataType, VH> impressionRecord;

    public void setImpressionRecord(WrapperImpressionCallBack<dataType, VH> impressionRecord) {
        this.impressionRecord = impressionRecord;
    }

    public void startRecord() {
        this.canRecordImpression = true;
    }

    public void stopRecord() {
        this.canRecordImpression = false;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull VH holder) {
        super.onViewAttachedToWindow(holder);
        if (impressionRecord != null && canRecordImpression) {
            impressionRecord.recordImpression(holder);
        }
    }
}
