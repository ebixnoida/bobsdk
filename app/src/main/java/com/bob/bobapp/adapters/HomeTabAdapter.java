package com.bob.bobapp.adapters;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bob.bobapp.activities.BOBActivity;
import com.bob.bobapp.activities.OrderStatusActivity;
import com.bob.bobapp.activities.PortfolioAnalytics;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.fragments.AddTransactionFragment;
import com.bob.bobapp.fragments.DashboardFragment;
import com.bob.bobapp.fragments.ProfileFragment;
import com.bob.bobapp.fragments.QuickTransactionFragment;
import com.bob.bobapp.fragments.ReportFragment;
import com.bob.bobapp.fragments.SetUpFragment;

import java.util.ArrayList;

public class HomeTabAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    ArrayList<ClientHoldingObject> holdingArrayList;

    public HomeTabAdapter(Context context, FragmentManager fm, int totalTabs, ArrayList<ClientHoldingObject> holdingArrayList) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;

        this.holdingArrayList = holdingArrayList;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {

        Intent intent = null;

        switch (position) {

            case 0:
                DashboardFragment dashboardFragment = new DashboardFragment(holdingArrayList);
                return dashboardFragment;

            case 1:
                /*ReportFragment reportFragment = new ReportFragment();
                return reportFragment;*/
                intent = new Intent(myContext, PortfolioAnalytics.class);

                myContext.startActivity(intent);
            case 2:
                AddTransactionFragment addTransactionFragment = new AddTransactionFragment(holdingArrayList);
                return addTransactionFragment;

            case 3:
                /*QuickTransactionFragment quickTransactionFragment = new QuickTransactionFragment();
                return quickTransactionFragment;*/
                intent = new Intent(myContext, OrderStatusActivity.class);
                myContext.startActivity(intent);

            /*case 4:
                SetUpFragment setUpFragment = new SetUpFragment();
                return setUpFragment;*/

            case 4:
                ProfileFragment profileFragment = new ProfileFragment();
                return profileFragment;
            default:
                return null;
        }
    }

    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}

