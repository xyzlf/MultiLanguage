package com.xyzlf.language;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

/**
 * Created by zhanglifeng on 2017/3/8.
 * Language Application
 */

public class LanguageApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        keepFontSize(base);

    }

    private void keepFontSize(Context base) {
        // 取消系统设置文字大小时对App的影响
        Resources resources = base.getResources();
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            configuration.fontScale = 1f;
//            configuration.setToDefaults();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        keepFontSize(this);
    }

}
