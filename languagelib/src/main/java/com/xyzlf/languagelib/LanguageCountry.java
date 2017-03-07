package com.xyzlf.languagelib;

import android.content.Context;
import android.text.TextUtils;

public class LanguageCountry {
    // 语言
    public static final String LANGUAGE_OPTION_DEFAULT = "language_default";
    public static final String LANGUAGE_OPTION_BG = "bg";
    public static final String LANGUAGE_OPTION_EN = "en";
    public static final String LANGUAGE_OPTION_DE = "de";
    public static final String LANGUAGE_OPTION_ES = "es";
    public static final String LANGUAGE_OPTION_FR = "fr";
    public static final String LANGUAGE_OPTION_HU = "hu";
    public static final String LANGUAGE_OPTION_IT = "it";
    public static final String LANGUAGE_OPTION_KO = "ko";
    public static final String LANGUAGE_OPTION_PT = "pt";
    public static final String LANGUAGE_OPTION_RO = "ro";
    public static final String LANGUAGE_OPTION_RU = "ru";
    public static final String LANGUAGE_OPTION_TR = "tr";
    public static final String LANGUAGE_OPTION_VI = "vi";
    public static final String LANGUAGE_OPTION_ZH = "zh";
    public static final String LANGUAGE_OPTION_EL = "el";
    public static final String LANGUAGE_OPTION_HE = "iw";
    public static final String LANGUAGE_OPTION_HE2 = "he";
    public static final String LANGUAGE_OPTION_ID = "in";
    public static final String LANGUAGE_OPTION_ID2 = "id";
    public static final String LANGUAGE_OPTION_JA = "ja";
    public static final String LANGUAGE_OPTION_TH = "th";
    public static final String LANGUAGE_OPTION_UK = "uk";
    public static final String LANGUAGE_OPTION_SK = "sk";
    public static final String LANGUAGE_OPTION_AR = "ar";
    public static final String LANGUAGE_OPTION_NL = "nl";
    public static final String LANGUAGE_OPTION_NB = "nb";
    public static final String LANGUAGE_OPTION_PL = "pl";
    public static final String LANGUAGE_OPTION_HR = "hr";
    public static final String LANGUAGE_OPTION_CS = "cs";
    public static final String LANGUAGE_OPTION_HI = "hi";
    public static final String LANGUAGE_OPTION_MS = "ms";
    public static final String LANGUAGE_OPTION_SR = "sr";
    // 国家地区
    public static final String COUNTRY_OPTION_DEFAULT = "country_default";
    public static final String COUNTRY_OPTION_CN = "CN";
    public static final String COUNTRY_OPTION_TW = "TW";
    public static final String COUNTRY_OPTION_US = "US";
    public static final String COUNTRY_OPTION_BR = "BR";

    private String mLanguage;
    private String mCountry = "";
    private String mLanguageName = "";
    private Context mContext = null;

    public LanguageCountry(Context context, String language) {
        mLanguage = language;
        mContext = context;
        matchLanguageName();
    }

    // 同语种但不同国家的语言，需要传入country参数，
    // 例如language：LANGUAGE_OPTION_ZH，country：COUNTRY_OPTION_CN
    public LanguageCountry(Context context, String language, String country) {
        mLanguage = language;
        if (null == country) country = "";
        mCountry = country;
        mContext = context;
        matchLanguageName();
    }

    public void matchLanguageName() {
        mLanguageName = getStringOfLanguageName(R.string.language_en, "English");
        if (!TextUtils.isEmpty(mLanguage)) {
            if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_DE)) {
                mLanguageName = getStringOfLanguageName(R.string.language_de, "Deutsch");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_EL)) {
                mLanguageName = getStringOfLanguageName(R.string.language_el, "Eλληνικά");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_ES)) {
                if (!TextUtils.isEmpty(mCountry) && mCountry.equalsIgnoreCase(COUNTRY_OPTION_US)) {
                    mLanguageName = getStringOfLanguageName(R.string.language_es_us, "Español (Estados Unidos)");
                } else {
                    mLanguageName = getStringOfLanguageName(R.string.language_es, "Español");
                }
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_FR)) {
                mLanguageName = getStringOfLanguageName(R.string.language_fr, "Français");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_ID)) {
                mLanguageName = getStringOfLanguageName(R.string.language_id, "Bahasa Indonesia");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_PT)) {
                if (!TextUtils.isEmpty(mCountry) && mCountry.equalsIgnoreCase(COUNTRY_OPTION_BR)) {
                    mLanguageName = getStringOfLanguageName(R.string.language_pt_br, "Português (Brasil)");
                } else {
                    mLanguageName = getStringOfLanguageName(R.string.language_pt, "Português");
                }
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_HU)) {
                mLanguageName = getStringOfLanguageName(R.string.language_hu, "Magyar");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_HE)) {
                mLanguageName = mContext.getString(R.string.language_he);
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_HE2)) {
                mLanguage = LANGUAGE_OPTION_HE;
                mLanguageName =
                        mContext.getString(R.string.language_he);
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_ID2)) {
                mLanguage = LANGUAGE_OPTION_ID;
                mLanguageName = mContext.getString(R.string.language_id);
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_IT)) {
                mLanguageName = getStringOfLanguageName(R.string.language_it, "Italiano");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_JA)) {
                mLanguageName = getStringOfLanguageName(R.string.language_ja, "日本語");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_KO)) {
                mLanguageName = getStringOfLanguageName(R.string.language_ko, "한국어");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_RO)) {
                mLanguageName = mContext.getString(R.string.language_ro);
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_RU)) {
                mLanguageName = getStringOfLanguageName(R.string.language_ru, "Pусский");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_SK)) {
                mLanguageName = getStringOfLanguageName(R.string.language_sk, "Slovenčina");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_TH)) {
                mLanguageName = getStringOfLanguageName(R.string.language_th, "ไทย");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_TR)) {
                mLanguageName = getStringOfLanguageName(R.string.language_tr, "Türkçe");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_UK)) {
                mLanguageName = getStringOfLanguageName(R.string.language_uk, "Українська");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_VI)) {
                mLanguageName = getStringOfLanguageName(R.string.language_vi, "Tiếng Việt");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_ZH)) {
                if (!TextUtils.isEmpty(mCountry) && mCountry.equalsIgnoreCase(COUNTRY_OPTION_CN)) {
                    mLanguageName = getStringOfLanguageName(R.string.language_zh_cn, "中文 (简体)");
                } else if (!TextUtils.isEmpty(mCountry) && mCountry.equalsIgnoreCase(COUNTRY_OPTION_TW)) {
                    mLanguageName = getStringOfLanguageName(R.string.language_zh_tw, "中文 (繁體)");
                }
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_AR)) {
                mLanguageName = getStringOfLanguageName(R.string.language_ar, "العربية");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_NL)) {
                mLanguageName = getStringOfLanguageName(R.string.language_nl, "Nederlands");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_PL)) {
                mLanguageName = mContext.getString(R.string.language_pl);
                mLanguageName = getStringOfLanguageName(R.string.language_pl, "Polski");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_NB)) {
                mLanguageName = mContext.getString(R.string.language_nb);
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_HR)) {
                mLanguageName = getStringOfLanguageName(R.string.language_hr, "Hrvatski");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_CS)) {
                mLanguageName = mContext.getString(R.string.language_cs);
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_HI)) {
                mLanguageName = mContext.getString(R.string.language_hi);
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_MS)) {
                mLanguageName = getStringOfLanguageName(R.string.language_ms, "Bahasa Melayu");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_BG)) {
                mLanguageName = getStringOfLanguageName(R.string.language_bg, "български");
            } else if (mLanguage.equalsIgnoreCase(LANGUAGE_OPTION_SR)) {
                mLanguageName = getStringOfLanguageName(R.string.language_sr, "Srpski");
            }
        }
        // 如果上面匹配不到，则是默认的英语（包括英语国家和不支持的语种），所以将mLanguage和mCountry置为英语
        if (getStringOfLanguageName(R.string.language_en, "English").equalsIgnoreCase(mLanguage)) {
            mLanguage = LANGUAGE_OPTION_EN;
            mCountry = "";
        }
    }

    private String getStringOfLanguageName(int id, String defaultStr) {
        try {
            return mContext.getString(id);
        } catch (Exception e) {
            return defaultStr;
        }
    }

    public String getLanguage() {
        return mLanguage;
    }

    /*
     * 获得语言带上国家的参数，这样更有利于精确的区分国家 ex: zh-CN zh-TW 表示中文简体和中文繁体 ex: en-BR en-US 表示英国英语和美国英语
     */
    public String getLanguageWithCountry() {
        if (TextUtils.isEmpty(mCountry)) {
            return mLanguage;
        } else {
            return mLanguage + "-" + mCountry;
        }
    }

    public String getCountry() {
        return mCountry;
    }

    public String getLanguageName() {
        return mLanguageName;
    }

}
