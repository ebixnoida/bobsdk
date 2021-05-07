package com.bob.bobapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bob.bobapp.R;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.Util;

public class TermsAndConditionActivity extends AppCompatActivity {
    private TextView menu,txtNext;
    private Util util;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_condition);
        findView();
    }

    // initialize object here...
    private void findView() {
        menu=findViewById(R.id.menu);
      //  txtNext=findViewById(R.id.txtNext);
        util = new Util(this);
        menu.setText(getResources().getString(R.string.fa_icon_back));
        FontManager.markAsIconContainer(menu, util.iconFont);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
    }
}