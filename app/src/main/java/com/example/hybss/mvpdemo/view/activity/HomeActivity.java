package com.example.hybss.mvpdemo.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hybss.mvpdemo.R;
import com.example.hybss.mvpdemo.contract.activity.HomeContacts;
import com.example.hybss.mvpdemo.presenter.activity.HomePresenter;
import com.example.hybss.mvpdemo.utils.ToastUtil;
import com.example.hybss.mvpdemo.view.base.BaseActivity;
import com.example.hybss.mvpdemo.view.fagment.HomeFragment;
import com.example.hybss.mvpdemo.view.fagment.MeFragment;
import com.example.hybss.mvpdemo.view.fagment.NewFragment;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContacts.IHomeView {
    private FrameLayout fr_container;
    private TextView tv_home;
    private TextView tv_news;
    private TextView tv_mine;

    private HomeFragment homeFragment;
    private NewFragment newFragment;
    private MeFragment meFragment;

    private Fragment currentFragment;



    private void initFragment() {
        homeFragment = new HomeFragment();
        newFragment = NewFragment.newInstance();
        meFragment = MeFragment.newInstance();


        switchFragment(homeFragment).commit();
    }

    @Override
    protected HomePresenter bindPresenter() {
        return new HomePresenter(this); //绑定view和presenter
    }

    @Override
    protected int onLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        fr_container = fv(R.id.fr_container);
        tv_home = fv(R.id.tv_home);
        tv_news = fv(R.id.tv_news);
        tv_mine = fv(R.id.tv_mine);
    }

    @Override
    protected void addListener() {
        tv_home.setOnClickListener(this);
        tv_news.setOnClickListener(this);
        tv_mine.setOnClickListener(this);
    }

    @Override
    protected void setControl() {
        initFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_news:
                mvpPre.showNewsFragment();
                break;
            case R.id.tv_mine:
                mvpPre.showMeFragment();
                break;
            case R.id.tv_home:
            default:
                mvpPre.showHomeFragment();
                break;
        }
    }

    @Override
    public void showFragmentTip(String tag) {
        switch (tag) {
            case HomeContacts.HOME_PAGE:
//                ToastUtil.showLong(context,"点击了主页");
                switchFragment(homeFragment).commit();
                break;
            case HomeContacts.NEWS_PAGE:
//                ToastUtil.showLong(context,"点击了新闻");
                switchFragment(newFragment).commit();
                break;
            case HomeContacts.ME_PAGE:
//                ToastUtil.showLong(context,"点击了我的");
                switchFragment(meFragment).commit();
                break;
        }
    };


    private FragmentTransaction switchFragment(Fragment targetFragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(!targetFragment.isAdded()){
            if(currentFragment != null){
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.fr_container,targetFragment,targetFragment.getClass().getName());
        }else {
            transaction.hide(currentFragment).show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }


}
