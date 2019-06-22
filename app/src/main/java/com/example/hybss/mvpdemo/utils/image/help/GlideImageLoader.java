package com.example.hybss.mvpdemo.utils.image.help;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.hybss.mvpdemo.config.SysConfig;
import com.example.hybss.mvpdemo.utils.image.ImgLoadUtil;


public class GlideImageLoader implements IImageLoader {

    /**
     * @param context      上下文
     * @param cacheSize    磁盘缓存大小
     * @param isInternalCD true 磁盘缓存到应用的内部目录 / false 磁盘缓存到应用外部目录
     */
    @Override
    public void init(Context context, int cacheSize, boolean isInternalCD) {
        //设置磁盘缓存大小
        GlideBuilder builder = new GlideBuilder(context);
        if (isInternalCD) {//应用目录内
            builder.setDiskCache(new InternalCacheDiskCacheFactory(context, cacheSize * 1024 * 1024));
        } else {//应用目录外
            builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, cacheSize * 1024 * 1024));
        }
    }

    @Override
    public void request(final ImageConfig config) {
        RequestManager requestManager = Glide.with(config.getContext());
        DrawableTypeRequest request = getDrawableTypeRequest(config, requestManager);
        if (request == null) {
            return;
        }

        if (config.getPlaceHolderResId() > 0) {
            request.placeholder(config.getPlaceHolderResId());
        }

        //设置图片压缩方式
        int scaleMode = config.getScaleMode();
        switch (scaleMode) {
            case SysConfig.Image.CENTER_CROP:
                request.centerCrop();
                break;
            case SysConfig.Image.FIT_CENTER:
                request.fitCenter();
                break;
            default:
                request.fitCenter();
                break;
        }

        //设置缩略图
        if (config.getThumbnail() != 0) {
            request.thumbnail(config.getThumbnail());
        }

        //设置图片分辨率(px)
        if (config.getWidth() != 0 && config.getHeight() != 0) {
            request.override(config.getWidth(), config.getHeight());
        }

        //设置图片加载动画
        setAnimator(config, request);

        //设置错误图片
        if (config.getErrorResId() > 0) {
            request.error(config.getErrorResId());
        }

        if (config.isAsBitmap()) {
            request.asBitmap();
        }

        if (config.isGif()) {
            request.asGif();
        }

        //加载监听
        if (config.getListener() != null) {
            request.listener(new RequestListener() {
                @Override
                public boolean onException(Exception e, Object model, Target target, boolean isFirstResource) {
                    config.getListener().onFailed();
                    return false;
                }

                @Override
                public boolean onResourceReady(Object resource, Object model, Target target, boolean isFromMemoryCache, boolean isFirstResource) {
                    config.getListener().onSuccess();
                    return false;
                }
            });
        }

        if (config.getTarget() instanceof ImageView) {
            request.into((ImageView) config.getTarget());
        }
    }

    /**
     * 设置加载进入动画
     *
     * @param config
     * @param request
     */
    private void setAnimator(ImageConfig config, DrawableTypeRequest request) {
        if (config.getAnimationType() == SysConfig.Image.ANIMATION_ID) {
            request.animate(config.getAnimationId());
        } else if (config.getAnimationType() == SysConfig.Image.ANIMATION) {
            request.animate(config.getAnimation());
        }
    }

    @Nullable
    private DrawableTypeRequest getDrawableTypeRequest(ImageConfig config, RequestManager requestManager) {
        DrawableTypeRequest request = null;
        if (!TextUtils.isEmpty(config.getUrl())) {
            request = requestManager.load(config.getUrl());
        } else if (!TextUtils.isEmpty(config.getFilePath())) {
            request = requestManager.load(config.getFilePath());
        } else if (config.getResId() > 0) {
            request = requestManager.load(config.getResId());
        } else if (config.getFile() != null) {
            request = requestManager.load(config.getFile());
        }
        return request;
    }

    @Override
    public void pause() {
        Glide.with(ImgLoadUtil.context).pauseRequestsRecursive();
    }

    @Override
    public void resume() {
        Glide.with(ImgLoadUtil.context).resumeRequestsRecursive();
    }

    @Override
    public void clearDiskCache() {
        Glide.get(ImgLoadUtil.context).clearDiskCache();
    }

    @Override
    public void clearMemory() {
        Glide.get(ImgLoadUtil.context).clearMemory();
    }

    @Override
    public void trimMemory(int level) {
        Glide.with(ImgLoadUtil.context).onTrimMemory(level);
    }

    @Override
    public void clearAllMemoryCaches() {
        Glide.with(ImgLoadUtil.context).onLowMemory();
    }
}

