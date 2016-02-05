package com.tonikamitv.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Lenovo on 04-02-2016.
 */
public class TutorialNext extends Activity implements View.OnClickListener {

    TextView bSkip;
    TextView bNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_next);
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
                startActivity(new Intent(this, TutorialFinish.class));
                break;

        }
    }

}
