package com.cimcitech.epubliclife.widget;

import android.support.v4.app.Fragment;
import com.cimcitech.epubliclife.activity.home.HomeActivity;
import com.cimcitech.epubliclife.activity.housekeeper.HouseKeeperActivity;
import com.cimcitech.epubliclife.activity.shopping.ShoppingActivity;
import com.cimcitech.epubliclife.activity.user.UserActivity;

/**
 * Created by zhouwei on 17/4/23.
 */

public class DataGenerator {
    public static Fragment[] getFragments() {
        Fragment fragments[] = new Fragment[4];
        fragments[0] = new HomeActivity();
        fragments[1] = new HouseKeeperActivity();
        fragments[2] = new ShoppingActivity();
        fragments[3] = new UserActivity();
        return fragments;
    }
}
