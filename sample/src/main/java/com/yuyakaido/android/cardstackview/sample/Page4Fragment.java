package com.yuyakaido.android.cardstackview.sample;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page4Fragment extends Fragment {

    private Adapter4 adapter;
    private RecyclerView recyclerView;
    private List<ThreadDataModel3> dataList;
    FloatingActionButton button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page1, container, false);

        //MySingleton mySingleton = MySingleton.getInstance();

        // データを取得
        // String gmail = mySingleton.getData();

        // RecyclerViewの初期化
        recyclerView = view.findViewById(R.id.RecyclerView1);
        dataList = new ArrayList<>();

        // RecyclerView用のアダプターを初期化
        adapter = new Adapter4(dataList,getContext());
        recyclerView.setAdapter(adapter);

        // LinearLayoutManagerを使用して縦向きに表示
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // リストごとに枠線を引くためのDividerItemDecorationを設定
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecoration);

        // Firebase Realtime Databaseからデータを読み取り、Adapterにデータを設定
        readDataFromFirebase();

        //AddActivityに遷移するためのもの
        button = view.findViewById(R.id.floating_button1);
        button.setBackgroundColor(R.color.blue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddActivity4.class);
                //intent.putExtra("gmail",gmail);
                startActivity(intent);
            }
        });

        return view;
    }

    private void readDataFromFirebase() {
        // Firebase Realtime Databaseの参照を取得
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Thread/Page4");

        // データの変更を監視
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataList.clear(); // データをクリア

                // データを取得してデータリストに追加
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ThreadDataModel3 data = snapshot.getValue(ThreadDataModel3.class);
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
    }
}
