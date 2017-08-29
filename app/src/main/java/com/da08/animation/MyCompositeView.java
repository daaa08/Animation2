package com.da08.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Da08 on 2017. 8. 29..
 */

public class MyCompositeView extends FrameLayout {
    public static final String BTN = "btn";
    public static final String IMG = "img";
    private static OnClickListener STATIC_LISTENER = null;
    private View mView;

    public MyCompositeView(@NonNull Context context) {
        this(context,null);
    }

    public MyCompositeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyCompositeView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mView = LayoutInflater.from(context).inflate(R.layout.item_menu,this,true);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MyCompositeView);
        int leftBtn = ta.getColor(R.styleable.MyCompositeView_left_btn,0);
        if(leftBtn != 0)
        mView.findViewById(R.id.btn).setBackgroundColor(leftBtn);
    }

    // listener 를 동적으로 넣기
//    public void setListener(Map<String,OnClickListener> listener){
//        findViewById(R.id.btn).setOnClickListener(listener.get(BTN));
//        findViewById(R.id.img).setOnClickListener(listener.get(IMG));
//    }

//    public void setStaticListener(OnClickListener listener){
//        STATIC_LISTENER = listener;
//    }
}
