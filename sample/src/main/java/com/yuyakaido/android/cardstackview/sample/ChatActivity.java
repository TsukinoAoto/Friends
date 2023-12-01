package com.yuyakaido.android.cardstackview.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.UUID;

public class ChatActivity extends AppCompatActivity {
    DatabaseReference databaseReferenceSender, databaseReferenceReciever;
    String senderRoom, recieverRoom;
    MessageAdapter messageAdapter;
    RecyclerView recycler;
    EditText messageEd;
    ImageButton sendMessage;
    int messageNumber =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        TextView username=findViewById(R.id.username);
        Intent intent=getIntent();
        String name = intent.getStringExtra("name");
        username.setText(name);

        recycler = findViewById(R.id.recycler); // レイアウト内のRecyclerViewのIDを指定
        messageEd = findViewById(R.id.messageEd); // レイアウト内のEditTextのIDを指定
        sendMessage = findViewById(R.id.sendMessage); // レイアウト内のButtonのIDを指定

        String recieverId = intent.getStringExtra("number");
        //自分のID取得
        MySingleton mySingleton = MySingleton.getInstance();

        String gmail = mySingleton.getData();

        senderRoom = gmail + recieverId;
        recieverRoom = recieverId + gmail;

        messageAdapter = new MessageAdapter(this);
        recycler.setAdapter(messageAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        databaseReferenceSender = FirebaseDatabase.getInstance().getReference("chats").child(senderRoom);
        databaseReferenceReciever = FirebaseDatabase.getInstance().getReference("chats").child(recieverRoom);

        // ボタンを取得
        ImageButton finishButton = findViewById(R.id.back_btn);
        // ボタンのクリックリスナーを設定
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this,ChatFragment.class);
                // ボタンがクリックされたときの処理をここに記述
                Intent intentG = getIntent();
                String gmail = intentG.getStringExtra("gmail");
                intent.putExtra("gmail",gmail);
                finish();
            }
        });

        databaseReferenceSender.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messageAdapter.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MessageModel messageModel = dataSnapshot.getValue(MessageModel.class);
                    messageAdapter.add(messageModel);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEd.getText().toString();
                if (message.trim().length() > 0) {
                    sendMessage(message);
                }
            }
        });
    }

    private void sendMessage(String message) {
        // 新しいメッセージ用のプッシュキーを生成
        String messageId = databaseReferenceSender.push().getKey();

        if (messageId != null) {
            // MessageModelを作成
            MessageModel messageModel = new MessageModel(messageId, FirebaseAuth.getInstance().getUid(), message);

            // メッセージを送信者と受信者のデータベースに追加
            databaseReferenceSender
                    .child(messageId)
                    .setValue(messageModel);
            databaseReferenceReciever
                    .child(messageId)
                    .setValue(messageModel);
        }
    }


}
