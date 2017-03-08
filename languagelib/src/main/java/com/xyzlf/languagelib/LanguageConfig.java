package com.xyzlf.languagelib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * Created by zhanglifeng on 15/5/20.
 */
public class LanguageConfig {

    private SharedPreferences shardPreferences = null;

    public static LanguageConfig newInstance(Context context) {
        return new LanguageConfig(context);
    }

    private LanguageConfig(Context context) {
        if (null != context) {
            shardPreferences =  PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    private static final String LANGUAGE_SELECTED = "language_selected";
    private static final String COUNTRY_SELECTED = "country_selected";

    public void setLanguageValue(String language) {
        setStringValue(LANGUAGE_SELECTED, language);
    }

    public String getLanguageValue() {
        return getStringValue(LANGUAGE_SELECTED, LanguageCountry.LANGUAGE_OPTION_DEFAULT);
    }

    public void setCountryNameValue(String language) {
        setStringValue(COUNTRY_SELECTED, language);
    }

    public String getCountryNameValue() {
        return getStringValue(COUNTRY_SELECTED, LanguageCountry.COUNTRY_OPTION_DEFAULT);
    }


    /**
     * ********************************* 公共方法 ***********************************
     */
    private int getIntValue(String key, int defValue) {
        return null == shardPreferences ? defValue : shardPreferences.getInt(key, defValue);
    }

    private void setIntValue(String key, int value) {
        if (null == shardPreferences) {
            return;
        }
        Editor editor = shardPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    private long getLongValue(String key, long defValue) {
        return null == shardPreferences ? defValue : shardPreferences.getLong(key, defValue);
    }

    private void setLongValue(String key, Long value) {
        if (null == shardPreferences) {
            return;
        }
        Editor editor = shardPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    private boolean getBooleanValue(String key, boolean defValue) {
        return null == shardPreferences ? defValue : shardPreferences.getBoolean(key, defValue);
    }

    private void setBooleanValue(String key, boolean value) {
        if (null == shardPreferences) {
            return;
        }
        Editor editor = shardPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    private String getStringValue(String key, String defValue) {
        return null == shardPreferences ? defValue : shardPreferences.getString(key, defValue);
    }

    private void setStringValue(String key, String value) {
        if (null == shardPreferences) {
            return;
        }
        Editor editor = shardPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param key
     */
    public void remove(String key) {
        if (null == shardPreferences) {
            return;
        }
        Editor editor = shardPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /************************************ 公共方法 ************************************/
}
