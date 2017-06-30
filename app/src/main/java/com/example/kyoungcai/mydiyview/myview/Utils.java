package com.example.kyoungcai.mydiyview.myview;

import android.content.Context;

/**
 * Created by KyoungCai on 2017/6/28.
 */

public class Utils {

    public static int dp2px(Context context,float dp){
        final float density=context.getResources().getDisplayMetrics().density;
        return (int) (dp*density+0.5f);
    }

    public static int px2dp(Context context,float px){
        final float density=context.getResources().getDisplayMetrics().density;
        return (int) (px/density+0.5f);
    }

}
