package com.beanfun.concatadapterexample.ui.main.viewholder;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.beanfun.concatadapterexample.R;
import com.beanfun.concatadapterexample.ui.main.ConcatRecyclerViewUtil.BaseDataKeeperViewHolder;

public class ButtonViewHolder extends BaseDataKeeperViewHolder<Integer> {
    private final View view;

    public ButtonViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public void onBind(Integer index) {
        this.data = index;
        ((Button) this.view.findViewById(R.id.item_button)).setText("" + index);
    }
}
