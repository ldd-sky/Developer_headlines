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
 * @ClassName ShareFragment
 * @Description 分享页
 * @Author liuyuhan
 * @Date 2024/4/28 19:30
 * @Version 1.0
 **/
public class ShareFragment extends Fragment {
    private TextView tvContent;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        @SuppressLint("InflateParams") View rootView=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_share, null);
        tvContent=(TextView) rootView.findViewById(R.id.tv_content);
        return rootView;
    }
}
