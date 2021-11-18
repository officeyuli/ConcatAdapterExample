package com.beanfun.concatadapterexample.ui.main.viewholder;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beanfun.concatadapterexample.R;
import com.beanfun.concatadapterexample.ui.main.adapter.BaseSetterViewHolder;

public class ButtonViewHolder<DataType> extends BaseSetterViewHolder<DataType> {
    private final View view;
    public ButtonViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public void onBind(Integer index){
        ((Button)this.view.findViewById(R.id.item_button)).setText("Botton"+index);
    }
}
