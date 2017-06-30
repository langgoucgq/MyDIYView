package com.example.kyoungcai.mydiyview.myview;

import android.graphics.Bitmap;

/**
 * Created by KyoungCai on 2017/6/28.
 */

public class Slice {


    private int index;
    private Bitmap bitmap;

    public Slice() {
    }

    public Slice(int index, Bitmap bitmap) {
        this.index = index;
        this.bitmap = bitmap;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
