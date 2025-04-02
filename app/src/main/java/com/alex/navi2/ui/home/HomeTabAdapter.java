package com.alex.navi2.ui.home;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.alex.navi2.R;
import com.alex.navi2.ui.home.tab.HomeTabFragment;

/**
 * Fragment页面适配器，用于在Home页面中显示不同的标签页内容
 */
public class HomeTabAdapter extends FragmentStateAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public HomeTabAdapter(Context context, FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 实例化当前位置的Fragment
        return HomeTabFragment.newInstance(position + 1);
    }

    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getItemCount() {
        // 显示2个页面
        return 2;
    }
} 