package com.example.kyoungcai.mydiyview.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.kyoungcai.mydiyview.R;

import java.util.List;

/**
 * Created by KyoungCai on 2017/6/28.
 */

public class MyLayout extends RelativeLayout {


    private Bitmap bitmap;

    //每个小imageview的外边距
    private int margin;
    private int padding;

    private int mRowNum=0;

    private int mWidth;

    private List<Slice> list;

    private int mSliceViewWidth;

    private ImageView[] sliceArray;

    private boolean once=true;

    public MyLayout(Context context) {
        this(context,null);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyLayout);
        mRowNum=typedArray.getInt(R.styleable.MyLayout_rowNum,3);
        mRowNum=mRowNum<=0?1:mRowNum;
        typedArray.recycle();


        if(bitmap==null){
            bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.a2);
        }
        margin=Utils.dp2px(context,1);
        padding= min(getPaddingBottom(), getPaddingLeft(), getPaddingRight(), getPaddingTop());
        padding = (padding == 0) ? Utils.dp2px(getContext(), 1) : padding;


    }


    private int min(int... paddings) {
        int min = paddings[0];
        for (int padding : paddings) {
            if (padding < min) {
                min = padding;
            }
        }
        return min;
    }

    /**
     * 此方法会多次调用
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();


        mWidth=Math.min(measuredHeight,measuredWidth);
        Log.i("cky",mWidth+"");


        setMeasuredDimension(mWidth,mWidth);
        if(once){

            showSliceView(mRowNum);
            once=false;
        }
    }


    private void splitPic(){
        list = SliceUtil.splitPic(bitmap, mRowNum);
    }


    private void generateAndLayoutSliceView() {
        mSliceViewWidth = (mWidth - (padding * 2) - (margin * (mRowNum - 1))) / mRowNum;
        // 生成和布局显示切片的ImageView，并显示切片
        sliceArray = new ImageView[mRowNum * mRowNum];

        for (int i = 0; i < sliceArray.length; i++) {
            ImageView sliceView = new ImageView(getContext());
            Slice slice = list.get(i);
            // 显示切片
            sliceView.setImageBitmap(slice.getBitmap());
            // 为ImageView设置id，为了可以在相对布局的相对布局使用
            sliceView.setId(0x00001 + i);
            // 将切片View保存到对应的数据中
            sliceArray[i] = sliceView;
            // 定位ImageView显示的位置
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(mSliceViewWidth, mSliceViewWidth);
            // 列布局(判断除第一列外，其它切片View都在前一个切片View的右边)
            if (i % mRowNum != 0) {
                params.addRule(RelativeLayout.RIGHT_OF, sliceArray[i - 1].getId());
            }
            // 判断除最后一列外，其它切片View都的一个大小为margin的的右外边距
            if ((i + 1) % mRowNum != 0) {
                params.rightMargin = margin;
            }
            // 行布局(判断除第一行外，其它切片View都在上一行同列切片View的下边)
            if (i > mRowNum - 1) {
                params.addRule(RelativeLayout.BELOW, sliceArray[i - mRowNum].getId());
                // 判断除第一行外，其它行的切片View与上一行同列的切片View有上外边距margin
                params.topMargin = margin;
            }
            sliceView.setLayoutParams(params);
            // 上面确定了将切片View的大小和位置后就可以添加到容器中了
            addView(sliceView);
        }
    }


    public void showSliceView(int rowNum){
        this.mRowNum=rowNum;
        int childCount = getChildCount();
        if(childCount>0){
            removeAllViews();
        }

        splitPic();
        generateAndLayoutSliceView();
    }

}
