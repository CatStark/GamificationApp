package com.tonikamitv.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Lenovo on 04-02-2016.
 */
public class My_Profile extends ActionBarActivity implements View.OnClickListener{

    UserLocalStore userLocalStore;
    TextView langwant, langskill, interests;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        langskill = (TextView) findViewById(R.id.langskill);
        langwant = (TextView) findViewById(R.id.langwant);
        interests = (TextView) findViewById(R.id.interests);
        back = (TextView) findViewById(R.id.back);

       back.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.back:
                Intent loginIntent = new Intent(this, HomePage.class);
                startActivity(loginIntent);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate() == true) {
            displayUserDetails();
        }
    }

    private boolean authenticate() {
        if (userLocalStore.getLoggedInUser() == null) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            return false;
        }
        return true;
    }

    private void displayUserDetails() {
        User user = userLocalStore.getLoggedInUser();
        langskill.setText(user.knowlanguage);
        langwant.setText(user.wantlanguage);
        interests.setText(user.interests);
    }
}
