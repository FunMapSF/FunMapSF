package com.funcheap.funmapsf.features.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.funcheap.funmapsf.features.list.home.ListHomeFragment;
import com.funcheap.funmapsf.features.map.MapFragment;

/**
 * Created by Jayson on 10/12/2017.
 *
 * Pager adapter that displays the Map and List fragments based on selected tabs
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    SparseArray<Fragment> registeredFragments = new SparseArray<>();

    private final String TAG = this.getClass().getSimpleName();
    private final int PAGE_COUNT = 2;
    private String mTabTitles[] = new String[] { "Map", "List" };

    private Context mContext;

    public HomePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MapFragment.newInstance();
            case 1:
                return ListHomeFragment.newInstance();
            default:
                Log.d(TAG, "Invalid tab value!");
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}
