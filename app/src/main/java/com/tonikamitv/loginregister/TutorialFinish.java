package com.tonikamitv.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Lenovo on 04-02-2016.
 */
public class TutorialFinish extends Activity implements View.OnClickListener {

    TextView bFinish;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_finish);
        bFinish = (TextView) findViewById(R.id.bFinish);

        bFinish.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bFinish:
                startActivity(new Intent(this, Login.class));
                break;


        }
    }

}
