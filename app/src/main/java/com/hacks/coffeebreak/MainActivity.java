package com.hacks.coffeebreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View v){
        String email = ((EditText)findViewById(R.id.LoginEmail)).getText().toString();
        String password = ((EditText)findViewById(R.id.LoginPass)).getText().toString();

        if (email.equals("admin") && password.equals("admin")){
            startActivity(new Intent(MainActivity.this, Homepage.class));
            finish();
        }
        else {
            CharSequence error = "Email or password is incorrect.";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(getApplicationContext(), error, duration);
            toast.show();
        }
    }

    public void Test(View v){
        startActivity(new Intent(MainActivity.this, Messenger.class));
        finish();
    }

}