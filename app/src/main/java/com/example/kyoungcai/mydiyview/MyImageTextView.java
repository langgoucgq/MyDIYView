package com.example.kyoungcai.mydiyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kyoungcai.mydiyview.R;

/**
 * Created by KyoungCai on 2017/6/28.
 */

public class MyImageTextView extends LinearLayout {
    public MyImageTextView(Context context) {
        super(context);
    }

    public MyImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyImageTextView);
        ImageView imageView=new ImageView(context);
        TextView textView=new TextView(context);
        int resourceId=-1;
        for (int i = 0; i < typedArray.length(); i++) {
            int attr = typedArray.getIndex(i);
            switch (attr){
                case R.styleable.MyImageTextView_Oriental:
                    this.setOrientation(typedArray.getInt(R.styleable.MyImageTextView_Oriental,0)==1?LinearLayout.HORIZONTAL:LinearLayout.VERTICAL);
                    break;

                case R.styleable.MyImageTextView_Text:
                    resourceId = typedArray.getResourceId(R.styleable.MyImageTextView_Text, 0);
                    textView.setText(resourceId>0?typedArray.getResources().getText(resourceId):typedArray.getString(R.styleable.MyImageTextView_Text));
                    break;
                case R.styleable.MyImageTextView_Src:
                    resourceId=typedArray.getResourceId(R.styleable.MyImageTextView_Src,0);
                    imageView.setImageResource(resourceId>0?resourceId:R.mipmap.ic_launcher);
                    break;
            }
        }
        addView(imageView);
        addView(textView);
        typedArray.recycle();

    }

    public MyImageTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);




    }
}
