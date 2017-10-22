package com.zsherry.project;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LaunchActivity extends AppCompatActivity {
    private TopHorizontalScrollView mTopHorizontalScrollView;
    private List<String> mButtonList;
    private CstTopBar mCstToolBar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private WalletsPagerAdapter mWalletsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        //主框架由我来做。
        initView();

    }
    private void initView(){
        mCstToolBar = (CstTopBar) findViewById(R.id.cst_tool_bar);
        mTopHorizontalScrollView = (TopHorizontalScrollView) findViewById(R.id.sv_top);
        mViewPager = (ViewPager) findViewById(R.id.vp_viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager.setOffscreenPageLimit(10);
        mTabLayout.setupWithViewPager(mViewPager);
        mCstToolBar.setCenter("头条");
        mButtonList = new ArrayList<>();
        mButtonList.add("最新");
        mButtonList.add("11");
        mButtonList.add("最新22");
        mButtonList.add("最新33");
        mButtonList.add("最新44");
        mButtonList.add("最新55");
        mButtonList.add("最新66");
        mButtonList.add("最新777");
        mButtonList.add("最新88");
        mButtonList.add("最新99");

        FirtFragment firtFragment = new FirtFragment();
        SecondFragment secondFragment = new SecondFragment();
        List<Fragment> list = new ArrayList<>();
        list.add(firtFragment);
        list.add(secondFragment);
        mWalletsPagerAdapter = new WalletsPagerAdapter(getSupportFragmentManager(),list);
        mViewPager.setAdapter(mWalletsPagerAdapter);

//        mTopHorizontalScrollView.showTopButtonView(mButtonList);
    }
    private class WalletsPagerAdapter extends FragmentStatePagerAdapter {
        List<Fragment> list ;

        public WalletsPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return position == 0?"first":"second";
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
