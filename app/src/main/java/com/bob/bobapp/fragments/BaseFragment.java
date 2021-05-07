package com.bob.bobapp.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getIds(view);
        handleListener();
        initializations();
    }

    abstract void getIds(View view);

    abstract void handleListener();

    abstract void initializations();
}
