package com.tonikamitv.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 25-01-2016.
 */
public class KnowLanguage extends Activity {
    ListView lv;
    ArrayList<List> selectedItems;
    CheckBox  c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.know_language);
        selectedItems = new ArrayList<List>();
        c1 = (CheckBox) findViewById(R.id.checkbox_English);

    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_English:
                if (checked){
                    //selectedItems.add(c1.toString());
                }

                else

                break;
            case R.id.checkbox_German:
                if (checked){}

                else

                break;
            // TODO: Veggie sandwich
        }
    }
}
