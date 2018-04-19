package com.dxt2.monigouwu2;

import android.app.Application;
import android.content.SharedPreferences;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class ShoppingApplication extends Application {
    public static DbManager dbManager;
    public static SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();
        //xUtils的初始化
        x.Ext.init(this);
        x.Ext.setDebug(true);
        DbManager.DaoConfig config = new DbManager.DaoConfig().setDbName("sk.db")
                .setAllowTransaction(true).setDbVersion(1);
        dbManager = x.getDb(config);
        sp= getSharedPreferences("loginInfo",MODE_PRIVATE);
    }
}


















