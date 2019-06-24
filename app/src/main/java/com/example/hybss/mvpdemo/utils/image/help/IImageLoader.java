package com.example.hybss.mvpdemo.utils.image.help;

import android.content.Context;


public interface IImageLoader {
    void init(Context context, int cacheSize, boolean isInternalCD);

    void request(ImageConfig config);

    void pause();

    void resume();

    void clearDiskCache();

    void clearMemory();

    void trimMemory(int level);

    void clearAllMemoryCaches();
}
