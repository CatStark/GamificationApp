package com.tonikamitv.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Lenovo on 28-01-2016.
 */
public class Tutorial extends Activity implements View.OnClickListener {

        TextView bSkip;
        TextView bNext;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);
        bSkip = (TextView) findViewById(R.id.bSkip);
        bNext = (TextView) findViewById(R.id.bNext);

        bSkip.setOnClickListener(this);
        bNext.setOnClickListener(this);
        }

@Override
public void onClick(View v) {
        switch (v.getId()) {
        case R.id.bSkip:
        startActivity(new Intent(this, HomePage.class));
        break;

        case R.id.bNext:
                startActivity(new Intent(this, TutorialNext.class));
                        break;

        }
        }

        }
