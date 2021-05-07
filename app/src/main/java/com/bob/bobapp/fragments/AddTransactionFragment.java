
package com.bob.bobapp.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.adapters.AddTransactListAdapter;
import com.bob.bobapp.api.bean.ClientHoldingObject;

import java.util.ArrayList;


public class AddTransactionFragment extends BaseFragment {

    private RecyclerView rv;

    private AddTransactListAdapter adapter;

    private EditText etSearch;

    private String searchKey = "";

    private ArrayList<ClientHoldingObject> clientHoldingObjectArrayList;

    public AddTransactionFragment(ArrayList<ClientHoldingObject> clientHoldingObjectArrayList) {

        this.clientHoldingObjectArrayList = clientHoldingObjectArrayList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_add_transaction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    void getIds(View view) {

        rv=view.findViewById(R.id.rvTransaction);

        etSearch = view.findViewById(R.id.etSearch);
    }

    @Override
    void handleListener() {

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                searchKey = etSearch.getText().toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());
            }
        });
    }

    private void filter(String text) {

        ArrayList<ClientHoldingObject> filteredList = new ArrayList<>();

        for (ClientHoldingObject item : clientHoldingObjectArrayList) {

            if (item.getSchemeName() != null) {

                if (item.getSchemeName().toLowerCase().startsWith(text.toLowerCase())) {

                    filteredList.add(item);
                }
            }
        }

        adapter.updateList(filteredList);
    }


    @Override
    void initializations() {
        setAdapter();

    }

    private void setAdapter() {

        adapter =new AddTransactListAdapter(getActivity(), clientHoldingObjectArrayList);
        rv.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {

    }
}
