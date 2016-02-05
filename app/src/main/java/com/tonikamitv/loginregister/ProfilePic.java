package com.tonikamitv.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tonikamitv.loginregister.SimpleGestureFilter.SimpleGestureListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by Lenovo on 23-01-2016.
 */
public class ProfilePic extends Activity implements View.OnClickListener {

    Button bNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilepic);
        bNext = (Button) findViewById(R.id.bNext);

        bNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bNext:
                startActivity(new Intent(this, MainScreen.class));
                break;
        }
    }

}


  /*      private SimpleGestureFilter detector;
        Intent go;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.profilepic);

            // Detect touched area
            detector = new SimpleGestureFilter(this,this);
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent me){
            // Call onTouchEvent of SimpleGestureFilter class
            this.detector.onTouchEvent(me);
            return super.dispatchTouchEvent(me);
        }
        @Override
        public void onSwipe(int direction) {
            String str = "";

            switch (direction) {

                case SimpleGestureFilter.SWIPE_RIGHT : str = "Swipe Right";
                    startActivity(new Intent(this, KnowLanguage.class));
                    break;
                case SimpleGestureFilter.SWIPE_LEFT :  str = "Swipe Left";

                    Toast t = Toast.makeText(ProfilePic.this, "Left swipe", Toast.LENGTH_LONG);
                    t.show();
                    startActivity(new Intent(this, KnowLanguage.class));
                    break;
                case SimpleGestureFilter.SWIPE_DOWN :  str = "Swipe Down";
                    break;
                case SimpleGestureFilter.SWIPE_UP :    str = "Swipe Up";
                    break;

            }
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDoubleTap() {
            Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
        }

    }
*/