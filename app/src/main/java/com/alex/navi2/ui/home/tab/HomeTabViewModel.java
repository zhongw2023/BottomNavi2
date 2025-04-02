package com.alex.navi2.ui.home.tab;

import static androidx.lifecycle.Transformations.map;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 主页标签页的ViewModel类，用于管理标签页数据
 */
public class HomeTabViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = map(mIndex, input -> "Home Tab页面内容: " + input);

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
} 