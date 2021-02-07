package com.hacks.coffeebreak.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.hacks.coffeebreak.ElonPage;
import com.hacks.coffeebreak.Homepage;
import com.hacks.coffeebreak.Matcher;
import com.hacks.coffeebreak.ProfilePage;
import com.hacks.coffeebreak.R;

import java.util.ArrayList;
import java.util.Random;

public class ChatBox extends AppCompatActivity {
    ArrayList<Message> texts = new ArrayList<>();
    Runnable Chatbot = new ChatBot(this);
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_box);

    }

    public void SendText(View v){
        String user = "Richard";
        EditText textBox = ((EditText)findViewById(R.id.SendTextInput));

        String text = textBox.getText().toString();
        if (text.equals("")){
            return;
        }

        textBox.setText("");

        texts.add(new Message(user, text));

        UpdateText(text);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private Drawable GetResource(String name){
        Resources background = this.getApplicationContext().getResources();
        final int backgroundID = getResources().getIdentifier(name, "drawable", this.getPackageName());
        return background.getDrawable(backgroundID, this.getApplicationContext().getTheme());
    }

    @SuppressLint("RtlHardcoded")
    private void UpdateText(String text){
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.gravity = Gravity.RIGHT;
        layout.setMargins(10,10,10,10);
        textView.setLayoutParams(layout);
        textView.setText(text);
        textView.setBackground(GetResource("chatbox"));
        textView.setPadding(40, 30, 40, 30);
        textView.setTextSize(20);

        LinearLayout box = (LinearLayout) findViewById(R.id.TextScroll);

        ScrollView scroll = findViewById(R.id.TextScroller);
        scroll.scrollTo(0, scroll.getBottom());

        box.addView(textView);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Reply();
            }
        }, 1500);

       // runOnUiThread(Chatbot);
    }

    public void Reply(){

        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.gravity = Gravity.LEFT;
        layout.setMargins(10,10,10,10);
        textView.setLayoutParams(layout);
        textView.setText(getRandomString());
        textView.setBackground(GetResource("roundbutton"));
        textView.setPadding(40, 30, 40, 30);
        textView.setTextSize(20);

        LinearLayout box = (LinearLayout) findViewById(R.id.TextScroll);

        ScrollView scroll = findViewById(R.id.TextScroller);
        scroll.fullScroll(View.FOCUS_DOWN);

        box.addView(textView);
    }

    private String getRandomString(){
        String[] words = {"Hi There!", "How are you?", "This app is cool!", "sup", "Hello", "salutations", "greetings", "Salve", "Bonjour",
                "您好", "Merhaba", "こんにちは"};
        int rand = Math.abs(random.nextInt()%(words.length));
        return words[rand];
    }

    public void ToElon(View v){
        startActivity(new Intent(ChatBox.this, ElonPage.class));
    }

}