package ca.uottawa.csi5389.vrhotel;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import ca.uottawa.csi5389.vrhotel.dao.VRItem;
import ca.uottawa.csi5389.vrhotel.fragment.DetailFragment;
import ca.uottawa.csi5389.vrhotel.fragment.GalleryFragment;
import ca.uottawa.csi5389.vrhotel.fragment.LocationFragment;
import ca.uottawa.csi5389.vrhotel.utils.ViewUtils;
import ca.uottawa.csi5389.vrhotel.view.MyScrollView;

/**
 * DetailActivity is the activity to shows the details of each hotel, showing locations, names, descriptions, addresses, pictures.
 */


public class DetailActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    //Bind the views
    @BindView(R.id.scrollView)
    public MyScrollView scrollView;
    @BindView(R.id.inside_fixed_bar)

    //Maybe use in the future to set up the dynamic tabs.
    //private LinearLayoutManager linearLayoutManager;
    //private int topHeight;

    public ViewPager viewPager;

    /**
     * ImageView points array
     */
    private ImageView[] tips;
    private ImageView[] mImageViews;

    /**
     * image resource ids
     */
    private int[] imgIdArray;
    private String title;
    private String text;

    FragmentManager fm;
    FragmentTransaction ft;
    Button summary, location, gallery;

    private DetailFragment detailFragment;
    private LocationFragment locationFragment;
    private GalleryFragment galleryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_detail);

        //ask for the location permission.
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        //Get intent from the MainActivity.
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        text = intent.getStringExtra("text");
        Toolbar app_bar = findViewById(R.id.toolbar);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        //Set the toolbar.
        setSupportActionBar(app_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        app_bar.inflateMenu(R.menu.main);

        setImagetoTop();
//        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //Maybe use in the future.
//        topHeight = ViewUtils.dip2px(this, 200);
//        linearLayoutManager = new LinearLayoutManager(this);

        summary = (Button) findViewById(R.id.summary);
        location = (Button) findViewById(R.id.location);
        gallery = (Button) findViewById(R.id.gallery);
        summary.setOnClickListener(this);
        location.setOnClickListener(this);
        gallery.setOnClickListener(this);

        //Automatically click at the beginning
        //Reference: https://stackoverflow.com/questions/35708453/how-to-automatically-click-a-button-in-android-after-a-5-second-delay
        summary.performClick();
    }

    //Reference: https://www.jb51.net/article/152864.htm
    private void initdetailFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (detailFragment == null) {
            detailFragment = new DetailFragment();

            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("text", text);
            detailFragment.setArguments(bundle);

            transaction.add(R.id.temFragment, detailFragment);
        }

        hideFragment(transaction);
        transaction.show(detailFragment);

        transaction.commit();
    }

    private void initlocationFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (locationFragment == null) {
            locationFragment = new LocationFragment();

            Bundle bundle = new Bundle();
            bundle.putString("key", VRItem.exchangeNameForId(title) + "");
            locationFragment.setArguments(bundle);

            transaction.add(R.id.temFragment, locationFragment);
        }

        hideFragment(transaction);
        transaction.show(locationFragment);

        transaction.commit();
    }

    private void initgalleryFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (galleryFragment == null) {
            galleryFragment = new GalleryFragment();

            Bundle bundle = new Bundle();
            bundle.putString("key", VRItem.exchangeNameForId(title) + "");
            galleryFragment.setArguments(bundle);

            transaction.add(R.id.temFragment, galleryFragment);

        }

        hideFragment(transaction);

        transaction.show(galleryFragment);

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (detailFragment != null) {
            transaction.hide(detailFragment);
        }
        if (locationFragment != null) {
            transaction.hide(locationFragment);
        }
        if (galleryFragment != null) {
            transaction.hide(galleryFragment);
        }
    }

    //set images on the top of the layout.
    public void setImagetoTop() {
        ViewGroup group = (ViewGroup) findViewById(R.id.viewGroup);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //Load picture id
        switch (VRItem.exchangeNameForId(title)) {
            case 1:
                imgIdArray = new VRItem().getTopImageforHotel1();
                break;
            case 2:
                imgIdArray = new VRItem().getTopImageforHotel2();
                break;
            case 3:
                imgIdArray = new VRItem().getTopImageforHotel3();
                break;
            case 4:
                imgIdArray = new VRItem().getTopImageforHotel4();
                break;
            case 5:
                imgIdArray = new VRItem().getTopImageforHotel5();
                break;
            case 6:
                imgIdArray = new VRItem().getTopImageforHotel6();
                break;
            default:
        }

        //Put points into ViewGroup
        tips = new ImageView[imgIdArray.length];
        for (int i = 0; i < tips.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(10, 10));
            tips[i] = imageView;
            if (i == 0) {
                tips[i].setBackgroundResource(R.drawable.focused);
            } else {
                tips[i].setBackgroundResource(R.drawable.unfocused);
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            group.addView(imageView, layoutParams);
        }

        //Put images into array
        mImageViews = new ImageView[imgIdArray.length];
        for (int i = 0; i < mImageViews.length; i++) {
            ImageView imageView = new ImageView(this);
            mImageViews[i] = imageView;
            imageView.setBackgroundResource(imgIdArray[i]);
        }

        //Set Adapter
        viewPager.setAdapter(new MyAdapter());
        //Set listener for points background
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem((mImageViews.length) * 100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == summary) {
            initdetailFragment();
        } else if (v == location) {
            initlocationFragment();
        } else if (v == gallery) {
            initgalleryFragment();
        }
    }

    public class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView(mImageViews[position % mImageViews.length]);
        }

        /**
         * Load images
         */
        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(mImageViews[position % mImageViews.length], 0);
            return mImageViews[position % mImageViews.length];
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        setImageBackground(arg0 % mImageViews.length);
    }

    /**
     * Set the backgrounds of tip
     *
     * @param selectItems
     */
    private void setImageBackground(int selectItems) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectItems) {
                tips[i].setBackgroundResource(R.drawable.focused);
            } else {
                tips[i].setBackgroundResource(R.drawable.unfocused);
            }
        }
    }

}
