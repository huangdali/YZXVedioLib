package com.hdl.yzx.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * http库的sp管理工具
 * Created by HDL on 2017/11/20.
 *
 * @author HDL
 */

public class SpUtils {
    /**
     * 使用单例模式，因为很多地方会频繁用到此类，比如获取token
     */
    private static SpUtils mSpUtils;
    /**
     * 文件名
     */
    private static final String KEY_FILENAME = "account";
    /**
     * 是否登录
     */
    private static final String KEY_ISLOGIN = "isLogin";
    /**
     * token
     */
    private static final String KEY_TOKEN = "token";
    /**
     * 用户id
     */
    private static final String KEY_UID = "uId";
    /**
     * mac地址
     */
    private static final String KEY_MAC = "mac";
    /**
     * 上下文对象，建议传入的时候使用context.getApplicationContext()防止内存泄露
     */
    private Context context;

    private SpUtils() {
    }

    public static SpUtils getInstance() {
        if (mSpUtils == null) {
            synchronized (SpUtils.class) {
                if (mSpUtils == null) {
                    mSpUtils = new SpUtils();
                }
            }
        }
        return mSpUtils;
    }

    /**
     * 初始化
     *
     * @param context
     */
    public void initContext(Context context) {
        this.context = context;
    }

    /**
     * 保存是否登录
     *
     * @param isLogin 是否已经登录
     */
    public void saveIsLogin(boolean isLogin) {
        if (context != null) {
            SharedPreferences sp = context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE);
            sp.edit().putBoolean(KEY_ISLOGIN, isLogin).apply();
        }
    }

    /**
     * 是否已经登录过
     *
     * @return
     */
    public boolean isLogin() {
        if (context != null) {
            return context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE).getBoolean(KEY_ISLOGIN, false);
        }
        return false;
    }

    /**
     * 通过key保存值
     *
     * @param key
     * @param value
     */
    public void saveBooleanByKey(String key, boolean value) {
        if (context != null && !TextUtils.isEmpty(key)) {
            SharedPreferences sp = context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE);
            sp.edit().putBoolean(key, value).apply();
        }
    }

    /**
     * 通过key获取值
     *
     * @param key
     * @return
     */
    public boolean getBooleanByKey(String key) {
        if (context != null && !TextUtils.isEmpty(key)) {
            return context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE).getBoolean(key, false);
        }
        return false;
    }

    /**
     * 保存token
     *
     * @param token
     */
    public void saveToken(String token) {
        if (context != null) {
            SharedPreferences sp = context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE);
            sp.edit().putString(KEY_TOKEN, token).apply();
        }
    }

    /**
     * 获取token
     *
     * @return
     */
    public String getToken() {
        if (context != null) {
            return context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE).getString(KEY_TOKEN, "");
        }
        return "";

    }

    /**
     * 通过key保存值
     *
     * @param key
     * @param value
     */
    public void saveStringByKey(String key, String value) {
        if (context != null && !TextUtils.isEmpty(value) && !TextUtils.isEmpty(key)) {
            SharedPreferences sp = context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE);
            sp.edit().putString(key, value).apply();
        }
    }

    /**
     * 通过key获取值
     *
     * @param key
     * @return
     */
    public String getStringByKey(String key) {
        if (context != null && !TextUtils.isEmpty(key)) {
            return context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE).getString(key, "");
        }
        return "";
    }

    /**
     * 保存用户id
     *
     * @param uId
     */
    public void saveUId(String uId) {
        if (context != null) {
            SharedPreferences sp = context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE);
            sp.edit().putString(KEY_UID, uId).apply();
        }
    }

    /**
     * 获取用户id
     *
     * @return
     */
    public String getUId() {
        if (context != null) {
            return context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE).getString(KEY_UID, "");
        }
        return "";
    }

    /**
     * 保存mac
     *
     * @param mac
     */
    public void saveMac(String mac) {
        if (context != null) {
            SharedPreferences sp = context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE);
            sp.edit().putString(KEY_MAC, mac).apply();
        }
    }

    /**
     * 获取用户id
     *
     * @return
     */
    public String getMac() {
        if (context != null) {
            return context.getSharedPreferences(KEY_FILENAME, Context.MODE_PRIVATE).getString(KEY_MAC, "");
        }
        return "";
    }

}
