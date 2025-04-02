package com.alex.navi2.ui.home.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alex.navi2.R;
import com.alex.navi2.databinding.FragmentHomeTabBinding;

/**
 * 主页中的标签页Fragment
 */
public class HomeTabFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private HomeTabViewModel viewModel;
    private FragmentHomeTabBinding binding;

    public static HomeTabFragment newInstance(int index) {
        HomeTabFragment fragment = new HomeTabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeTabViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        viewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentHomeTabBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHomeTab;
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
} 