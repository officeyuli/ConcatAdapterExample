package com.beanfun.concatadapterexample.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private Integer integerCount;
    private final List<Integer> buttonList;
    private final MutableLiveData<List<Integer>> buttonData;
    private Integer stringCount;
    private final List<String> textList;
    private final MutableLiveData<List<String>> textData;

    public MainViewModel() {
        integerCount = 0;
        stringCount = 0;
        buttonList = new ArrayList<>();
        textList = new ArrayList<>();
        buttonData = new MutableLiveData<>(buttonList);
        textData = new MutableLiveData<>(textList);
    }

    public LiveData<List<Integer>> getButtonData() {
        return buttonData;
    }

    public LiveData<List<String>> getTextData() {
        return textData;
    }

    public void onIntegerIncreaseClick(){
        integerCount++;
        buttonList.add(integerCount);
        buttonData.postValue(buttonList);
    }

    public void onStringIncreaseClick(){
        stringCount++;
        textList.add("這是第"+stringCount+"個文字");
        textData.postValue(textList);
    }
}