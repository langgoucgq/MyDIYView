package com.example.kyoungcai.mydiyview.myview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KyoungCai on 2017/6/28.
 */

public class SliceUtil {


    public static List<Slice> splitPic(Bitmap bitmap,int slices){
        List<Slice> list=new ArrayList<>();


        if(slices>1){
            int width = bitmap.getWidth();
            int height=bitmap.getHeight();

            //切割图片的尺寸 方形
            int sliceWH=Math.min(width,height)/slices;

            for(int i=0;i<slices;i++){
                for(int j=0;j<slices;j++){

                    int index=i*sliceWH+j;

                    int x=j*sliceWH;
                    int y=i*sliceWH;

                    Bitmap sliceBitmap = Bitmap.createBitmap(bitmap, x, y, sliceWH, sliceWH);
                    Slice slice=new Slice(index,sliceBitmap);
                    list.add(slice);
                }
            }
        }
        return list;
    }
}
