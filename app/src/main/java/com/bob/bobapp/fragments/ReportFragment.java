
package com.bob.bobapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.adapters.ReportListAdapter;


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
    void getIds(View view) {

        report=view.findViewById(R.id.rvReport);

    }

    @Override
    void handleListener() {

    }

    @Override
    void initializations() {

        setAdapter();

    }

    private void setAdapter() {
        ReportListAdapter adapter=new ReportListAdapter(getActivity(),arrayTitle,arrayImage);
        report.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

    }
}
