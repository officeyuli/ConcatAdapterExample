package com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil;

public interface WrapperImpressionCallBack<dataType, childViewHolder extends BaseDataKeeperViewHolder<dataType>> {

    void recordImpression(childViewHolder holder);
}
