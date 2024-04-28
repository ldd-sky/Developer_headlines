package com.example.developer_headlines.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.developer_headlines.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MainFragment
 * @Description 主界面
 * @Author liuyuhan
 * @Date 2024/4/28 18:54
 * @Version 1.0
 **/
public class MainFragment extends Fragment {
    private int screenWidth, screenHeight;
    private List<Fragment> list = new ArrayList<>();
    private ViewPager vPager;
    private FragmentAdapter fragmentAdapter;
}
