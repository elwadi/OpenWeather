package systems.orca.mobile.openweather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import systems.orca.mobile.openweather.Android;
import systems.orca.mobile.openweather.Ios;
import systems.orca.mobile.openweather.Windows;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {
        case 0:
            return new Android();
        case 1:
            return new Ios();
        case 2:
            return new Windows();
        case 3:
            return new Position();
        }
		return null;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}


    }