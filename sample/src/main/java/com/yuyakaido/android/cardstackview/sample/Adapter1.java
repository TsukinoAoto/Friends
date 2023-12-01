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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;


public class Adapter1 extends RecyclerView.Adapter<Adapter1.MyViewHolder> {
    private List<ThreadDataModel> dataList;
    private Context context; // コンテキストを保持する変数を追加

    public Adapter1(List<ThreadDataModel> dataList,Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ThreadDataModel data = dataList.get(position);
        holder.bindData(data);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name1, age1, comment1, date1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name1 = itemView.findViewById(R.id.Text1);
            age1 = itemView.findViewById(R.id.Text2);
            comment1 = itemView.findViewById(R.id.Text3);
            date1 = itemView.findViewById(R.id.Text4);

            // リストアイテムをクリックしたときの処理を設定
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position =  getBindingAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        // クリックされたアイテムの位置からデータを取得
                        ThreadDataModel data = dataList.get(position);

                        // 画面遷移のためのIntentを作成
                        Intent intent = new Intent(context,CommentActivity1.class); // 遷移先のActivityを指定
                        intent.putExtra("number",String.valueOf(position));

                        String text1 = data.getField1();
                        String text2 = data.getField2();
                        String text3 = data.getField3();
                        String timestamp = data.getField4();

                        // Firebase Realtime Databaseのリファレンスを取得
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Thread/Comment_bar1");
                        databaseReference.child(String.valueOf(position)).setValue(data);

                        // 新しいデータオブジェクトを作成
                        data = new ThreadDataModel(text1, text2, text3, timestamp);

                        // 画面遷移
                        context.startActivity(intent);
                    }
                }
            });
        }

        public void bindData(ThreadDataModel data) {
            name1.setText(data.getField1());
            age1.setText(data.getField2());
            comment1.setText(data.getField3());
            date1.setText(data.getField4());
        }
    }
}
