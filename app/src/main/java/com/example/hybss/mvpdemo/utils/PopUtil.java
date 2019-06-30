package com.example.hybss.mvpdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PopUtil {

//    /**
//     * @param context 上下文
//     * @param content 提示内容
//     * @param type    提示类型 “0” 代表不可合并 "1"代表提示退出登录
//     */
//    public TipPopWindow(final Context context, String content, final String type) {
//        this.mContext = context;
//        //设置屏幕透明度
//        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
//        lp.alpha = 0.3f;
//        ((Activity) mContext).getWindow().setAttributes(lp);
//
//        final LayoutInflater inflater = (LayoutInflater) context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        view = inflater.inflate(R.layout.layout_third_bind_tip, null);
//        TextView tv_tip = (TextView) view.findViewById(R.id.tv_tip);
//        tv_tip.setText(content);
//        TextView sure_tv = (TextView) view.findViewById(R.id.sure_tv);
//        sure_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (type) {
//                    case "1":
//                        DataSupport.deleteAll(UserDateSourceBean.class);    //删除数据库中多余的数据
//                        logToken();
//                        MyApplication.getInstance().setUser(null);
//                        ActivityUtils.removeAll();
//                        startActivity(new Intent(context, LoginActivity.class));
//                        if (MainActivity.instance != null) {
//                            MainActivity.instance.finish();
//                        }
//                        dismiss();
//                        finish();
//                        break;
//                    case "0":
//                    default:
//                        dismiss();
//                }
//
//            }
//        });
//
//        setContentView(view);
//        setFocusable(true);
//        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//        setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
//                lp.alpha = 1f;
//                ((Activity) mContext).getWindow().setAttributes(lp);
//            }
//        });
//
//    }
//}

}
