
package com.bob.bobapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.activities.WealthMgmtActivity;
import com.bob.bobapp.adapters.SetUpListAdapter;


public class SetUpFragment extends BaseFragment {

    private TextView txtNext;

    public SetUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_set_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    void getIds(View view) {

        txtNext = view.findViewById(R.id.txtNext);
    }

    @Override
    void handleListener() {
        txtNext.setOnClickListener(this);
    }

    @Override
    void initializations() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtNext: {
                Intent intent = new Intent(getContext(), WealthMgmtActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
