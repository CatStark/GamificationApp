package com.tonikamitv.loginregister;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class Register extends ActionBarActivity implements View.OnClickListener{
    EditText etName, etAge, etUsername, etPassword;
    Button bRegister;
    private String selectedImagePath;
    Button bTakePic;
    //TextView tvHasCamera, tvHasCameraApp;
    ImageView imgTakePic;
    Bitmap bitMap;
    static int TAKE_PICTURE = 1;
    static int SELECT_FILE = 2;
    public static final String ARG_FROM_MAIN = "arg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        bTakePic = (Button) findViewById(R.id.bTakePic);
        imgTakePic = (ImageView) findViewById(R.id.search_mag_icon);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegister:
                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());
               // User user = new User(name, age, username, password);
               // registerUser(user);
                Intent nextIntent = new Intent(Register.this, MainScreen.class);
                nextIntent.putExtra("arg", getText());
                nextIntent.putExtra("arg1", userName());
                nextIntent.putExtra("arg2", password());
                nextIntent.putExtra("arg3", age());
                startActivity(nextIntent);
                break;

        }
    }


    public String getText(){
        String name = etName.getText().toString();
        return name;
    }
    public String userName(){
        String username = etUsername.getText().toString();
        return username;
    }
    public String password(){
        String password = etPassword.getText().toString();
        return password;
    }
    public int age(){
        int age = Integer.parseInt(etAge.getText().toString());
        return age;
    }

    /*private void registerUser(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                Intent loginIntent = new Intent(Register.this, ProfilePic.class);
                startActivity(loginIntent);
            }
        });
    }*/
}
