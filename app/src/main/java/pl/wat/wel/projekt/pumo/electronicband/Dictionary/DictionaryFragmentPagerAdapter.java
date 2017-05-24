package pl.wat.wel.projekt.pumo.electronicband.Dictionary;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Damian Bondaruk on 2017-05-22.
 */

public class DictionaryFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTittles[] = new String[]{"Elementy", "Bramki logiczne", "Ogólne pojęcia", "Warsztat"};

    public DictionaryFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0: {
                fragment = new ElecElementsFragment();
                break;
            }
            case 1: {
                fragment = new ChipsFragment();
                break;
            }
            case 2: {
                fragment = new BasicTermsFragment();
                break;
            }
            case 3: {
                fragment = new WorkshopFragment();
                break;
            }
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTittles[position];
    }
}