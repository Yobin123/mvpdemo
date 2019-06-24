package com.example.hybss.mvpdemo.utils.image;

import android.content.Context;

import com.example.hybss.mvpdemo.config.SysConfig;
import com.example.hybss.mvpdemo.utils.image.help.GlideImageLoader;
import com.example.hybss.mvpdemo.utils.image.help.IImageLoader;
import com.example.hybss.mvpdemo.utils.image.help.ImageConfig;


/**
 * ImgLoadUtil
 * 相关说明：ImgLoadUtil为图片加载工具类，目前是通过对Glide3.7的封装实现，若有需要可更换为其他图片加载框架（注释1）。
 * 使用步骤：
 * 1、在app下gradle中添加依赖compile 'com.github.bumptech.glide:glide:3.7.0';
 * 2、在application中初始化配置ImgLoadUtil.init(getApplicationContext());
 * 3、代码中调用ImgLoadUtil
 *   .with(context) // 传入上下文
 *   .url(imageUrl) // 传入图片地址
 *   .placeHolder(imageId) // 传入占位图id
 *   .listener(new ImageListener()) // 监听器
 *   .into(imageView) // 传入View
 *   … …
 * 4、具体可调用方法详见GlideImageLoader类。
 * 注释1（更换框架说明）：1、定义xxxImageLoader类实现IImageLoader接口，替换GlideImageLoader类（调用所选框架方法一一实现类中对应方法）；
 *                        2、在ImgLoadUtil的getLoader()方法中将原来的GlideImageLoader替换为xxxImageLoader。
 */

public class ImgLoadUtil {

    public static Context context;
    private static IImageLoader loader;

    public static void init(final Context context) {
        init(context, SysConfig.Image.CACHE_IMAGE_SIZE);
    }

    public static void init(final Context context, int cacheSize) {
        init(context, cacheSize, true);
    }

    /**
     * @param context   上下文
     * @param cacheSize   磁盘缓存大小
     * @param isInternalCD   true 磁盘缓存到应用的内部目录 / false 磁盘缓存到应用外部目录
     */
    public static void init(final Context context, int cacheSize, boolean isInternalCD) {
        ImgLoadUtil.context = context;
        getLoader().init(context, cacheSize, isInternalCD);
    }

    /**
     * 获取上下文（第一个必须调用的方法：ImgLoadUtil.with(context)...）
     *
     * @param context: 上下文
     * @return
     */
    public static ImageConfig.ConfigBuilder with(Context context) {
        return new ImageConfig.ConfigBuilder(context);
    }

    /**
     * 清除磁盘缓存
     */
    public static void clearDiskCache() {
        getLoader().clearDiskCache();
    }

    /**
     * 清除内存缓存
     */
    public static void clearMemory() {
        getLoader().clearMemory();
    }

    public static void trimMemory(int level) {
        getLoader().trimMemory(level);
    }

    public static void clearAllMemoryCaches() {
        getLoader().clearAllMemoryCaches();
    }

    public static void pauseRequests() {
        getLoader().pause();
    }

    public static void resumeRequests() {
        getLoader().resume();
    }

    /**
     * 获取当前的Loader
     *
     * @return
     */
    public static IImageLoader getLoader() {
        if (loader == null) {
            loader = new GlideImageLoader();
        }
        return loader;
    }
}
