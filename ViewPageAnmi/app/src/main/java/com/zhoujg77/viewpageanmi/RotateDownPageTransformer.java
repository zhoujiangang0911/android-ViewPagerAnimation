package com.zhoujg77.viewpageanmi;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by 建刚 on 2015/2/6.
 */
public class RotateDownPageTransformer implements ViewPager.PageTransformer {

    private static float MAX_ROTATE=20f;
    //A页角度变化0~-20，B页角度变化20~0
       private float mRot;
    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        /**
         * A页切换到B页 A页的position 0.0~-1 B页的position 1~0.0
         */
        if (position < -1) { // [-Infinity,-1) A页

            ViewHelper.setRotation(view, 0);

        } else if (position <= 0) { // [-1,0]   B页
            //0~-20
            mRot = position*MAX_ROTATE;

            ViewHelper.setPivotX(view,pageWidth/2);
            ViewHelper.setPivotY(view,pageHeight);
            ViewHelper.setRotation(view,mRot);
        } else if (position <= 1) { // (0,1]
            //20~0
            mRot = position*MAX_ROTATE;

            ViewHelper.setPivotX(view,pageWidth/2);
            ViewHelper.setPivotY(view,pageHeight);
            ViewHelper.setRotation(view,mRot);

        } else { // (1,+Infinity]
            ViewHelper.setRotation(view, 0);

        }
    }
}
