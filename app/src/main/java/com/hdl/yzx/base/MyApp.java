package com.hdl.yzx.base;

import android.app.Application;
import android.content.Intent;

import com.hdl.yzx.service.ConnectionService;
import com.hdl.yzx.utils.SpUtils;

public class MyApp extends Application {

    public void onCreate() {
        startService(new Intent(this, ConnectionService.class));
        super.onCreate();
        SpUtils.getInstance().initContext(this);
    }
}
