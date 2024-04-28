package com.example.developer_headlines.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import com.example.developer_headlines.R;
import com.example.developer_headlines.fragment.ContentFragment;

public class MainActivity  extends FragmentActivity {
	private DrawerLayout mDrawerLayout;
	private RelativeLayout rlHome, rlGift, rlShare;
	// 默认首页
	private int currentSelectItem = R.id.rl_home;
	private ContentFragment contentFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDrawerLayout = findViewById(R.id.drawer_layout);
		findViewById(R.id.iv_menu).setOnClickListener(clickListener);

		// 初始化左侧菜单
		initLeftMenu();

		contentFragment = new ContentFragment();
		getSupportFragmentManager().beginTransaction().add(R.id.content_frame, contentFragment).commit();

		setWindowStatus();
	}

	private void initLeftMenu(){
		rlHome = findViewById(R.id.rl_home);
		rlGift = findViewById(R.id.rl_gift);
		rlShare = findViewById(R.id.rl_share);

		rlHome.setOnClickListener(onLeftMenuClickListener);
		rlGift.setOnClickListener(onLeftMenuClickListener);
		rlShare.setOnClickListener(onLeftMenuClickListener);

		rlHome.setSelected(true);
	}

	// 监听抽屉内点击
	private final OnClickListener onLeftMenuClickListener = new OnClickListener() {
		@SuppressLint({"NonConstantResourceId", "RtlHardcoded"})
		@Override
		public void onClick(View v) {
			// 防止重复点击
			if (currentSelectItem != v.getId()){
				currentSelectItem = v.getId();
				noItemSelect();

				switch (v.getId()){
					case R.id.rl_home:
						rlHome.setSelected(true);
						contentFragment.setContent("这是首页");
						break;
					case R.id.rl_gift:
						rlGift.setSelected(true);
						contentFragment.setContent("这是礼物兑换");
						break;
					case R.id.rl_share:
						rlShare.setSelected(true);
						contentFragment.setContent("这是我的分享");
						break;
				}

				mDrawerLayout.closeDrawer(Gravity.LEFT);
			}
		}
	};

	private void noItemSelect(){
		rlHome.setSelected(false);
		rlGift.setSelected(false);
		rlShare.setSelected(false);
	}

	// 监听左边抽屉
	private final OnClickListener clickListener = new OnClickListener() {
		@SuppressLint("RtlHardcoded")
		@Override
		public void onClick(View v) {
			// 打开左边抽屉
			if (v.getId() == R.id.iv_menu) {
				mDrawerLayout.openDrawer(Gravity.LEFT);
			}
		}
	};

	// 设置状态栏
	private void setWindowStatus() {
		// 透明状态栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		// 设置状态栏颜色
		getWindow().setBackgroundDrawableResource(R.color.main_color);
	}
}
