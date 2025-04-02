package com.alex.navi2.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * HomeFragment的ViewModel，管理UI相关数据
 */
public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<Integer> mSelectedTabPosition;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        
        // 初始化选中的标签页位置为0
        mSelectedTabPosition = new MutableLiveData<>();
        mSelectedTabPosition.setValue(0);
    }

    public LiveData<String> getText() {
        return mText;
    }
    
    /**
     * 获取当前选中的标签页位置
     */
    public LiveData<Integer> getSelectedTabPosition() {
        return mSelectedTabPosition;
    }
    
    /**
     * 设置当前选中的标签页位置
     */
    public void setSelectedTabPosition(int position) {
        mSelectedTabPosition.setValue(position);
    }
}