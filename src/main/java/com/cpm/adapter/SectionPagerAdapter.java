package com.cpm.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cpm.fragment.CoveragePerformance;
import com.cpm.fragment.LoginPerformance;

/**
 * Created by neerajg on 2/7/2018.
 */

public class SectionPagerAdapter  extends FragmentPagerAdapter{

    private Bundle bundle;

    public SectionPagerAdapter(FragmentManager fm, Bundle bundle) {
        super(fm);
        this.bundle = bundle;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LoginPerformance loginPerformance = new LoginPerformance();
                loginPerformance.setArguments(bundle);
                return loginPerformance;

            case 1:
                CoveragePerformance attendancePerformance = new CoveragePerformance();
                attendancePerformance.setArguments(bundle);
                return attendancePerformance;

                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Login";

            case 1:
                return "Coverage";

                default:
                    return null;
        }
    }
}
