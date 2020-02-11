package com.qlf.common;

import android.app.Application;
import android.content.res.Configuration;
import android.nfc.Tag;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.NonNull;

public class BaseApplication extends Application {

    private  static  String TAG = "LifeCycleApplication";
    
    private  boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        // 程序创建的时候执行
        Log.d(TAG, "onCreate: ");
        if (isDebugARouter){
            ARouter.openLog();
            ARouter.openDebug();
        }

        ARouter.init(this);
    }

    @Override
    public void onTerminate() {
        //程序终止的时候执行
        Log.d(TAG, "onTerminate: ");
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //低内存的时候执行
        Log.d(TAG,"onLowMemory:");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        //程序在内存清理的时候执行 （回收内存）
        //HOME键退出应用程序，长按MENU键，打开Recent TASK 都会执行
        Log.d(TAG,"onTrimMemory");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }
}
