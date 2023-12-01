package com.yuyakaido.android.cardstackview.sample;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;


public class ProfileActivity extends AppCompatActivity {
    private String name_database ="";
    private String department_database = "";
    private String subject_database="";
    private String grade_database="";
    private String gender_database="";
    private String group_database="";
    private String introduction_database="";
    private String hobbies_database;


    private String Base64Image_database = "";
    private String sj1_database;
    private String sj2_database;
    private String sj3_database;
    private String sj4_database;
    private String sj5_database;
    private String sj6_database;
    private String sj7_database;
    private String sj8_database;
    private String sj9_database;
    private String sj10_database;
    private String sj11_database;
    private String sj12_database;
    private String sj13_database;
    private String sj14_database;
    private String sj15_database;
    private String sj16_database;
    private String sj17_database;
    private String sj18_database;
    private String sj19_database;
    private String sj20_database;
    private String sj21_database;
    private String sj22_database;
    private String sj23_database;
    private String sj24_database;
    private String sj25_database;
    private String sj26_database;
    private String sj27_database;
    private String sj28_database;
    private String sj29_database;
    private String sj30_database;








    private String tn1_database;
    private String tn2_database;
    private String tn3_database;
    private String tn4_database;
    private String tn5_database;
    private String tn6_database;
    private String tn7_database;
    private String tn8_database;
    private String tn9_database;
    private String tn10_database;
    private String tn11_database;
    private String tn12_database;
    private String tn13_database;
    private String tn14_database;
    private String tn15_database;
    private String tn16_database;
    private String tn17_database;
    private String tn18_database;
    private String tn19_database;
    private String tn20_database;
    private String tn21_database;
    private String tn22_database;
    private String tn23_database;
    private String tn24_database;
    private String tn25_database;
    private String tn26_database;
    private String tn27_database;
    private String tn28_database;
    private String tn29_database;
    private String tn30_database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        UserProfileData userProfileData = (UserProfileData) this.getApplication();
        userProfileData.show();




        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");


        Log.d("テスト", gmail);


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Profile").child(gmail);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//コンポーネントにデータベースの情報を格納していく処理をここの中に書いていったほうがいいかも、、
//oncreate内のこの処理のあとにコンポーネントに反映する処理が書いてあるけど、先にコンポーネントに反映する処理が実行されて上手くいかないから
                name_database = snapshot.child("name").getValue(String.class);
                gender_database = snapshot.child("gender").getValue(String.class);
                grade_database = snapshot.child("grade").getValue(String.class);
                group_database = snapshot.child("group").getValue(String.class);
                department_database = snapshot.child("department").getValue(String.class);
                subject_database = snapshot.child("subject").getValue(String.class);
                introduction_database = snapshot.child("introduction").getValue(String.class);
                // hobbies_databaseをArrayList<String>として取得する
                GenericTypeIndicator<ArrayList<String>> t = new GenericTypeIndicator<ArrayList<String>>() {
                };
                ArrayList<String> hobbiesList = snapshot.child("hobbies").getValue(t);


                if (snapshot.child("Base64Image").getValue(String.class) != null){
                    Base64Image_database = snapshot.child("Base64Image").getValue(String.class);
                }


                if(name_database==null){


                }else {


                    sj1_database = snapshot.child("sj_1").getValue(String.class);
                    sj2_database = snapshot.child("sj_2").getValue(String.class);
                    sj3_database = snapshot.child("sj_3").getValue(String.class);
                    sj4_database = snapshot.child("sj_4").getValue(String.class);
                    sj5_database = snapshot.child("sj_5").getValue(String.class);
                    sj6_database = snapshot.child("sj_6").getValue(String.class);
                    sj7_database = snapshot.child("sj_7").getValue(String.class);
                    sj8_database = snapshot.child("sj_8").getValue(String.class);
                    sj9_database = snapshot.child("sj_9").getValue(String.class);
                    sj10_database = snapshot.child("sj_10").getValue(String.class);
                    sj11_database = snapshot.child("sj_11").getValue(String.class);
                    sj12_database = snapshot.child("sj_12").getValue(String.class);
                    sj13_database = snapshot.child("sj_13").getValue(String.class);
                    sj14_database = snapshot.child("sj_14").getValue(String.class);
                    sj15_database = snapshot.child("sj_15").getValue(String.class);
                    sj16_database = snapshot.child("sj_16").getValue(String.class);
                    sj17_database = snapshot.child("sj_17").getValue(String.class);
                    sj18_database = snapshot.child("sj_18").getValue(String.class);
                    sj19_database = snapshot.child("sj_19").getValue(String.class);
                    sj20_database = snapshot.child("sj_20").getValue(String.class);
                    sj21_database = snapshot.child("sj_21").getValue(String.class);
                    sj22_database = snapshot.child("sj_22").getValue(String.class);
                    sj23_database = snapshot.child("sj_23").getValue(String.class);
                    sj24_database = snapshot.child("sj_24").getValue(String.class);
                    sj25_database = snapshot.child("sj_25").getValue(String.class);
                    sj26_database = snapshot.child("sj_26").getValue(String.class);
                    sj27_database = snapshot.child("sj_27").getValue(String.class);
                    sj28_database = snapshot.child("sj_28").getValue(String.class);
                    sj29_database = snapshot.child("sj_29").getValue(String.class);
                    sj30_database = snapshot.child("sj_30").getValue(String.class);


                    tn1_database = snapshot.child("tn_1").getValue(String.class);
                    tn2_database = snapshot.child("tn_2").getValue(String.class);
                    tn3_database = snapshot.child("tn_3").getValue(String.class);
                    tn4_database = snapshot.child("tn_4").getValue(String.class);
                    tn5_database = snapshot.child("tn_5").getValue(String.class);
                    tn6_database = snapshot.child("tn_6").getValue(String.class);
                    tn7_database = snapshot.child("tn_7").getValue(String.class);
                    tn8_database = snapshot.child("tn_8").getValue(String.class);
                    tn9_database = snapshot.child("tn_9").getValue(String.class);
                    tn10_database = snapshot.child("tn_10").getValue(String.class);
                    tn11_database = snapshot.child("tn_11").getValue(String.class);
                    tn12_database = snapshot.child("tn_12").getValue(String.class);
                    tn13_database = snapshot.child("tn_13").getValue(String.class);
                    tn14_database = snapshot.child("tn_14").getValue(String.class);
                    tn15_database = snapshot.child("tn_15").getValue(String.class);
                    tn16_database = snapshot.child("tn_16").getValue(String.class);
                    tn17_database = snapshot.child("tn_17").getValue(String.class);
                    tn18_database = snapshot.child("tn_18").getValue(String.class);
                    tn19_database = snapshot.child("tn_19").getValue(String.class);
                    tn20_database = snapshot.child("tn_20").getValue(String.class);
                    tn21_database = snapshot.child("tn_21").getValue(String.class);
                    tn22_database = snapshot.child("tn_22").getValue(String.class);
                    tn23_database = snapshot.child("tn_23").getValue(String.class);
                    tn24_database = snapshot.child("tn_24").getValue(String.class);
                    tn25_database = snapshot.child("tn_25").getValue(String.class);
                    tn26_database = snapshot.child("tn_26").getValue(String.class);
                    tn27_database = snapshot.child("tn_27").getValue(String.class);
                    tn28_database = snapshot.child("tn_28").getValue(String.class);
                    tn29_database = snapshot.child("tn_29").getValue(String.class);
                    tn30_database = snapshot.child("tn_30").getValue(String.class);




                    Log.d("テスト", name_database);
                    Log.d("テスト", grade_database);
                    Log.d("テスト", group_database);
                    Log.d("テスト", gender_database);
                    Log.d("テスト", department_database);
                    Log.d("テスト", subject_database);
                    Log.d("テスト", introduction_database);
                    //Log.d("テスト",hobbies_database);


                    if(Base64Image_database != ""){
                        byte[] decodeImg = Base64.getDecoder().decode(Base64Image_database);
                        Bitmap bmp = null;
                        bmp = BitmapFactory.decodeByteArray(decodeImg,0,decodeImg.length);
                        ImageView imageView = findViewById(R.id.imageView);
                        imageView.setImageBitmap(bmp);
                    }


                    // 名前を表示するTextView
                    TextView nameTextView = findViewById(R.id.nameView);
                    nameTextView.setText(name_database);


                    // 自己紹介を表示するTextView
                    TextView syoukaiTextView = findViewById(R.id.jikosyoukaiView);
                    syoukaiTextView.setText(introduction_database);


                    // 選択された性別を表示するTextView
                    //TextView genderTextView = findViewById(R.id.genderView);
                    //genderTextView.setText("性別: " + gender_database);


                    // 選択された学年を表示するTextView
                    TextView gradeTextView = findViewById(R.id.gradeView);
                    gradeTextView.setText(grade_database);


                    // 選択されたクラスを表示するTextView
                    TextView classTextView = findViewById(R.id.classView);
                    classTextView.setText(group_database);


                    // 選択された学部を表示するTextView
                    TextView departmentTextView = findViewById(R.id.departmentView);
                    departmentTextView.setText(department_database);


                    // 選択された学科を表示するTextView
                    TextView subjectTextView = findViewById(R.id.subjectView);
                    subjectTextView.setText(subject_database);


                    // hobbiesTextViewに設定
                    TextView hobbiesTextView = findViewById(R.id.hobbiesView);
                    if (!hobbiesList.isEmpty()) {
                        StringBuilder hobbiesText = new StringBuilder("趣味: ");
                        for (String hobby : hobbiesList) {
                            hobbiesText.append(hobby).append(", ");
                        }
                        hobbiesText.setLength(hobbiesText.length() - 2); // 最後のカンマとスペースを削除
                        hobbiesTextView.setText(hobbiesText.toString());
                    }


                    TextView sj1TextView = findViewById(R.id.sj_textView);
                    sj1TextView.setText(sj1_database);




                    TextView sj2TextView = findViewById(R.id.sj2_textView);
                    sj2TextView.setText(sj2_database);




                    TextView sj3TextView = findViewById(R.id.sj3_textView);
                    sj3TextView.setText(sj3_database);




                    TextView sj4TextView = findViewById(R.id.sj4_textView);
                    sj4TextView.setText(sj4_database);




                    TextView sj5TextView = findViewById(R.id.sj5_textView);
                    sj5TextView.setText(sj5_database);




                    TextView sj6TextView = findViewById(R.id.sj6_textView);
                    sj6TextView.setText(sj6_database);




                    TextView sj7TextView = findViewById(R.id.sj7_textView);
                    sj7TextView.setText(sj7_database);




                    TextView sj8TextView = findViewById(R.id.sj8_textView);
                    sj8TextView.setText(sj8_database);




                    TextView sj9TextView = findViewById(R.id.sj9_textView);
                    sj9TextView.setText(sj9_database);




                    TextView sj10TextView = findViewById(R.id.sj10_textView);
                    sj10TextView.setText(sj10_database);




                    TextView sj11TextView = findViewById(R.id.sj11_textView);
                    sj11TextView.setText(sj11_database);




                    TextView sj12TextView = findViewById(R.id.sj12_textView);
                    sj12TextView.setText(sj12_database);




                    TextView sj13TextView = findViewById(R.id.sj13_textView);
                    sj13TextView.setText(sj13_database);




                    TextView sj14TextView = findViewById(R.id.sj14_textView);
                    sj14TextView.setText(sj14_database);




                    TextView sj15TextView = findViewById(R.id.sj15_textView);
                    sj15TextView.setText(sj15_database);




                    TextView sj16TextView = findViewById(R.id.sj16_textView);
                    sj16TextView.setText(sj16_database);




                    TextView sj17TextView = findViewById(R.id.sj17_textView);
                    sj17TextView.setText(sj17_database);




                    TextView sj18TextView = findViewById(R.id.sj18_textView);
                    sj18TextView.setText(sj18_database);




                    TextView sj19TextView = findViewById(R.id.sj19_textView);
                    sj19TextView.setText(sj19_database);




                    TextView sj20TextView = findViewById(R.id.sj20_textView);
                    sj20TextView.setText(sj20_database);




                    TextView sj21TextView = findViewById(R.id.sj21_textView);
                    sj21TextView.setText(sj21_database);




                    TextView sj22TextView = findViewById(R.id.sj22_textView);
                    sj22TextView.setText(sj22_database);




                    TextView sj23TextView = findViewById(R.id.sj23_textView);
                    sj23TextView.setText(sj23_database);




                    TextView sj24TextView = findViewById(R.id.sj24_textView);
                    sj24TextView.setText(sj24_database);




                    TextView sj25TextView = findViewById(R.id.sj25_textView);
                    sj25TextView.setText(sj25_database);




                    TextView sj26TextView = findViewById(R.id.sj26_textView);
                    sj26TextView.setText(sj26_database);




                    TextView sj27TextView = findViewById(R.id.sj27_textView);
                    sj27TextView.setText(sj27_database);




                    TextView sj28TextView = findViewById(R.id.sj28_textView);
                    sj28TextView.setText(sj28_database);




                    TextView sj29TextView = findViewById(R.id.sj29_textView);
                    sj29TextView.setText(sj29_database);




                    TextView sj30TextView = findViewById(R.id.sj30_textView);
                    sj30TextView.setText(sj30_database);




                    TextView tn1TextView = findViewById(R.id.tn_textView);
                    tn1TextView.setText(tn1_database);




                    TextView tn2TextView = findViewById(R.id.tn2_textView);
                    tn2TextView.setText(tn2_database);




                    TextView tn3TextView = findViewById(R.id.tn3_textView);
                    tn3TextView.setText(tn3_database);




                    TextView tn4TextView = findViewById(R.id.tn4_textView);
                    tn4TextView.setText(tn4_database);




                    TextView tn5TextView = findViewById(R.id.tn5_textView);
                    tn5TextView.setText(tn5_database);




                    TextView tn6TextView = findViewById(R.id.tn6_textView);
                    tn6TextView.setText(tn6_database);




                    TextView tn7TextView = findViewById(R.id.tn7_textView);
                    tn7TextView.setText(tn7_database);




                    TextView tn8TextView = findViewById(R.id.tn8_textView);
                    tn8TextView.setText(tn8_database);




                    TextView tn9TextView = findViewById(R.id.tn9_textView);
                    tn9TextView.setText(tn9_database);




                    TextView tn10TextView = findViewById(R.id.tn10_textView);
                    tn10TextView.setText(tn10_database);




                    TextView tn11TextView = findViewById(R.id.tn11_textView);
                    tn11TextView.setText(tn11_database);




                    TextView tn12TextView = findViewById(R.id.tn12_textView);
                    tn12TextView.setText(tn12_database);




                    TextView tn13TextView = findViewById(R.id.tn13_textView);
                    tn13TextView.setText(tn13_database);




                    TextView tn14TextView = findViewById(R.id.tn14_textView);
                    tn14TextView.setText(tn14_database);




                    TextView tn15TextView = findViewById(R.id.tn15_textView);
                    tn15TextView.setText(tn15_database);




                    TextView tn16TextView = findViewById(R.id.tn16_textView);
                    tn16TextView.setText(tn16_database);




                    TextView tn17TextView = findViewById(R.id.tn17_textView);
                    tn17TextView.setText(tn17_database);




                    TextView tn18TextView = findViewById(R.id.tn18_textView);
                    tn18TextView.setText(tn18_database);




                    TextView tn19TextView = findViewById(R.id.tn19_textView);
                    tn19TextView.setText(tn19_database);




                    TextView tn20TextView = findViewById(R.id.tn20_textView);
                    tn20TextView.setText(tn20_database);




                    TextView tn21TextView = findViewById(R.id.tn21_textView);
                    tn21TextView.setText(tn21_database);




                    TextView tn22TextView = findViewById(R.id.tn22_textView);
                    tn22TextView.setText(tn22_database);




                    TextView tn23TextView = findViewById(R.id.tn23_textView);
                    tn23TextView.setText(tn23_database);




                    TextView tn24TextView = findViewById(R.id.tn24_textView);
                    tn24TextView.setText(tn24_database);




                    TextView tn25TextView = findViewById(R.id.tn25_textView);
                    tn25TextView.setText(tn25_database);




                    TextView tn26TextView = findViewById(R.id.tn26_textView);
                    tn26TextView.setText(tn26_database);




                    TextView tn27TextView = findViewById(R.id.tn27_textView);
                    tn27TextView.setText(tn27_database);




                    TextView tn28TextView = findViewById(R.id.tn28_textView);
                    tn28TextView.setText(tn28_database);




                    TextView tn29TextView = findViewById(R.id.tn29_textView);
                    tn29TextView.setText(tn29_database);




                    TextView tn30TextView = findViewById(R.id.tn30_textView);
                    tn30TextView.setText(tn30_database);




                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                name_database = "error";
                grade_database = "error";
            }
        });
        Log.d("テスト","ポイント1");


        // ボタンを取得
        ImageButton finishButton = findViewById(R.id.bt_comment);


        // ボタンのクリックリスナーを設定
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SubActivity.class);
                // ボタンがクリックされたときの処理をここに記述
                Intent intentG = getIntent();
                String gmail = intentG.getStringExtra("gmail");
                intent.putExtra("gmail",gmail);
                startActivity(intent);// アクティビティを終了する
            }
        });
        Intent intent=getIntent();
        Log.d("テスト","ポイント2");
    }




    public void onClick(View v) {
        // 画面遷移ボタンの処理をここに記述
        Intent intent = new Intent(this, SettingActivity.class);
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        startActivity(intent);
    }


    public void onClick1(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number1=1;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number1",number1);
        startActivity(intent);
    }


    public void onClick2(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number2=2;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number2",number2);
        startActivity(intent);
    }


    public void onClick3(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number3=3;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number3",number3);
        startActivity(intent);
    }


    public void onClick4(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number4=4;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number4",number4);
        startActivity(intent);
    }


    public void onClick5(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number5=5;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number5",number5);
        startActivity(intent);
    }


    public void onClick6(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number6 = 6;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number6", number6);
        startActivity(intent);
    }


    public void onClick7(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number7=7;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number7",number7);
        startActivity(intent);
    }


    public void onClick8(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number8=8;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number8",number8);
        startActivity(intent);
    }


    public void onClick9(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number9=9;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number9",number9);
        startActivity(intent);
    }


    public void onClick10(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number10=10;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number10",number10);
        startActivity(intent);
    }


    public void onClick11(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number11=11;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number11",number11);
        startActivity(intent);
    }


    public void onClick12(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number12=12;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number12",number12);
        startActivity(intent);
    }


    public void onClick13(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number13=13;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number13",number13);
        startActivity(intent);
    }


    public void onClick14(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number14=14;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number14",number14);
        startActivity(intent);
    }


    public void onClick15(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number15=15;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number15",number15);
        startActivity(intent);
    }


    public void onClick16(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number16=16;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number16",number16);
        startActivity(intent);
    }


    public void onClick17(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number17=17;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number17",number17);
        startActivity(intent);
    }


    public void onClick18(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number18=18;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number18",number18);
        startActivity(intent);
    }


    public void onClick19(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number19=19;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number19",number19);
        startActivity(intent);
    }


    public void onClick20(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number20=20;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number20",number20);
        startActivity(intent);
    }


    public void onClick21(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number21=21;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number21",number21);
        startActivity(intent);
    }


    public void onClick22(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number22=22;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number22",number22);
        startActivity(intent);
    }


    public void onClick23(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number23=23;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number23",number23);
        startActivity(intent);
    }


    public void onClick24(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number24=24;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number24",number24);
        startActivity(intent);
    }


    public void onClick25(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number25=25;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number25",number25);
        startActivity(intent);
    }


    public void onClick26(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number26=26;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number26",number26);
        startActivity(intent);
    }


    public void onClick27(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number27=27;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number27",number27);
        startActivity(intent);
    }


    public void onClick28(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number28=28;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number28",number28);
        startActivity(intent);
    }


    public void onClick29(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number29=29;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number29",number29);
        startActivity(intent);
    }


    public void onClick30(View v) {
        Intent intent = new Intent(this, TimeActivity.class);
        int number30 = 30;
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        intent.putExtra("gmail",gmail);
        intent.putExtra("number30", number30);
        startActivity(intent);
    }
}

