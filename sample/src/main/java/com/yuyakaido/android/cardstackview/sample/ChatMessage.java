package com.yuyakaido.android.cardstackview.sample;

public class ChatMessage {
    private String message;
    private String sender;
    private boolean sent;

    public ChatMessage() {
        // デフォルトコンストラクタが必要です
    }

    public ChatMessage(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSent() {
        return sent;
    }

    public String getSender() {
        return sender;
    }
}


