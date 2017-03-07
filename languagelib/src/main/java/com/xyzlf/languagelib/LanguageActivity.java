package com.xyzlf.languagelib;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/**
 * 语言设置类
 * @author ZhangLifeng
 */
public class LanguageActivity extends AppCompatActivity implements OnItemClickListener {

    private List<LanguageCountry> mLanguageList = null;
    private ListView mLanguageListView = null;
    private LanguageListAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(R.layout.language_activity_language);

        initViews();
        initLanguageData();
    }

    private void initViews() {
        mLanguageListView = (ListView) findViewById(R.id.list_view);
        mLanguageListView.setOnItemClickListener(this);
    }

    private void initLanguageData() {
        mLanguageList = new ArrayList<>();
        // /<< 初始化需要的语言，需要添加更多语言在LanguageCountry类中加入
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.COUNTRY_OPTION_DEFAULT));

        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_EN));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_RU));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_ES));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_IT));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_ID));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_TR));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_DE));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_PT, LanguageCountry.COUNTRY_OPTION_BR));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_FR));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_VI));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_AR));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_TH));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_JA));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_KO));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_HU));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_HR));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_EL));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_MS));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_NL));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_SK));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_BG));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_UK));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_PL));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_SR));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_ZH, LanguageCountry.COUNTRY_OPTION_CN));
        mLanguageList.add(new LanguageCountry(this, LanguageCountry.LANGUAGE_OPTION_ZH, LanguageCountry.COUNTRY_OPTION_TW));

        if (null != mLanguageList) {
            mAdapter = new LanguageListAdapter(this, mLanguageList);
            mLanguageListView.setAdapter(mAdapter);
        }
    }

    private void selectLanguage(LanguageCountry item, boolean isAutoSet) {
        if (isAutoSet) {
            String langStr = Locale.getDefault().getLanguage();
            String countryStr = Locale.getDefault().getCountry();
            item = new LanguageCountry(this, langStr, countryStr);
//			GlobalPref.getIns().setLanguageValue("");
//			GlobalPref.getIns().setCountryNameValue("");
//			GlobalPref.getIns().setAutoSetLanguage(true);
        } else {
//			GlobalPref.getIns().setAutoSetLanguage(false);
//			Commons.setLanguageSelected(item);
        }
        setLanguage(item, this);

        LanguageActivity.this.finish();
    }

    // 更新app当前语言
    public static void setLanguage(LanguageCountry languageCountry, Context context) {
        if (null == languageCountry || null == context) {
            return;
        }
        Locale locale = new Locale(languageCountry.getLanguage(), languageCountry.getCountry());
        Resources res = context.getResources();
        if (null != res) {
            Configuration config = res.getConfiguration();
            if (null != config) {
                config.locale = locale;
            }
            DisplayMetrics dm = res.getDisplayMetrics();
            if (null != config && null != dm) {
                res.updateConfiguration(config, dm);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (null != mLanguageList) {
            boolean isAuto = false;
            LanguageCountry item = mLanguageList.get(position);
            if (null != mAdapter && null != item) {
                if (position == 0) {
                    mAdapter.setCurrentLang(LanguageCountry.LANGUAGE_OPTION_DEFAULT);
                    mAdapter.setCurrentCoun(LanguageCountry.COUNTRY_OPTION_DEFAULT);
                } else {
                    mAdapter.setCurrentLang(item.getLanguage());
                    mAdapter.setCurrentCoun(item.getCountry());
                }
                mAdapter.notifyDataSetChanged();
            }
            if (position == 0) {
                isAuto = true;
            }
            if (isAuto) {
                selectLanguage(null, isAuto);
            } else {
                selectLanguage(item, isAuto);
            }
        }
    }

}
