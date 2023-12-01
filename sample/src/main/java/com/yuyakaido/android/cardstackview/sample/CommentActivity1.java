package com.yuyakaido.android.cardstackview.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import java.util.Collections;


public class CommentActivity1 extends AppCompatActivity {

    private Adapter1 adapter;
    private RecyclerView recyclerView;
    private List<ThreadDataModel> dataList;
    FloatingActionButton button;
    Context context;
    private String name ="";
    private String age = "";
    private String comment="";
    private String date="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment1);

        // RecyclerViewの初期化
        recyclerView = findViewById(R.id.RecyclerView1_comment);
        dataList = new ArrayList<>();

        // RecyclerView用のアダプターを初期化
        adapter = new Adapter1(dataList,context);
        recyclerView.setAdapter(adapter);

        // LinearLayoutManagerを使用して縦向きに表示
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // リストごとに枠線を引くためのDividerItemDecorationを設定
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecoration);

        // Firebase Realtime Databaseからデータを読み取り、Adapterにデータを設定
        readDataFromFirebase();

        Intent intent = getIntent();
        String number = intent.getStringExtra("number");

        // AddActivityに遷移するためのもの
        button = findViewById(R.id.floating_button1_comment);
        button.setBackgroundColor(R.color.blue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommentActivity1.this, AddCommentActivity1.class);
                intent.putExtra("number",number);
                startActivity(intent);
            }
        });

        ImageButton btComment=findViewById(R.id.bt_comment);
        btComment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

    private void readDataFromFirebase() {
        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        // Firebase Realtime Databaseの参照を取得
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Thread/Comment1").child(number);


        // データの変更を監視
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataList.clear(); // データをクリア

                // データを取得してデータリストに追加
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ThreadDataModel data = snapshot.getValue(ThreadDataModel.class);
                    if (data != null) {
                        dataList.add(data);
                    }
                }

                // データを逆順にソート（新しいものから）
                Collections.reverse(dataList);

                // アダプターにデータの変更を通知
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // エラーハンドリング
            }
        });

        DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference("Thread/Comment_bar1").child(number);
        // データの変更を監視
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear(); // データをクリア

                name = snapshot.child("field1").getValue(String.class);
                age = snapshot.child("field2").getValue(String.class);
                comment = snapshot.child("field3").getValue(String.class);
                date = snapshot.child("field4").getValue(String.class);

                Log.d("テスト", name);
                Log.d("テスト", age);
                Log.d("テスト", comment);
                Log.d("テスト", date);

                // 選択された学年を表示するTextView
                TextView nameTextView = findViewById(R.id.Text1_comment);
                nameTextView.setText(name);

                // 選択されたクラスを表示するTextView
                TextView ageTextView = findViewById(R.id.Text2_comment);
                ageTextView.setText(age);

                // 選択された学部を表示するTextView
                TextView commentTextView = findViewById(R.id.Text3_comment);
                commentTextView.setText(comment);

                // 選択された学科を表示するTextView
                TextView dateTextView = findViewById(R.id.Text4_comment);
                dateTextView.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // エラーハンドリング
            }
        });
    }
}
