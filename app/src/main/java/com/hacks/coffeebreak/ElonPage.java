package com.hacks.coffeebreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.bottomappbar.BottomAppBar;

public class ElonPage extends AppCompatActivity {

    private BottomAppBar mBottomAppBar;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elon_page);

        mBottomAppBar = findViewById(R.id.bar);
        setSupportActionBar(mBottomAppBar);
    }

    public void Message(View v){
        startActivity(new Intent(ElonPage.this, Matcher.class));
        popupWindow.dismiss();
    }

    public void ToZuck(View v){
        startActivity(new Intent(ElonPage.this, ProfilePage.class));
    }

    public void GoHome(View v) {
        startActivity(new Intent(ElonPage.this,Homepage.class));
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
        popupWindow = new PopupWindow(popupView, width, height, focusable);
        //popupWindow.setAnimationStyle(R.style.Animation_Dialog);

        YoYo.with(Techniques.BounceInLeft)
                .duration(700)
                .playOn(popupView);


        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when click no

        Button close = (Button) popupView.findViewById(R.id.closebutton);
        close.setOnClickListener(new View.OnClickListener() {

            public void onClick(View popupView) {
                popupWindow.dismiss();

            }
        });
    }

}