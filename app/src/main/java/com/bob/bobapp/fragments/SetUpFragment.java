
package com.bob.bobapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.activities.BOBActivity;
import com.bob.bobapp.activities.WealthMgmtActivity;
import com.bob.bobapp.adapters.SetUpListAdapter;
import com.bob.bobapp.utility.Util;


public class SetUpFragment extends BaseFragment {

    private TextView txtNext;

    public SetUpFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_set_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getIds(View view) {

        txtNext = view.findViewById(R.id.txtNext);
    }

    @Override
    protected void handleListener() {

        txtNext.setOnClickListener(this);

        BOBActivity.imgBack.setOnClickListener(this);
    }

    @Override
    protected void initializations() {

        BOBActivity.llMenu.setVisibility(View.GONE);

        BOBActivity.title.setText("Setup");
    }

    @Override
    protected void setIcon(Util util) {

    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.txtNext) {

            replaceFragment(new WealthMgmtActivity());

        }else if (view.getId() == R.id.imgBack) {

            getActivity().onBackPressed();
        }
    }

    public void replaceFragment(Fragment fragment) {

        ((BaseContainerFragment)getParentFragment()).replaceFragment(fragment, true);
    }
}
