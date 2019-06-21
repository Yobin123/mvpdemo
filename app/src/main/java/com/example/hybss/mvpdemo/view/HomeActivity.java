package com.example.hybss.mvpdemo.view;

import android.content.Context;
import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hybss.mvpdemo.R;
import com.example.hybss.mvpdemo.contract.HomeContacts;
import com.example.hybss.mvpdemo.presenter.HomePresenter;
import com.example.hybss.mvpdemo.view.base.BaseActivity;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContacts.IHomeView {
    private Context context;
    private FrameLayout fr_container;
    private TextView tv_home;
    private TextView tv_news;
    private TextView tv_mine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;
        initView();
    }

    private void initView() {
        fr_container = fv(R.id.fr_container);
        tv_home = fv(R.id.tv_home);
        tv_news = fv(R.id.tv_news);
        tv_mine = fv(R.id.tv_mine);
        
        tv_home.setOnClickListener(this);
        tv_news.setOnClickListener(this);
        tv_mine.setOnClickListener(this);
    }

    @Override
    protected HomePresenter bindPresenter() {
        return new HomePresenter(this); //绑定view和presenter
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
                Toast.makeText(context, "点击了首页", Toast.LENGTH_SHORT).show();
                break;
            case HomeContacts.NEWS_PAGE:
                Toast.makeText(context, "点击了新闻", Toast.LENGTH_SHORT).show();
                break;
            case HomeContacts.ME_PAGE:
                Toast.makeText(context, "点击了我的", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
