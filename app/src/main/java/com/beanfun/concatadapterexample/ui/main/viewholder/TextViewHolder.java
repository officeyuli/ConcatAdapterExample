package com.beanfun.concatadapterexample.ui.main.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.beanfun.concatadapterexample.R;
import com.beanfun.concatadapterexample.ui.main.adapter.BaseSetterViewHolder;

public class TextViewHolder extends BaseSetterViewHolder<String> {
    private final View view;

    public TextViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public void onBind(String text) {
        data = text;
        ((TextView) this.view.findViewById(R.id.item_text)).setText(text);
    }

    public String getData() {
        return data;
    }
}
