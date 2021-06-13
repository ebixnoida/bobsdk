package com.bob.bobapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.bob.bobapp.utility.Util;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

 private Util util;

    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        context = this;

        util = new Util(context);
        getIds();
        handleListener();
        initializations();
        setIcon(util);
    }

    public abstract void getIds();

    public abstract void handleListener();

    abstract void initializations();

    abstract void setIcon(Util util);
}
