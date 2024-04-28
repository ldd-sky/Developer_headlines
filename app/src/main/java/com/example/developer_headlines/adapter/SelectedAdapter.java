package com.example.developer_headlines.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.developer_headlines.R;
import com.example.developer_headlines.entity.SelectedArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SelectAdapter
 * @Description 精选列表适配器
 * @Author liuyuhan
 * @Date 2024/4/28 18:59
 * @Version 1.0
 **/
public class SelectedAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<SelectedArticle> selectedArticles;

    public SelectedAdapter(Context context){
        inflater = LayoutInflater.from(context);
        selectedArticles = new ArrayList<SelectedArticle>();
        initData();
    }

    // 填入一些虚假数据
    private void initData(){
        for(int i=0; i<50; i++){
            SelectedArticle selectedArticle = new SelectedArticle(i, "标题Test", i, i, "");
            selectedArticles.add(selectedArticle);
        }
    }

    @Override
    public int getCount() {
        return selectedArticles.size();
    }

    @Override
    public Object getItem(int position) {
        return selectedArticles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return selectedArticles.get(position).getId();
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.fragment_selected_item, null);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.tv_title);
            holder.like = convertView.findViewById(R.id.tv_like);
            holder.comment = convertView.findViewById(R.id.tv_comment);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SelectedArticle selectedArticle = selectedArticles.get(position);
        holder.title.setText(selectedArticle.getTitle());
        holder.like.setText("" + selectedArticle.getLikeNumber());
        holder.comment.setText("" + selectedArticle.getCommentNumber());
        return convertView;
    }

    private static class ViewHolder{
        private TextView title;
        private TextView like;
        private TextView comment;
    }
}
