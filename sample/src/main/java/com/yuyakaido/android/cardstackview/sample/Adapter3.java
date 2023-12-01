package com.yuyakaido.android.cardstackview.sample;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;


public class Adapter3 extends RecyclerView.Adapter<Adapter3.MyViewHolder> {
    private final Context context;
    private List<ThreadDataModel3> dataList;

    //自分のID取得
    MySingleton mySingleton = MySingleton.getInstance();

    String gmail = mySingleton.getData();

    public Adapter3(List<ThreadDataModel3> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row3, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ThreadDataModel3 data = dataList.get(position);
        holder.bindData(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name1, age1, comment1, date1,kougi1,button1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name1 = itemView.findViewById(R.id.Text1);
            age1 = itemView.findViewById(R.id.Text2);
            comment1 = itemView.findViewById(R.id.Text3);
            date1 = itemView.findViewById(R.id.Text4);
            kougi1 =itemView.findViewById(R.id.Text5);
            button1 = itemView.findViewById(R.id.Button);

            setButtonClickListener();

            // リストアイテムをクリックしたときの処理を設定
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position =  getBindingAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        // クリックされたアイテムの位置からデータを取得
                        ThreadDataModel3 data = dataList.get(position);

                        // 画面遷移のためのIntentを作成
                        Intent intent = new Intent(context,CommentActivity3.class); // 遷移先のActivityを指定
                        intent.putExtra("number",String.valueOf(position));

                        String text1 = data.getField1();
                        String text2 = data.getField2();
                        String text3 = data.getField3();
                        String timestamp = data.getField4();
                        String text5 = data.getField5();
                        String text6 = data.getField6();
                        String text7 = data.getField7();

                        // Firebase Realtime Databaseのリファレンスを取得
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Thread/Comment_bar3");
                        databaseReference.child(String.valueOf(position)).setValue(data);

                        // 新しいデータオブジェクトを作成
                        data = new ThreadDataModel3(text1, text2, text3, timestamp,text5,text6,text7);

                        // 画面遷移
                        context.startActivity(intent);
                    }
                }
            });
        }

        public void bindData(ThreadDataModel3 data) {
            name1.setText(data.getField1());
            age1.setText(data.getField2());
            comment1.setText(data.getField3());
            date1.setText(data.getField4());
            kougi1.setText(data.getField5());
            button1.setText(data.getField6());
        }

        // ボタンのクリックリスナーをセットするメソッド
        public void setButtonClickListener() {
            Button button_get = itemView.findViewById(R.id.Button);
            button_get.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonText = button_get.getText().toString();
                    if (buttonText.equals("✌")) {
                        // ボタンのテキストが "✌" の場合は何もしない
                        showToast("既に取引が完了しています");
                    } else {
                        // ボタンのテキストが "✌" でない場合、データベースにデータを保存

                        // 1. Firebase Realtime Database のリファレンスを取得
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Chat/List").child(gmail);

                        // 2. 保存するデータを作成
                        int position = getBindingAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            ThreadDataModel3 data = dataList.get(position);
                            String text1 = data.getField1();
                            String text2 = data.getField2();
                            String text3 = data.getField3();
                            String timestamp = data.getField4();
                            String text5 = data.getField5();
                            String text6 = data.getField6();
                            String text7 = data.getField7();

                            // 新しいデータオブジェクトを作成
                            ThreadDataModel3 newData = new ThreadDataModel3(text1, text2, text3, timestamp, text5, text6,text7);

                            // 3. データをデータベースに書き込み
                            databaseReference.child(String.valueOf(position)).setValue(newData);

                            // 4. ボタンのテキストや色を変更
                            button_get.setText("✌");
                            int color_red = itemView.getContext().getResources().getColor(R.color.red);
                            button_get.setBackgroundColor(color_red); // ボタンの背景色を設定

                            showToast("チャットに友達を追加しました！");
                        }
                    }
                }
            });
        }
        private void showToast(String message) {
            LayoutInflater layoutInflater = (LayoutInflater) itemView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View customToastView = layoutInflater.inflate(R.layout.toast_1 ,null);

            // TextViewのテキストを変更する
            ((TextView) customToastView.findViewById(R.id.msg)).setText(message);

            Toast toast = new Toast(customToastView.getContext());
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setView(customToastView);
            toast.show();
        }

    }
}
