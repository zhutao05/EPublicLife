package com.cimcitech.epubliclife.activity.housekeeper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cimcitech.epubliclife.R;

public class HouseKeeperActivity extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_house_keeper, container, false);
        return view;
    }
}
