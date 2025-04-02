package com.alex.navi2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.alex.navi2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private TabLayoutMediator tabLayoutMediator;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // 获取ViewModel实例
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // 使用视图绑定
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 设置标签页适配器
        HomeTabAdapter homeTabAdapter = new HomeTabAdapter(requireContext(), getChildFragmentManager(), getLifecycle());
        ViewPager2 viewPager = binding.viewPagerHome;
        viewPager.setAdapter(homeTabAdapter);
        
        // 设置TabLayout与ViewPager2关联
        TabLayout tabs = binding.tabsHome;
        tabLayoutMediator = new TabLayoutMediator(tabs, viewPager, (tab, position) -> {
            tab.setText(homeTabAdapter.getPageTitle(position));
        });
        tabLayoutMediator.attach();
        
        // 观察ViewModel中的数据变化
        homeViewModel.getSelectedTabPosition().observe(getViewLifecycleOwner(), position -> {
            // 当选项卡位置改变时，更新ViewPager
            if (viewPager.getCurrentItem() != position) {
                viewPager.setCurrentItem(position);
            }
        });
        
        // 监听ViewPager2页面变化
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                // 页面选中时的回调，更新ViewModel中的数据
                homeViewModel.setSelectedTabPosition(position);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (tabLayoutMediator != null) {
            tabLayoutMediator.detach();
        }
        binding = null;
    }
}