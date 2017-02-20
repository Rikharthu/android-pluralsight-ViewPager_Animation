package viewpageranim.sriyank.com.viewpageranimation;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class ViewPagerAdapter extends PagerAdapter {

    private static final String LOG_TAG = ViewPagerAdapter.class.getSimpleName();
    private Context mContext;

    private int[] mImageId;

    private LayoutInflater mInflater;

    public ViewPagerAdapter(Context context, int[] imageId) {

        this.mContext = context;
        this.mImageId = imageId;
    }


    @Override
    public int getCount() {
        return mImageId.length;

    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        ImageView imageFashion;

        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = mInflater.inflate(R.layout.viewpager_item, container,
                false);


        // Locate the ImageView in viewpager_item.xml
        imageFashion = (ImageView)itemView.findViewById(R.id.imageViewItem);

        // set the ImageView resource
        imageFashion.setImageResource(mImageId[position]);

        itemView.setTag("#"+position);
        if(position==1){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                itemView.setTranslationZ(1f);
            }
        }
        // Add viewpager_item.xml to ViewPager
        container.addView(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w(LOG_TAG,view.getTag().toString());
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        container.removeView((RelativeLayout) object);

    }

}
