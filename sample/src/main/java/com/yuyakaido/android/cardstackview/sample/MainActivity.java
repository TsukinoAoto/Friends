package com.yuyakaido.android.cardstackview.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // ボタンを取得
        Button LoginButton = findViewById(R.id.log_in);
        Button SignupButton=findViewById(R.id.sign_up);

        // ボタンのクリックリスナーを設定
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                // ボタンがクリックされたときの処理をここに記述
                startActivity(intent);// アクティビティを終了する
            }
        });

        // ボタンのクリックリスナーを設定
        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterPage.class);
                // ボタンがクリックされたときの処理をここに記述
                startActivity(intent);// アクティビティを終了する
            }
        });
    }
}
