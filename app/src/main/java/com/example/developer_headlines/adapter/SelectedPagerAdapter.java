package com.example.developer_headlines.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.developer_headlines.R;
import com.example.developer_headlines.iview.ICarousePagerSelectView;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SelectedPagerAdapter
 * @Description 轮播动画 ViewPager适配器
 * @Author liuyuhan
 * @Date 2024/4/28 19:19
 * @Version 1.0
 **/
public class SelectedPagerAdapter extends PagerAdapter implements View.OnClickListener {
    private List<View> views;
    // 每页显示的图片
    private int[] images = new int[]{R.drawable.icon_selected_carousel_one,R.drawable.icon_selected_carousel_two,R.drawable.icon_selected_carousel_three};
    private ICarousePagerSelectView carousePagerSelectView;

    public SelectedPagerAdapter(Context context,ICarousePagerSelectView carousePagerSelectView){
        this.carousePagerSelectView=carousePagerSelectView;

        views=new ArrayList<View>();

        //初始化每页显示的View
        for(int i=0;i<images.length;i++){
            @SuppressLint("InflateParams") View item= LayoutInflater.from(context).inflate(R.layout.fragment_selected_pager_item, null);
            ImageView imageView= item.findViewById(R.id.imageview);
            imageView.setImageResource(images[i]);
            imageView.setTag(i);
            imageView.setOnClickListener(this);
            views.add(imageView);
        }
    }
    public List<View> getViews(){
        return views;
    }

    @Override
    public void onClick(View v) {
        int index = (int) v.getTag();
        carousePagerSelectView.carouseSelect(index);
    }

    @Override
    public int getCount() {
        return views == null ? 0 : views.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object){
        container.removeView(views.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position), 0);
        return views.get(position);
    }
}
