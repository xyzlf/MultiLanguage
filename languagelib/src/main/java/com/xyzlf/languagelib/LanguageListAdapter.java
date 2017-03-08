package com.xyzlf.languagelib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LanguageListAdapter extends BaseAdapter {

    private Context mContext;
    private List<LanguageCountry> mLanguageLists = null;
    private String mCurrentLang;
    private String mCurrentCoun;

    public LanguageListAdapter(Context context, List<LanguageCountry> languageList) {
        mContext = context;
        mLanguageLists = languageList;

        LanguageConfig config = LanguageConfig.newInstance(context);
        mCurrentLang = config.getLanguageValue();
        mCurrentCoun = config.getCountryNameValue();
    }

    public void setCurrentLang(String currentLang) {
        mCurrentLang = currentLang;
    }

    public void setCurrentCoun(String currentCoun) {
        mCurrentCoun = currentCoun;
    }

    @Override
    public int getCount() {
        return mLanguageLists.size();
    }

    @Override
    public Object getItem(int position) {
        return mLanguageLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.language_list_item, null);
            holder = new ViewHolder();
            holder.mLanguageTv = (TextView) convertView.findViewById(R.id.language_item_content);
            holder.mImageIcon = (ImageView) convertView.findViewById(R.id.language_item_icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position == 0) {
            holder.mLanguageTv.setText(mContext.getResources().getString(R.string.language_default));
            if (LanguageCountry.LANGUAGE_OPTION_DEFAULT.equalsIgnoreCase(mCurrentLang)) {
                holder.mImageIcon.setVisibility(View.VISIBLE);
            } else {
                holder.mImageIcon.setVisibility(View.GONE);
            }
        } else {
            LanguageCountry languageCountry = mLanguageLists.get(position);
            if (null != languageCountry) {
                holder.mLanguageTv.setText(languageCountry.getLanguageName());
                if (mCurrentLang.equalsIgnoreCase(languageCountry.getLanguage())) {
                    if (LanguageCountry.LANGUAGE_OPTION_ZH.equalsIgnoreCase(languageCountry.getLanguage())) {
                        if (mCurrentCoun.equalsIgnoreCase(languageCountry.getCountry())) {
                            holder.mImageIcon.setVisibility(View.VISIBLE);
                        } else {
                            holder.mImageIcon.setVisibility(View.GONE);
                        }
                    } else {
                        holder.mImageIcon.setVisibility(View.VISIBLE);
                    }
                } else {
                    holder.mImageIcon.setVisibility(View.GONE);
                }
            }
        }

        return convertView;
    }

    private class ViewHolder {
        TextView mLanguageTv;
        ImageView mImageIcon;
    }

}
