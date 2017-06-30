package com.example.kyoungcai.mydiyview.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.kyoungcai.mydiyview.R;

import java.io.InputStream;

/**
 * Created by KyoungCai on 2017/6/28.
 */

public class MyView extends View {

    private String mtext;
    private int srcid;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        int textid = attrs.getAttributeResourceValue(null, "text", 0);

//        this.mtext=attrs.getAttributeValue(null,"text");
        int srcid=attrs.getAttributeResourceValue(null,"src",0);
        this.mtext=context.getResources().getString(textid);

        this.srcid=srcid;
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            paint.setColor(getContext().getColor(R.color.colorPrimary));
        }else{
            paint.setColor(Color.BLUE);
        }

        InputStream inputStream = getResources().openRawResource(srcid);

        Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
        int width = bitmap.getWidth();
        int height=bitmap.getHeight();
        paint.setTextSize(width/4);
        canvas.drawText(mtext,width/2,height/2,paint);
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
