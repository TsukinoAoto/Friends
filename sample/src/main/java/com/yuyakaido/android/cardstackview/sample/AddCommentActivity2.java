package com.yuyakaido.android.cardstackview.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCommentActivity2 extends AppCompatActivity {

    EditText  editText3;
    TextView textView;
    Button button1;
    DatabaseReference databaseReference;
    private String name_database,grade_database,department_database,subject_database,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add1);

        editText3 = findViewById(R.id.EditText3);
        textView = findViewById(R.id.Text_date);

        //Intent intent=getIntent();
        //String gmail=intent.getStringExtra("gmail");

        MySingleton mySingleton = MySingleton.getInstance();

        // データを取得
        String gmail = mySingleton.getData();

        // Firebase Realtime Databaseへの参照を取得
        databaseReference = FirebaseDatabase.getInstance().getReference("Profile").child(gmail);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // データベースから値を取得し、変数に格納
                name_database = snapshot.child("name").getValue(String.class);
                grade_database = snapshot.child("grade").getValue(String.class);
                department_database = snapshot.child("department").getValue(String.class);
                subject_database = snapshot.child("subject").getValue(String.class);

                age=grade_database+department_database+subject_database;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // エラーハンドリング
            }
        });

        button1 = findViewById(R.id.Button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                final Date date = new Date(System.currentTimeMillis());
                textView.setText(df.format(date));

                Intent intent = getIntent();
                String number = intent.getStringExtra("number");

                if ( editText3.length() > 0) {
                    // EditTextからテキストを取得
                    String text1 = name_database;
                    String text2 = age;
                    String text3 = editText3.getText().toString().trim();
                    String timestamp = textView.getText().toString().trim();

                    // Firebase Realtime Databaseのリファレンスを取得
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Thread/Comment2").child(number);

                    // 新しいデータオブジェクトを作成
                    ThreadDataModel data = new ThreadDataModel(text1, text2, text3, timestamp);

                    // データをFirebase Realtime Databaseに追加
                    databaseReference.push().setValue(data);

                    finish();
                } else {
                    finish();
                }
            }
        });
    }
}

