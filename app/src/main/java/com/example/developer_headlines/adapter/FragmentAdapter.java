package com.example.developer_headlines.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @ClassName FragmentAdapter
 * @Description ViewPager适配器
 * @Author liuyuhan
 * @Date 2024/4/28 18:57
 * @Version 1.0
 **/
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> list;

    public FragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
