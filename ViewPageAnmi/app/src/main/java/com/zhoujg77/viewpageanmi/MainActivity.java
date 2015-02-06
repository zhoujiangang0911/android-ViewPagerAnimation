package com.zhoujg77.viewpageanmi;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
   // private ViewPagerCompart mViewPager;
    private ViewPagerWithTransformAnim mViewPager;
    private int [] imgIds= new int []{R.drawable.guide_image1,R.drawable.guide_image2,R.drawable.guide_image3,};
    private List<ImageView> imgLists = new ArrayList<ImageView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_my);
        //mViewPager = (ViewPagerCompart) findViewById(R.id.view_page);
        mViewPager = (ViewPagerWithTransformAnim) findViewById(R.id.view_page);
        //为ViewPager添加动画效果3.0以上
        //mViewPager.setPageTransformer(true,new RotateDownPageTransformer());
       // mViewPager.setPageTransformer(true,new RotateDownPageTransformer());

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(imgIds[position]);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(imageView);
                imgLists.add(imageView);
                mViewPager.setViewForPosition(imageView,position);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                   container.removeView(imgLists.get(position));
                  mViewPager.removeViewFromPosition(position);
            }

            @Override
            public int getCount() {
                return imgIds.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {

                return view == object;
            }
        });

    }


}
