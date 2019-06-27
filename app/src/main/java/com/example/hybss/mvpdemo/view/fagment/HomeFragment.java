package com.example.hybss.mvpdemo.view.fagment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hybss.mvpdemo.R;
import com.example.hybss.mvpdemo.beans.WelfareBean;
import com.example.hybss.mvpdemo.contract.fragment.HomeFragmentContacts;
import com.example.hybss.mvpdemo.presenter.fragment.HomeFragmentPresenter;
import com.example.hybss.mvpdemo.utils.ToastUtil;
import com.example.hybss.mvpdemo.view.base.BaseFragment;

import java.util.List;


public class HomeFragment extends BaseFragment<HomeFragmentPresenter> implements HomeFragmentContacts.IHomeFragmentView {
    private Context context;

    private TextView tv_data;
    private Button btn_get;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity(); // 获取上下文
    }

    @Override
    protected HomeFragmentPresenter bindPresenter() {
        return new HomeFragmentPresenter(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initView(View view) {
        tv_data = fv(R.id.tv_data, view);
        btn_get = fv(R.id.btn_get, view);
    }

    @Override
    protected void addListener() {
        btn_get.setOnClickListener(this);
    }

    @Override
    protected void setControl() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                mvpPre.getWelfareData(10, 1);
                break;
        }
    }

    @Override
    public void showData(List<WelfareBean> welfareBeanList) {
        if (null != welfareBeanList && welfareBeanList.size() > 0) {
            tv_data.setText(welfareBeanList.get(0).getDesc());
        }
    }

    //请求的失败信息
    @Override
    public void onFailure(Throwable throwable) {
        ToastUtil.showShort(context, throwable.getMessage().toString());
    }
    
}
