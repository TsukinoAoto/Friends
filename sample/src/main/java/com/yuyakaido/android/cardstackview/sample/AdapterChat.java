package com.yuyakaido.android.cardstackview.sample;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;


public class AdapterChat extends RecyclerView.Adapter<AdapterChat.MyViewHolder> {

    Context context;
    ArrayList name,number;
    static String position;
    //String number;
    MySingleton mySingleton = MySingleton.getInstance();

    // データを取得
    String gmail = mySingleton.getData();

    // データベースから取得した値を保持するための変数を定義
    private String name_database,number_database;
    private ArrayList<String> list_id;


    DatabaseReference databaseReference;

    AdapterChat(Context context, ArrayList name) {
        this.context = context;
        this.name = name;
        this.list_id=new ArrayList<>();


        // Firebase Realtime Databaseへの参照を取得
        databaseReference = FirebaseDatabase.getInstance().getReference("Chat/List").child(gmail);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // データベースから取得したデータを格納するためのリスト
                ArrayList<String> namesFromDatabase = new ArrayList<>();
                ArrayList<String> numbersFromDatabase = new ArrayList<>();

                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    // キー（通常はIDなど）を取得
                    String key = childSnapshot.getKey();

                    // データベースから値を取得
                    String name_database = childSnapshot.child("field1").getValue(String.class);
                    String number_database = childSnapshot.child("number").getValue(String.class);

                    // 取得したデータをリストに追加
                    namesFromDatabase.add(name_database);
                    numbersFromDatabase.add(number_database);
                }

                // リストデータをAdapterにセット
                updateList(namesFromDatabase, numbersFromDatabase);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // エラーハンドリング
            }
        });

    }

    public AdapterChat(List<ThreadDataModel3> dataList, AccessControlContext context) {
    }

    @Override
    //xmlファイルをinflateして作成したViwオブジェクトをViewHolderインスタンスにセットして返す
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_chat,parent,false);
        return new MyViewHolder(view);
    }

    //1行文データを取得して設定。
    //おそらくここで初めてViewHolder、onCreateViewHolderで繋いだ値がセットされる。
    @Override
    public void onBindViewHolder(AdapterChat.MyViewHolder holder, int position) {
        holder.name_txt.setText(String.valueOf(name.get(position)));

        // name_databaseとimageURI_databaseの内容を設定

        //リストをタップしたときにデータをもって変位するための処理
        holder.coordinatorLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // クリックした位置のデータを取得
                String clickedName = String.valueOf(name.get(position));
                String clickedNumber = String.valueOf(position); // クリックした位置のnumberを取得

                Log.d("テスト", clickedNumber);

                // Firebase Realtime Databaseへの参照を取得
                databaseReference = FirebaseDatabase.getInstance().getReference("Chat/List").child(gmail).child(clickedNumber);
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String name_id =snapshot.child("field1").getValue(String.class);
                        String reciever_id = snapshot.child("field7").getValue(String.class);

                        Intent intent = new Intent(context, ChatActivity.class);
                        intent.putExtra("name",name_id);
                        intent.putExtra("number",reciever_id);
                        Log.d("テスト", name_id);
                        Log.d("テスト", reciever_id);
                        context.startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    //ViewHolderはRecyclerViewのrowとの繋ぎ役
    //リスト内のビューはビューホルダーオブジェクトの中身(インスタンス)が表示される。
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public View coordinatorLayout;
        TextView name_txt;

        TextView name_database_txt, imageURI_database_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_txt = itemView.findViewById(R.id.name);

            coordinatorLayout=itemView.findViewById(R.id.chat_list);
        }
    }

    public void updateList(ArrayList<String> name, ArrayList<String> numbersFromDatabase) {
        this.name = name;
        this.number = numbersFromDatabase;

        notifyDataSetChanged(); // リストの変更を通知してUIを更新
    }
}

