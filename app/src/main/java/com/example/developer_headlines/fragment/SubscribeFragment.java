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
 * @ClassName SubscribeFragment
 * @Description 订阅
 * @Author liuyuhan
 * @Date 2024/4/28 19:31
 * @Version 1.0
 **/
public class SubscribeFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_content, null);
        TextView tvContent = (TextView) rootView.findViewById(R.id.tv_content);
        tvContent.setText("订阅");
        return rootView;
    }
}
