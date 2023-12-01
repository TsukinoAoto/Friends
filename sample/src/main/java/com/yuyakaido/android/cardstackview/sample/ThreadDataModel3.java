package com.yuyakaido.android.cardstackview.sample;

import com.google.firebase.database.IgnoreExtraProperties;
// Firebase Realtime Databaseへのデータモデルクラス
@IgnoreExtraProperties

public class ThreadDataModel3 {
    private String field1;
    private String field2;
    private String field3;
    private String field4;

    private String field5;
    private String field6;
    private String field7;

    public ThreadDataModel3() {
        // デフォルトコンストラクタが必要です
    }

    public ThreadDataModel3(String field1, String field2, String field3, String field4, String field5, String field6,String field7) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.field6 = field6;
        this.field7 = field7;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    public String getField4() {
        return field4;
    }
    public String getField5(){return field5;}
    public String getField6(){return field6;}
    public String getField7(){return field7;}
}


