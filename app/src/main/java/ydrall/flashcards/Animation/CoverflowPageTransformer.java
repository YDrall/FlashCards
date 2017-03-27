package ydrall.flashcards.Animation;

import android.support.v4.view.ViewPager;
import android.view.View;

import ydrall.flashcards.Utils.Utils;

public class CoverflowPageTransformer implements ViewPager.PageTransformer {
    private float MIN_SCALE_X = 0.85f;
    private float MIN_SCALE_Y = 0.85f;
    private static final float MIN_ALPHA = 1.0f;

    public static final String TAG = "CoverTransformer";

    public static final float SCALE_MIN = 0.3f;
    public static final float SCALE_MAX = 1f;
    public static final float MARGIN_MIN = 0f;
    public static final float MARGIN_MAX = 50f;
    public float scale  = 0f;

    private float pagerMargin = 0f;
    private float spaceValue = 0f;
    private float rotationX    = 0f;
    private float rotationY    = 0f;

    public CoverflowPageTransformer(float scale, float pagerMargin,float spaceValue,float rotationY) {
        this.scale = scale;
        this.pagerMargin = pagerMargin;
        this.spaceValue  = spaceValue;
        this.rotationY   = rotationY;
    }

    @Override
    public void transformPage(View page, float position) {

        if(rotationY!=0){
            float realRotationY = Math.min(rotationY,Math.abs(position * rotationY));
            page.setRotationY(position < 0f ? realRotationY : - realRotationY);
        }

        if (scale != 0f) {
            float realScale = Utils.getFloat(1 - Math.abs(position * scale),SCALE_MIN,SCALE_MAX);
            page.setScaleX(realScale);
            page.setScaleY(realScale);
        }

        if (pagerMargin != 0) {

            float realPagerMargin = position * (pagerMargin);

            if (spaceValue != 0) {
                float realSpaceValue = Utils.getFloat(Math.abs(position * spaceValue),MARGIN_MIN,MARGIN_MAX);
                realPagerMargin += (position > 0) ? realSpaceValue : - realSpaceValue;
            }

            page.setTranslationX(realPagerMargin);
        }

    }
}