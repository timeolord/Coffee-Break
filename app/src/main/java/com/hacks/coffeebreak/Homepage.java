package com.hacks.coffeebreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.animation.ObjectAnimator;
import com.daimajia.androidanimations.library.BaseViewAnimator;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.hacks.coffeebreak.chat.ChatBox;
import com.hacks.coffeebreak.chat.Message;

public class Homepage extends AppCompatActivity {

    private BottomAppBar mBottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mBottomAppBar = findViewById(R.id.bar);
        setSupportActionBar(mBottomAppBar);

    }

    public void Message(View v){
        startActivity(new Intent(Homepage.this, ChatBox.class));
    }
    //TODO: EAT MY ASS
    public void ExitPopup(View v){
    }

    public void ToZuck(View v){
        startActivity(new Intent(Homepage.this, ProfilePage.class));
    }

    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);



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
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }




}