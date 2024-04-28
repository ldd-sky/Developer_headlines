package com.example.developer_headlines.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.developer_headlines.R;
import com.example.developer_headlines.adapter.SelectedAdapter;
import com.example.developer_headlines.adapter.SelectedPagerAdapter;
import com.example.developer_headlines.iview.ICarousePagerSelectView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName SelectedFragment
 * @Description 精选
 * @Author liuyuhan
 * @Date 2024/4/28 19:24
 * @Version 1.0
 **/
public class SelectedFragment extends Fragment {
    private ViewPager viewPager;
    private SelectedPagerAdapter selectedPagerAdapter;

    // 底部点
    private ImageView[] tips;

    private Timer timer;
    //滚动间隔
    private final int CAROUSEL_TIME = 3000;
    //当前选中
    private int currentIndex=0;

    private TextView tvContent;
    private String[] carousePageStr=new String[]{"Android开发666","公众号:Ansen_666","Python 的练手项目有哪些值得推荐"};

    private ListView listView;
    private SelectedAdapter selectedAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        @SuppressLint("InflateParams") View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_selected, null);

        @SuppressLint("InflateParams") View headView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_selected_header, null);

        tvContent= headView.findViewById(R.id.tv_content);
        tvContent.setText(carousePageStr[0]);

        viewPager = headView.findViewById(R.id.viewpager);
        selectedPagerAdapter=new SelectedPagerAdapter(getActivity(),carousePagerSelectView);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(onPageChangeListener);
        viewPager.setAdapter(selectedPagerAdapter);

        ViewGroup group = headView.findViewById(R.id.viewGroup);// 初始化底部显示控件
        tips = new ImageView[3];
        for (int i = 0; i < tips.length; i++){
            ImageView imageView = new ImageView(getActivity());
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                imageView.setBackgroundResource(R.drawable.page_indicator_unfocused);
            }

            tips[i] = imageView;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 10;// 设置轮播点view的左边距
            layoutParams.rightMargin = 10;// 设置轮播点view的右边距
            group.addView(imageView, layoutParams);
        }

        timer = new Timer(true);//初始化计时器
        timer.schedule(task, 0, CAROUSEL_TIME);//延时0ms后执行,3000ms执行一次

        listView= rootView.findViewById(R.id.list);
        listView.addHeaderView(headView);
        listView.setAdapter(selectedAdapter=new SelectedAdapter(getActivity()));
        return rootView;
    }

    private final ICarousePagerSelectView carousePagerSelectView=new ICarousePagerSelectView() {
        @Override
        public void carouseSelect(int index) {
            Toast.makeText(getActivity(), carousePageStr[index], Toast.LENGTH_SHORT).show();
        }
    };

    TimerTask task = new TimerTask() {
        public void run() {
            handler.sendEmptyMessage(CAROUSEL_TIME);
        }
    };

    @SuppressLint("HandlerLeak")
    private final Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            // 若滚动到最后,则从第一页重新开始，否则开始下一页
            if (msg.what == CAROUSEL_TIME) {
                if (currentIndex >= tips.length - 1) {
                    viewPager.setCurrentItem(0);
                } else {
                    viewPager.setCurrentItem(currentIndex + 1);
                }
            }
        };
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        task.cancel();
        System.exit(0);
    }

    private final ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int index) {
            tvContent.setText(carousePageStr[index]);
            setImageBackground(index);// 改变轮播图下方点的切换效果
            currentIndex=index;
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2){}
        @Override
        public void onPageScrollStateChanged(int arg0) {}
    };

    // 改变轮播图下面的点
    private void setImageBackground(int selectItems) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectItems) {
                tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
            }
        }
    }
}
