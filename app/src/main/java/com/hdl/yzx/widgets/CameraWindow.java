package com.hdl.yzx.widgets;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import com.hdl.yzx.R;

public class CameraWindow {
    private static final String TAG = CameraWindow.class.getSimpleName();
    private static WindowManager windowManager;
    private static Context applicationContext;
    private static SurfaceView dummyCameraView;

    /**
     * @param context 应用上下文
     * @return void    返回类型
     * @Description 显示全局窗口
     * @date 2017-2-16 上午10:45:07
     * @author xhb
     */
    public static void show(Context context) {
        if (applicationContext == null) {
            applicationContext = context.getApplicationContext();
            windowManager = (WindowManager) applicationContext.getSystemService(Context.WINDOW_SERVICE);
            dummyCameraView = new SurfaceView(applicationContext);
            LayoutParams params = new LayoutParams();
            params.width = 1;
            params.height = 1;
            params.alpha = 0;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            } else {
                params.type = LayoutParams.TYPE_SYSTEM_ALERT;
            }
            params.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL
                    | LayoutParams.FLAG_NOT_FOCUSABLE
                    | LayoutParams.FLAG_NOT_TOUCHABLE;
            windowManager.addView(dummyCameraView, params);
            Log.d(TAG, TAG + " showing");
        }
    }

    /**
     * @return TODO(参数描述)
     * @Description 获取窗口视图
     * @date 2017-2-16 上午10:55:34
     * @author xhb
     */
    public static SurfaceView getDummyCameraView() {
        return dummyCameraView;
    }

    /**
     * @return void    返回类型
     * @Description 隐藏窗口
     * @date 2017-2-16 上午10:56:30
     * @author xhb
     */
    public static void dismiss() {
        try {
            if (windowManager != null && dummyCameraView != null) {
                windowManager.removeView(dummyCameraView);
                Log.d(TAG, TAG + " dismissed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
  
