
package com.bob.bobapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.activities.BOBActivity;
import com.bob.bobapp.adapters.ReportListAdapter;
import com.bob.bobapp.utility.Util;


public class ReportFragment extends BaseFragment {


    private String[] arrayTitle = {"Holdings", "Transactions", "SIP SWP STP Due","Investment Maturity","Realised Gain/Loss","Corporate Action","Insurance"};
    private int[]  arrayImage={R.drawable.transaction,R.drawable.transaction,R.drawable.transaction,R.drawable.transaction,R.drawable.transaction,R.drawable.transaction,R.drawable.transaction};
    private RecyclerView report;

    public ReportFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_report, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getIds(View view) {

        report=view.findViewById(R.id.rvReport);

    }

    @Override
    protected void handleListener() {

        BOBActivity.imgBack.setOnClickListener(this);
    }

    @Override
    protected void initializations() {

        BOBActivity.llMenu.setVisibility(View.GONE);

        BOBActivity.title.setText("Reports");

        setAdapter();

    }

    @Override
    protected void setIcon(Util util) {

    }

    private void setAdapter() {
        ReportListAdapter adapter= new ReportListAdapter(getActivity(), arrayTitle, arrayImage) {

            @Override
            public void getDetail(Fragment fragment) {

                replaceFragment(fragment);
            }
        };
        report.setAdapter(adapter);
    }

    public void replaceFragment(Fragment fragment) {

        ((BaseContainerFragment)getParentFragment()).replaceFragment(fragment, true);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.imgBack) {

            getActivity().onBackPressed();
        }
    }
}
