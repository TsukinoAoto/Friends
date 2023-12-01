package com.yuyakaido.android.cardstackview.sample;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

public class SubActivity extends AppCompatActivity {
    private List<ThreadDataModel3> dataList;
    UserProfileData userprofiledata = new UserProfileData();
    private String name = "";


    public class UserProfile{
        String id = "";
        String name ="";
        String department ="";
        String subject ="";
        String grade ="";
        String gender ="";
        String group ="";
        String introduction="";
        ArrayList<String> hobbies = new ArrayList<String>(Arrays.asList(""));
        String imageBase64 ="";
        //var number:Int=0,
        Bitmap bmp = null;
    }


    //ユーザーを入れるリスト
    private ArrayList<UserProfile> UserManagement = new ArrayList<UserProfile>();
    //ユーザーidのリスト
    private ArrayList<String> user_id = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");

        MySingleton mySingleton = MySingleton.getInstance();
        //UserProfileDataを他のアクティビティでも使えるようにする
        userprofiledata = (UserProfileData) this.getApplication();


        //firebaseからプロフィール情報をもろもろ取得する
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Profile");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    if (childSnapshot != null && Integer.parseInt(childSnapshot.getKey()) != Integer.parseInt(gmail)) {
                        user_id.add(childSnapshot.getKey());
                    }
                }
                for (String userid : user_id) {
                    Bitmap bmp_dummy = null;
                    String imageBase64_dummy = "";
                    imageBase64_dummy = snapshot.child(userid).child("Base64Image").getValue(String.class);
                    if (imageBase64_dummy != null) {
                        byte[] decodeImg = Base64.getDecoder().decode(imageBase64_dummy);
                        bmp_dummy = BitmapFactory.decodeByteArray(decodeImg, 0, decodeImg.length);
                    } else {
                    }


                    UserProfile user = new UserProfile();
                    user.id = userid;
                    if (snapshot.child(userid).child("name").getValue(String.class) != null) {
                        user.name = snapshot.child(userid).child("name").getValue(String.class);
                    }
                    if (snapshot.child(userid).child("department").getValue(String.class) != null) {
                        user.department = snapshot.child(userid).child("department").getValue(String.class);
                    }
                    if (snapshot.child(userid).child("subject").getValue(String.class) != null) {
                        user.subject = snapshot.child(userid).child("subject").getValue(String.class);
                    }
                    if (snapshot.child(userid).child("grade").getValue(String.class) != null) {
                        user.grade = snapshot.child(userid).child("grade").getValue(String.class);
                    }
                    if (snapshot.child(userid).child("gender").getValue(String.class) != null) {
                        user.gender = snapshot.child(userid).child("gender").getValue(String.class);
                    }
                    if (snapshot.child(userid).child("group").getValue(String.class) != null) {
                        user.group = snapshot.child(userid).child("group").getValue(String.class);
                    }
                    if (snapshot.child(userid).child("introduction").getValue(String.class) != null) {
                        user.introduction = snapshot.child(userid).child("introduction").getValue(String.class);
                    }
                    if (snapshot.child(userid).child("hobbies").getChildren() != null) {
                        for (DataSnapshot HobbiesSnapshot : snapshot.child(userid).child("hobbies").getChildren()) {
                            String value = HobbiesSnapshot.getValue(String.class);
                            user.hobbies.add(value);
                        }
                    }
                    if (snapshot.child(userid).child("Base64Image").getValue(String.class) != null) {
                        user.imageBase64 = snapshot.child(userid).child("Base64Image").getValue(String.class);
                    }
                    user.bmp = bmp_dummy;


                    UserManagement.add(user);


                    //userprofiledata.CLEAR();
                    if (user.id != gmail) {
                        userprofiledata.addUser(
                                user.id,
                                user.name,
                                user.department,
                                user.subject,
                                user.grade,
                                user.gender,
                                user.group,
                                user.introduction,
                                user.hobbies,
                                user.imageBase64,
                                user.bmp
                        );
                    }
                }


                userprofiledata.show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


        // データを設定
        mySingleton.setData(gmail);

        // BottomNavigationViewのイベント設定を呼び出す
        setNaviViewEvent();

        // フラグメントにデータを渡すためにバンドルを作成
        Bundle bundle = new Bundle();
        bundle.putString("gmail", gmail);
        // ThreadFragmentをインスタンス化し、バンドルをセット
        ThreadFragment threadFragment = new ThreadFragment();
        threadFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, threadFragment)
                .commit();

        ImageButton matching_btn = findViewById(R.id.matching_btn);
        matching_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, MatchingActivity.class);
                Intent intentG = getIntent();
                String gmail = intentG.getStringExtra("gmail");
                intent.putExtra("gmail", gmail);
                startActivity(intent);
            }
        });

        ImageButton profile_btn = findViewById(R.id.profile_btn);
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, ProfileActivity.class);
                Intent intentG = getIntent();
                String gmail = intentG.getStringExtra("gmail");
                intent.putExtra("gmail", gmail);
                startActivity(intent);
            }
        });
    }

    //BottomNavigationViewのイベント設定
    private void setNaviViewEvent(){
        BottomNavigationView navView=findViewById(R.id.nav_view);
        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //switch()文でイベント分岐
                //item.getItemId()で、各メニューに設定した「id」を取得できる
                if (item.getItemId() == R.id.navigation_home) {
                    ThreadFragment threadFragment = new ThreadFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, threadFragment)
                            .commit();

                    return true;
                } else if (item.getItemId() == R.id.navigation_thread) {

                    return true;
                } else if (item.getItemId() == R.id.navigation_message) {
                    ChatFragment chatFragment = new ChatFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, chatFragment)
                            .commit();

                    return true;
                } else if (item.getItemId() == R.id.navigation_profile) {

                    return true;
                }else{
                    return false;
                }
            }
        });
    }
}

