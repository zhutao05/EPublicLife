package com.cimcitech.epubliclife.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cimcitech.epubliclife.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cimcitech on 2017/7/13.
 */

public class HomeGridAViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Integer[] Images = {
            R.mipmap.home_grid_open_door_icon,
            R.mipmap.home_grid_password_icon,
            R.mipmap.home_grid_car_icon,
            R.mipmap.home_grid_message_icon,
    };

    private String[] texts = {
            "手机开门",
            "访问密码",
            "停车管理",
            "视频对讲",
    };

    public HomeGridAViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder wrapper = null;
        if (wrapper == null) {
            convertView = inflater.inflate(R.layout.home_grid_item_view, null);
            wrapper = new ViewHolder(convertView);
            convertView.setTag(wrapper);
        } else {
            wrapper = (ViewHolder) convertView.getTag();
        }
        wrapper.logoButton.setBackgroundResource(Images[position]);
        wrapper.tvLogo.setText(texts[position]);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.logoButton)
        ImageView logoButton;
        @Bind(R.id.tv_logo)
        TextView tvLogo;
        @Bind(R.id.homeLogoRe)
        RelativeLayout homeLogoRe;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
