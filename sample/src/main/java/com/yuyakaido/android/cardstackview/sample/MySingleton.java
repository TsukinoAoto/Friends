package com.yuyakaido.android.cardstackview.sample;

public class MySingleton {
    private static MySingleton instance;
    private String data;

    private MySingleton() {
        // シングルトンの初期化コード
        data = "Initial Data";
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    // データを設定するメソッド
    public void setData(String newData) {
        this.data = newData;
    }

    // データを取得するメソッド
    public String getData() {
        return data;
    }
}

