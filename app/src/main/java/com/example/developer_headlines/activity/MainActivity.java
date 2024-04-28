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
import androidx.fragment.app.FragmentTransaction;

import com.example.developer_headlines.R;
import com.example.developer_headlines.fragment.ContentFragment;
import com.example.developer_headlines.fragment.GiftFragment;
import com.example.developer_headlines.fragment.MainFragment;
import com.example.developer_headlines.fragment.ShareFragment;

/**
 * @Author liuyuhan
 * @Description 默认首页
 * @Date 18:41 2024/4/28
 **/
public class MainActivity  extends FragmentActivity {
	private DrawerLayout mDrawerLayout;
	private RelativeLayout rlHome, rlGift, rlShare;
	private int currentSelectItem = R.id.rl_home;
	private MainFragment mainFragment;
	private ShareFragment shareFragment;
	private GiftFragment giftFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDrawerLayout = findViewById(R.id.drawer_layout);
		findViewById(R.id.iv_menu).setOnClickListener(clickListener);

		// 初始化左侧菜单
		initLeftMenu();

//		contentFragment = new ContentFragment();
		mainFragment=new MainFragment();
		getSupportFragmentManager().beginTransaction().add(R.id.content_frame, mainFragment).commit();

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
		@Override
		public void onClick(View v) {
			if (currentSelectItem != v.getId()) {//防止重复点击
				currentSelectItem=v.getId();
				noItemSelect();
				changeFragment(v.getId());//设置fragment显示切换
				switch (v.getId()) {
					case R.id.rl_home:
						rlHome.setSelected(true);
						break;
					case R.id.rl_gift:
						rlGift.setSelected(true);
						break;
					case R.id.rl_share:
						rlShare.setSelected(true);
						break;
				}
				mDrawerLayout.closeDrawer(Gravity.LEFT);
			}
		}

		// 改变fragment的显示
		private void changeFragment(int resId) {
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//开启一个Fragment事务

			hideFragments(transaction);//隐藏所有fragment
			if(resId==R.id.rl_home){//主页
				if(mainFragment==null){//如果为空先添加进来.不为空直接显示
					mainFragment = new MainFragment();
					transaction.add(R.id.content_frame,mainFragment);
				}else {
					transaction.show(mainFragment);
				}
			}else if(resId==R.id.rl_share){
				if(shareFragment==null){
					shareFragment = new ShareFragment();
					transaction.add(R.id.content_frame,shareFragment);
				}else {
					transaction.show(shareFragment);
				}
			}else if(resId==R.id.rl_gift){
				if(giftFragment==null){
					giftFragment = new GiftFragment();
					transaction.add(R.id.content_frame,giftFragment);
				}else {
					transaction.show(giftFragment);
				}
			}
			transaction.commitAllowingStateLoss();//一定要记得提交事务
		}
	};

	/**
	 * @Author liuyuhan
	 * @Description 显示之前隐藏所有的Fragment
	 * @Date 18:49 2024/4/28
	 * @Param [transaction]
	 * @return void
	 **/
	private void hideFragments(FragmentTransaction transaction){
		if (mainFragment != null)//不为空才隐藏,如果不判断第一次会有空指针异常
			transaction.hide(mainFragment);
		if (shareFragment != null)
			transaction.hide(shareFragment);
		if (giftFragment != null)
			transaction.hide(giftFragment);
	}

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
