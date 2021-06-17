package com.bob.bobapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.bob.bobapp.utility.Util;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    private Util util;

    private Context context;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        context = getActivity();

        util = new Util(context);

        getIds(view);

        handleListener();

        initializations();

        setIcon(util);
    }

    protected abstract void getIds(View view);

    protected abstract void handleListener();

    protected abstract void initializations();

    protected abstract void setIcon(Util util);
}
