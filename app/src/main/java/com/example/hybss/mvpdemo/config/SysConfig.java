package com.example.hybss.mvpdemo.config;

import android.os.Environment;

import java.io.File;

/**
 * Created by liuguoyan on 2018/8/7.
 * 应用配置，和业务无关，如网络图片等
 */

public interface SysConfig {

    /**
     * 网络
     */
    public interface Http {
        //链接超时
        public static final int CONNECTION_TIME_OUT = 1000 * 10;
    }

    /**
     * 图片
     */
    public interface Image {
        /**
         * 默认磁盘缓存大小
         */
        int CACHE_IMAGE_SIZE = 250;
        /**
         * 等比例缩放图片，图片的宽高大于等于ImageView的宽度
         */
        int CENTER_CROP = 1;
        /**
         * 等比例缩放图片，图片的宽高小于等于ImageView的宽度
         */
        int FIT_CENTER = 2;
        /**
         * res中动画id
         */
        int ANIMATION_ID = 1;
        /**
         * 动画对象
         */
        int ANIMATION = 2;
    }

    /**
     * 数据库
     */
    public interface DB {

    }

    /**
     * Log
     */
    interface Log {
        /**
         * 应用异常日志保存路径
         */
        String PATH_LOG_CRASH = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + "crash" + File.separator;
        /**
         * 应用行为日志保存路径
         */
        String PATH_LOG_ACT = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + "act" + File.separator;
    }

}
