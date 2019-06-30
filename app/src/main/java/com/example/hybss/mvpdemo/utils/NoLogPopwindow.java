package com.example.hybss.mvpdemo.utils;

import android.widget.PopupWindow;

/**
 * Created by Famous on 2018/4/8.
 */

public class NoLogPopwindow extends PopupWindow {

//    private Context context;
//    //0是普通登录提示,1是评论登录提示
//    private String flag;
//    private View view;
//
//    public NoLogPopwindow(Context context, String flag) {
//
//        this.context =context;
//        this.flag=flag;
//
//        //设置屏幕透明度
//        WindowManager.LayoutParams lp=((Activity) this.context).getWindow().getAttributes();
//        lp.alpha = 0.5f;
//        ((Activity) this.context).getWindow().setAttributes(lp);
//
//
//        final LayoutInflater inflater = (LayoutInflater) context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        view = inflater.inflate(R.layout.view_nologin, null);
//
//        TextView title= (TextView) view.findViewById(R.id.title);
//        RelativeLayout close= (RelativeLayout) view.findViewById(R.id.close_rl);
//        close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dismiss();
//            }
//        });
//        Button Login= (Button) view.findViewById(R.id.log_bt);
//        Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(NoLogPopwindow.this.context,LoginActivity.class);
//                intent.putExtra("MyNoLogin",true);
//                NoLogPopwindow.this.context.startActivity(intent);
//                dismiss();
//
//            }
//        });
//
//
//        ImageView top_iv= (ImageView) view.findViewById(R.id.top_iv);
//
//        if (StringUtils.isEmpty(flag)){
//            top_iv.setImageResource(R.mipmap.nologcommon);
//
//        }else{
//            top_iv.setImageResource(R.mipmap.nologpinglun);
//            SpannableString spanableInfo = new SpannableString("根据《互联网跟帖评论服务管理规定》,评论前需用手机号登录");
//            spanableInfo.setSpan(new Clickable(clickListener),2,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            title.setText(spanableInfo);
//            //文字点击后阴影效果
//            //title.setMovementMethod(LinkMovementMethod.getInstance());
//        }
//
//
//        setContentView(view);
//        setFocusable(true);
//        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//        setOnDismissListener(new OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp=((Activity) NoLogPopwindow.this.context).getWindow().getAttributes();
//                lp.alpha = 1f;
//                ((Activity) NoLogPopwindow.this.context).getWindow().setAttributes(lp);
//            }
//        });
//
//    }
//
//    private View.OnClickListener clickListener=new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//        }
//    };
//
//    class Clickable extends ClickableSpan {
//        private final View.OnClickListener mListener;
//
//        public Clickable(View.OnClickListener l) {
//            mListener = l;
//        }
//
//        /**
//         * 重写父类点击事件
//         */
//        @Override
//        public void onClick(View v) {
//            mListener.onClick(v);
//        }
//
//        /**
//         * 重写父类updateDrawState方法  我们可以给TextView设置字体颜色,背景颜色等等...
//         */
//        @Override
//        public void updateDrawState(TextPaint ds) {
//            ds.setColor(ContextCompat.getColor(context,R.color.app_highlight));
//        }
//    }

}
