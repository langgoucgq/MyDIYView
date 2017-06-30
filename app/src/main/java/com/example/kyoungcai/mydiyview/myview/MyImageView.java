package com.example.kyoungcai.mydiyview.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by KyoungCai on 2017/6/28.
 */

@SuppressLint("AppCompatCustomView")
public class MyImageView extends ImageView {
    public MyImageView(Context context) {
        this(context,null);
    }


    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获得view的大小,xml中定义的宽
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);

        //高 xml中定义的高
        int defaultSize1 = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);


        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int min = Math.min(measuredWidth, measuredHeight);
        Log.i("cky",measuredWidth+"");

        //将控件的宽高设置成父容器推荐的宽高
        setMeasuredDimension(defaultSize,defaultSize);


    }
}
