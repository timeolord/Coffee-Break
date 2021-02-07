package com.hacks.coffeebreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.adefruandta.spinningwheel.SpinningWheelView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.hacks.coffeebreak.chat.ChatBox;

public class Matcher extends AppCompatActivity {
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matcher);
        SpinningWheelView wheelView = (SpinningWheelView) findViewById(R.id.wheel);
        wheelView.setEnabled(false);
        wheelView.rotate(50, 8000, 50);

        YoYo.with(Techniques.Bounce)
                .duration(1000)
                .playOn(findViewById(R.id.FunnyText));
        Animate();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // inflate the layout of the popup window
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.match_window, null);



                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
                //popupWindow.setAnimationStyle(R.style.Animation_Dialog);

                YoYo.with(Techniques.BounceIn)
                        .duration(700)
                        .playOn(popupView);


                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(findViewById(R.id.FunnyText), Gravity.CENTER, 0, 0);

            }
        }, 8000);

        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Matcher.this, ChatBox.class));
                finish();
            }
        }, 9500);
    }

    private void Animate() {
        if (i <= 6) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    YoYo.with(Techniques.Bounce)
                            .duration(900)
                            .playOn(findViewById(R.id.FunnyText));
                    i++;
                    Animate();
                }
            }, 1000);
        }
    }
}