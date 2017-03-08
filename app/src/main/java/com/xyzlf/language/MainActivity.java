package com.xyzlf.language;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xyzlf.languagelib.LanguageActivity;
import com.xyzlf.languagelib.LanguageConstant;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends BaseActivity {

    TextView modelNumTextDesc;
    TextView androidVerTextDesc;
    TextView osBuilderTextDesc;
    TextView osCpuTextDesc;
    TextView settingLanguageDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.device_info));

        modelNumTextDesc = (TextView) findViewById(R.id.device_model_number_desc);
        androidVerTextDesc = (TextView) findViewById(R.id.device_android_ver_desc);
        osBuilderTextDesc = (TextView) findViewById(R.id.device_builder_desc);
        osCpuTextDesc = (TextView) findViewById(R.id.device_processor_desc);

        settingLanguageDesc = (TextView) findViewById(R.id.setting_language_desc);

        TextView modelNumText = (TextView) findViewById(R.id.device_model_number);
        TextView androidVerText = (TextView) findViewById(R.id.device_android_ver);
        TextView osBuilderText = (TextView) findViewById(R.id.device_builder);
        TextView osCpuText = (TextView) findViewById(R.id.device_processor);
        modelNumText.setText(Build.MODEL);
        androidVerText.setText(Build.VERSION.RELEASE);
        osBuilderText.setText(String.valueOf(Build.VERSION.SDK_INT));
        osCpuText.setText(null != getCpuInfo() ? getCpuInfo()[0] : "");

        findViewById(R.id.setting_language_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LanguageActivity.class));
            }
        });
    }

    /**
     * 获取CPU Info
     *
     * @return
     */
    public String[] getCpuInfo() {
        String str1 = "/proc/cpuinfo";
        String str2 = "";
        String[] cpuInfo = {"", ""};
        String[] arrayOfString;
        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr, 8192);
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            for (int i = 2; i < arrayOfString.length; i++) {
                cpuInfo[0] = cpuInfo[0] + arrayOfString[i] + " ";
            }
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            cpuInfo[1] += arrayOfString[2];
            localBufferedReader.close();
        } catch (IOException e) {
        }
        return cpuInfo;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String str) {
        switch (str) {
            case LanguageConstant.EVENT_REFRESH_LANGUAGE:
                refreshView();
                break;
        }
    }

    private void refreshView() {
        modelNumTextDesc.setText(getString(R.string.device_model_number));
        androidVerTextDesc.setText(getString(R.string.device_android_ver));
        osBuilderTextDesc.setText(getString(R.string.device_os_build));
        osCpuTextDesc.setText(getString(R.string.device_os_cpu));

        settingLanguageDesc.setText(getString(R.string.language_setting));
    }

}