package com.da08.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Da08 on 2017. 8. 29..
 */

public class MySimpleCustomSquare extends View {
    public MySimpleCustomSquare(Context context) {
        super(context);
    }

    public MySimpleCustomSquare(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MySimpleCustomSquare(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 정의해줘야 쓸 수 있음
        int width = getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec);
        int height = getDefaultSize(getSuggestedMinimumHeight(),heightMeasureSpec);
        if(width > height){
            width = height;
        }else{
            height = width;
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        setWidth(getHeight());  // width의 길이는 height의 길이를 가져옴 -> 정사각형 만들기
        super.onDraw(canvas);
    }

}
