package com.hacks.coffeebreak.chat;

public class ChatBot implements Runnable{
    private final ChatBox chat;

    @Override
    public void run() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chat.Reply();
    }


    ChatBot(ChatBox chat){
        this.chat = chat;
    }
}
