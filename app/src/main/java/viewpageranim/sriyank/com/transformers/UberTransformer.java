package viewpageranim.sriyank.com.transformers;

import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;


public class UberTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.80f;
    private static final float MAX_TRANSLATION_X=.60f;
    private static final String LOG_TAG = UberTransformer.class.getSimpleName();

    @Override
    public void transformPage(View view, float position) {
        Log.d("UberTransformer", "view: " + view.getTag() + ", position: " + position);
        int pageWidth = view.getWidth();

//        view.setAlpha(.5f);
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
//            view.setTranslationX();
        } else if (position <= 0) { // [-1,0]
            // moving left
            // Use the default slide transition when moving to the left page
//            view.setAlpha(1);
//            view.setTranslationX(0);
//            view.setScaleX(1);
//            view.setScaleY(1);
            view.setTranslationX(-pageWidth*position + position*.2f*pageWidth);
        } else if (position <= 1) { // (0,1]
            // moving right
            // Fade the page out.


            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            Log.w(LOG_TAG,scaleFactor+"");
            // Counteract the default slide transition
            view.setTranslationX(pageWidth * -position+(pageWidth-pageWidth*scaleFactor));

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
//            view.setAlpha(0);
//            view.setTranslationX(pageWidth*.5f);

        }
        if(position==1){
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                view.setTranslationZ(1f);
//            }
        }
    }
}