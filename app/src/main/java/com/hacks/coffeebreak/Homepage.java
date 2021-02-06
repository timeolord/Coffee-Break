package com.hacks.coffeebreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.hacks.coffeebreak.chat.ChatBox;

public class Homepage extends AppCompatActivity {

    private BottomAppBar mBottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mBottomAppBar = findViewById(R.id.bar);
        setSupportActionBar(mBottomAppBar);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void ToMessenger(View v){
        startActivity(new Intent(Homepage.this, ChatBox.class));
    }

    public void ToProfilePage(View v){
        startActivity(new Intent(Homepage.this, ProfilePage.class));
    }
}