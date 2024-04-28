package com.example.developer_headlines.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.developer_headlines.R;

/**
 * @Author liuyuhan
 * @Description 点击左测栏后的页面（这里为简单的更改页面的文字）
 * @Date 18:42 2024/4/28
 * @Param
 * @return
 **/
public class ContentFragment extends Fragment {
    private TextView tvContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_content, null);
        tvContent=rootView.findViewById(R.id.tv_content);
        return rootView;
    }

    public void setContent(String content){
        tvContent.setText(content);
    }
}
