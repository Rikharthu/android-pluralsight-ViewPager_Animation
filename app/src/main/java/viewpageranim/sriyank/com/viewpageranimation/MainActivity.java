package viewpageranim.sriyank.com.viewpageranimation;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import viewpageranim.sriyank.com.transformers.DepthPage;
import viewpageranim.sriyank.com.transformers.Rotation;
import viewpageranim.sriyank.com.transformers.ZoomOut;


public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private int[] mImageId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageId = new int[]{
                R.drawable.image_1, R.drawable.image_2,
                R.drawable.image_3, R.drawable.image_4, R.drawable.image_5};

        // Locate the ViewPager in activity_main.xml
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        // Pass params to ViewPagerAdapter Class
        PagerAdapter adapter = new ViewPagerAdapter(MainActivity.this, mImageId);

        // Bind the ViewPager Adapter to the ViewPager
        mViewPager.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.zoom_out:
                mViewPager.setPageTransformer(true, new ZoomOut());
                break;

            case  R.id.depth_page:
                mViewPager.setPageTransformer(true, new DepthPage());
                break;

            case R.id.rotation_page:

                mViewPager.setPageTransformer(true, new Rotation());
            break;
        }

        return super.onOptionsItemSelected(item);
    }


}
