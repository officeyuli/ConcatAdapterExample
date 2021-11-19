package com.beanfun.concatadapterexample.ui.main.adapter;

public interface OnImpressionCallBack<dataType, childViewHolder extends BaseSetterViewHolder<dataType>> {

    void onImpressionFire(childViewHolder holder);
}
