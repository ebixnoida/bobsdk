package com.bob.bobapp.Home;
import com.bob.bobapp.R;
import com.bob.bobapp.utility.Util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseContainerFragment extends Fragment {

    private Util util;

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {

        util = new Util(getActivity());

        if(getActivity().getCurrentFocus() != null) {

            util.hideKeyboard(getActivity().getCurrentFocus());
        }

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if (addToBackStack) {

            transaction.addToBackStack(null);
        }

        transaction.replace(R.id.container_framelayout, fragment);

        transaction.commitAllowingStateLoss();
    }

    public boolean popFragment() {

        boolean isPop = false;

        if (getChildFragmentManager().getBackStackEntryCount() > 0) {

            isPop = true;

            getChildFragmentManager().popBackStack();
        }

        return isPop;
    }

    public void clearBackStack() {

        try {

            FragmentManager fm = getChildFragmentManager();

            for (int i = 0; i < fm.getBackStackEntryCount(); i++) {

                fm.popBackStack();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void clearBackStackExceptFragment(Fragment fragment) {

        try {

            FragmentManager fm = getChildFragmentManager();

            for (int i = 0; i < fm.getBackStackEntryCount(); i++) {

                fm.popBackStack();
            }

            replaceFragment(fragment, true);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
