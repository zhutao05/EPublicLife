package com.cimcitech.epubliclife.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cimcitech.epubliclife.R;
import com.cimcitech.epubliclife.model.NewsVo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cimcitech on 2017/7/14.
 */

public class HomeAdapter extends BaseAdapter {

    private List<NewsVo> data;

    private LayoutInflater inflater;

    public HomeAdapter(Context context, List<NewsVo> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        NewsVo item = data.get(i);
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            view = inflater.inflate(R.layout.home_adapter_item_view, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvTitle.setText(item.getTitle());
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
