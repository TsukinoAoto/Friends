package com.yuyakaido.android.cardstackview.sample;


import android.app.Application;
import android.graphics.Bitmap;
import android.util.Log;


import java.util.ArrayList;


public class UserProfileData extends Application {
    private class UserProfile{
        String id = "";
        String name ="";
        String department ="";
        String subject ="";
        String grade ="";
        String gender ="";
        String group ="";
        String introduction="";
        ArrayList<String> hobbies = new ArrayList<String>();
        String imageBase64 ="";
        //var number:Int=0,
        Bitmap bmp= null;
    }


    ArrayList<UserProfile> manage = new ArrayList<UserProfile>();


    @Override
    public void onCreate() {
        super.onCreate();
    }


    public void CLEAR(){
        manage.clear();
    }


    public void addUser(
            String id,
            String name,
            String department,
            String subject,
            String grade,
            String gender,
            String group,
            String introduction,
            ArrayList<String> hobbies,
            String imageBase64,
            Bitmap bmp){


        UserProfile user = new UserProfile();
        user.id = id;
        user.name = name;
        user.department = department;
        user.subject = subject;
        user.grade = grade;
        user.gender = gender;
        user.group = group;
        user.introduction = introduction;
        user.hobbies = hobbies;
        user.imageBase64 = imageBase64;
        user.bmp = bmp;


        manage.add(user);
        Log.d("テスト","ユーザーを追加しました");
    }
    public int getUseNum(){
        return manage.size();
    }
    public void show(){


        Log.d("メッセージ","show start");
        for (int i = 0; i < manage.size()-1 ; i++){
            Log.d("テスト",manage.get(i).id);
            Log.d("テスト",manage.get(i).name);
            Log.d("テスト",manage.get(i).department);
            Log.d("テスト",manage.get(i).subject);
            Log.d("テスト",manage.get(i).grade);
            Log.d("テスト",manage.get(i).gender);
            Log.d("テスト",manage.get(i).group);
            Log.d("テスト",manage.get(i).introduction);


        }
    }


    public String getID(int number){
        return manage.get(number).id;
    }
    public String getNAME(int number){
        return manage.get(number).name;
    }
    public String getDEPARTMENT(int number){
        return manage.get(number).department;
    }
    public String getSUBJECT(int number){
        return manage.get(number).subject;
    }
    public String getGRADE(int number){
        return manage.get(number).grade;
    }
    public String getGENDER(int number){
        return manage.get(number).gender;
    }
    public String getGROUP(int number){
        return manage.get(number).group;
    }
    public String getINTRODUCTION(int number){
        return manage.get(number).introduction;
    }
    public String getIMAGEBASE64(int number){
        return manage.get(number).imageBase64;
    }
    public Bitmap getBMP(int number){
        return manage.get(number).bmp;
    }
}


