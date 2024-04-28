package com.example.developer_headlines.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.developer_headlines.R;

/**
 * @ClassName FindFragment
 * @Description 发现界面
 * @Author liuyuhan
 * @Date 2024/4/28 18:50
 * @Version 1.0
 **/
public class FindFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_content, null);
        TextView tvContent = rootView.findViewById(R.id.tv_content);
        tvContent.setText("发现");
        return rootView;
    }
}
