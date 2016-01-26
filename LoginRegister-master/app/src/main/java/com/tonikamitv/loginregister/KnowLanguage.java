package com.tonikamitv.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Lenovo on 25-01-2016.
 */
public class KnowLanguage extends Activity implements View.OnClickListener {

 /*   Button lang1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.know_language);
        lang1 = (Button) findViewById(R.id.Lang1);

        lang1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Lang1:
                startActivity(new Intent(this, HomePage.class));
                break;
        }
    }


}*/
 EditText editText1;
    Button Lang1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.know_language);

        editText1 = (EditText) findViewById(R.id.editText1);
        Lang1 = (Button) findViewById(R.id.Lang1);

        Lang1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Lang1:
                String name = editText1.getText().toString();


                User user = new User(language);
                registerUser(user);
                break;
        }
    }

    private void registerUser(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                Intent loginIntent = new Intent(KnowLanguage.this, ProfilePic.class);
                startActivity(loginIntent);
            }
        });
    }
}


