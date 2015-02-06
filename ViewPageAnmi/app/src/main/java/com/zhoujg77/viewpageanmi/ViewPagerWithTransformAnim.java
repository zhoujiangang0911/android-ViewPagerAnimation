package com.zhoujg77.viewpageanmi;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 建刚 on 2015/2/6.
 */
public class ViewPagerWithTransformAnim extends ViewPager{

    private View mLeft;
    private View mRight;

    private float mTrans;
    private float mScale;

    private static final float MIN_SCALE=0.6f;

    private Map<Integer,View> mChildren = new HashMap<Integer,View>();

    public ViewPagerWithTransformAnim(Context context) {
        super(context);
    }

    public ViewPagerWithTransformAnim(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setViewForPosition(View view,int position){
            mChildren.put(position,view);
    }

    public void removeViewFromPosition(Integer position){
            mChildren.remove(position);
    }


    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
//        Log.i("---position","--"+position);
//        Log.i("---offset","--"+offset);
//        Log.i("---offsetPixels","--"+offsetPixels);
        mLeft = mChildren.get(position);
        mRight = mChildren.get(position+1);

        animStack(mLeft, mRight, offset, offsetPixels);
        super.onPageScrolled(position, offset, offsetPixels);

    }

    private void animStack(View Left, View Right, float offset, int offsetPixels) {
            if (Right != null){
            //第一页到第二页offset 0~1
            mScale = (1-MIN_SCALE)*offset+MIN_SCALE;
            mTrans =-getWidth()-getPageMargin()+offsetPixels;

            ViewHelper.setScaleX(Right,mScale);
            ViewHelper.setScaleY(Right,mScale);

            ViewHelper.setTranslationX(Right,mTrans);
        }
        if (Left != null){
            Left.bringToFront();
        }

    }

}
