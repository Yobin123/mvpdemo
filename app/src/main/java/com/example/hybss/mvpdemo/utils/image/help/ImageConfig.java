package com.example.hybss.mvpdemo.utils.image.help;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

import com.example.hybss.mvpdemo.config.SysConfig;
import com.example.hybss.mvpdemo.utils.image.ImgLoadUtil;

import java.io.File;


public class ImageConfig {
    private Context context;
    private String url; //网络图片地址
    private float thumbnail; //缩略图缩放倍数
    private String filePath; //文件路径

    private File file; //文件路径
    private int resId;  //资源id
    private boolean isGif; //是否是gif图
    private View target;
    private int width;
    private int height;

    private int animationType;
    private int animationId;
    private Animation animation;

    private int placeHolderResId;//占位图
    private int errorResId;//错误图

    private int shapeMode;//默认矩形,可选直角矩形,圆形/椭圆
    private int scaleMode;//填充模式,默认centerCrop,可选fit_center
    private boolean asBitmap;
    private ImageListener listener; //Glide监听器

    public ImageConfig(ConfigBuilder builder) {
        this.url = builder.url;
        this.thumbnail = builder.thumbnail;
        this.filePath = builder.filePath;
        this.file = builder.file;
        this.resId = builder.resId;
        this.target = builder.target;

        this.width = builder.width;
        this.height = builder.height;

        this.shapeMode = builder.shapeMode;
        this.scaleMode = builder.scaleMode;

        this.animationId = builder.animationId;
        this.animationType = builder.animationType;
        this.animation = builder.animation;

        this.placeHolderResId = builder.placeHolderResId;

        this.asBitmap = builder.asBitmap;
        this.isGif = builder.isGif;
        this.errorResId = builder.errorResId;
        this.listener = builder.listener;
    }

    public Context getContext() {
        if (context == null) {
            context = ImgLoadUtil.context;
        }
        return context;
    }

    public ImageListener getListener(){
        return listener;
    }

    public boolean isAsBitmap() {
        return asBitmap;
    }

    public int getErrorResId() {
        return errorResId;
    }

    public String getFilePath() {
        return filePath;
    }

    public File getFile() {
        return file;
    }

    public int getPlaceHolderResId() {
        return placeHolderResId;
    }

    public int getResId() {
        return resId;
    }

    public int getScaleMode() {
        return scaleMode;
    }

    public int getShapeMode() {
        return shapeMode;
    }

    public View getTarget() {
        return target;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getAnimationType() {
        return animationType;
    }

    public int getAnimationId() {
        return animationId;
    }

    public Animation getAnimation() {
        return animation;
    }

    public float getThumbnail() {
        return thumbnail;
    }

    public boolean isGif() {
        return isGif;
    }

    private void show() {
        ImgLoadUtil.getLoader().request(this);
    }

    public static class ConfigBuilder {
        private Context context;
        private String url;
        private float thumbnail;
        private String filePath;
        private File file;
        private int resId;
        private boolean isGif = false;

        private View target;
        private boolean asBitmap;

        private int width; //选择加载分辨率的宽
        private int height; //选择加载分辨率的高

        private int placeHolderResId;
        private int errorResId;

        private int shapeMode;//默认矩形,可选直角矩形,圆形/椭圆
        private int scaleMode;//填充模式,默认centerCrop,可选fit_center

        private int animationId; //动画资源id
        private int animationType; //动画资源Type
        private Animation animation; //动画资源
        private ImageListener listener; //Glide监听器

        public ConfigBuilder(Context context) {
            this.context = context;
        }

        /**
         * 图片url
         *
         * @param url
         * @return
         */
        public ConfigBuilder url(String url) {
            this.url = url;
            if (url.contains("gif")) {
                isGif = true;
            }
            return this;
        }

        /**
         * 占位图
         *
         * @param placeHolderResId
         * @return
         */
        public ConfigBuilder placeHolder(int placeHolderResId) {
            this.placeHolderResId = placeHolderResId;
            return this;
        }

        /**
         * error展示图
         *
         * @param errorResId
         * @return
         */
        public ConfigBuilder error(int errorResId) {
            this.errorResId = errorResId;
            return this;
        }

        /**
         * into: 加载图片控件
         *
         * @param view: 图片控件
         */
        public void into(View view) {
            this.target = view;
            new ImageConfig(this).show();
        }

        /**
         * 加载drawable资源
         *
         * @param resId
         * @return
         */
        public ConfigBuilder res(int resId) {
            this.resId = resId;
            return this;
        }

        /**
         * 设置为Bitmap
         *
         * @return
         */
        public ConfigBuilder asBitmap() {
            this.asBitmap = true;
            return this;
        }

        public ConfigBuilder listener(ImageListener listener){
            this.listener = listener;
            return this;
        }

        /**
         * 缩略图
         *
         * @param thumbnail
         * @return
         */
        public ConfigBuilder thumbnail(float thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        /**
         * 加载SD卡资源
         *
         * @param filePath：资源路径
         * @return
         */
        public ConfigBuilder file(String filePath) {
            if (filePath.startsWith("file:")) {
                this.filePath = filePath;
                return this;
            }

            if (!new File(filePath).exists()) {
                return this;
            }

            this.filePath = filePath;
            if (filePath.contains("gif")) {
                isGif = true;
            }
            return this;
        }

        /**
         * 加载SD卡资源
         *
         * @param file：资源
         * @return
         */
        public ConfigBuilder file(File file) {
            this.file = file;
            return this;
        }

        /**
         * 设置图片分辨率
         *
         * @param width：宽
         * @param height：高
         * @return
         */
        public ConfigBuilder override(int width, int height) {
            this.width = (int) (ImgLoadUtil.context.getResources().getDisplayMetrics().density * width + 0.5f);
            this.height = (int) (ImgLoadUtil.context.getResources().getDisplayMetrics().density * height + 0.5f);
            return this;
        }

        /**
         * 设置图片形状
         *
         * @param shapeMode 取值 SysConfig.Image: shape
         * @return
         */
        public ConfigBuilder shape(int shapeMode) {
            this.shapeMode = shapeMode;
            return this;
        }

        /**
         * 设置图片比例
         *
         * @param scaleMode 取值 SysConfig.Image: scale
         * @return
         */
        public ConfigBuilder scale(int scaleMode) {
            this.scaleMode = scaleMode;
            return this;
        }

        /**
         * 设置res中自定义动画
         *
         * @param animationId: 动画id
         * @return
         */
        public ConfigBuilder animate(int animationId) {
            this.animationType = SysConfig.Image.ANIMATION_ID;
            this.animationId = animationId;
            return this;
        }

        /**
         * 设置自定义动画
         *
         * @param animation: 动画对象
         * @return
         */
        public ConfigBuilder animate(Animation animation) {
            this.animationType = SysConfig.Image.ANIMATION;
            this.animation = animation;
            return this;
        }
    }

    //监听器
    public interface ImageListener{
        void onSuccess();

        void onFailed();
    }
}
