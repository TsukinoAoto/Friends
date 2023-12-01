package com.yuyakaido.android.cardstackview.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TimeActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner subject_Spinner1,subject_Spinner2,subject_Spinner3,subject_Spinner4,subject_Spinner5,subject_Spinner6,subject_Spinner7,subject_Spinner8,subject_Spinner9,subject_Spinner10,subject_Spinner11,subject_Spinner12,subject_Spinner13,subject_Spinner14,subject_Spinner15,subject_Spinner16,subject_Spinner17,subject_Spinner18,subject_Spinner19,subject_Spinner20,subject_Spinner21,subject_Spinner22,subject_Spinner23,subject_Spinner24,subject_Spinner25,subject_Spinner26,subject_Spinner27,subject_Spinner28,subject_Spinner29,subject_Spinner30;

    private Spinner teacher_Spinner1,teacher_Spinner2,teacher_Spinner3,teacher_Spinner4,teacher_Spinner5,teacher_Spinner6,teacher_Spinner7,teacher_Spinner8,teacher_Spinner9,teacher_Spinner10,teacher_Spinner11,teacher_Spinner12,teacher_Spinner13,teacher_Spinner14,teacher_Spinner15,teacher_Spinner16,teacher_Spinner17,teacher_Spinner18,teacher_Spinner19,teacher_Spinner20,teacher_Spinner21,teacher_Spinner22,teacher_Spinner23,teacher_Spinner24,teacher_Spinner25,teacher_Spinner26,teacher_Spinner27,teacher_Spinner28,teacher_Spinner29,teacher_Spinner30;
    int number1, number2,number3,number4,number5, number6,number7,number8,number9, number10,number11,number12,number13, number14,number15,number16, number17, number18,number19,number20,number21, number22,number23,number24,number25, number26,number27,number28,number29, number30;
    private int defaultValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        subject_Spinner1= findViewById(R.id.subject);
        teacher_Spinner1 = findViewById(R.id.teacher);
        subject_Spinner2= findViewById(R.id.subject);
        teacher_Spinner2 = findViewById(R.id.teacher);
        subject_Spinner3= findViewById(R.id.subject);
        teacher_Spinner3 = findViewById(R.id.teacher);
        subject_Spinner4= findViewById(R.id.subject);
        teacher_Spinner4 = findViewById(R.id.teacher);
        subject_Spinner5= findViewById(R.id.subject);
        teacher_Spinner5 = findViewById(R.id.teacher);
        subject_Spinner6= findViewById(R.id.subject);
        teacher_Spinner6 = findViewById(R.id.teacher);
        subject_Spinner7= findViewById(R.id.subject);
        teacher_Spinner7 = findViewById(R.id.teacher);
        subject_Spinner8= findViewById(R.id.subject);
        teacher_Spinner8 = findViewById(R.id.teacher);
        subject_Spinner9= findViewById(R.id.subject);
        teacher_Spinner9 = findViewById(R.id.teacher);
        subject_Spinner10 = findViewById(R.id.subject);
        teacher_Spinner10 = findViewById(R.id.teacher);
        subject_Spinner11= findViewById(R.id.subject);
        teacher_Spinner11= findViewById(R.id.teacher);
        subject_Spinner12= findViewById(R.id.subject);
        teacher_Spinner12 = findViewById(R.id.teacher);
        subject_Spinner13= findViewById(R.id.subject);
        teacher_Spinner13 = findViewById(R.id.teacher);
        subject_Spinner14= findViewById(R.id.subject);
        teacher_Spinner14 = findViewById(R.id.teacher);
        subject_Spinner15= findViewById(R.id.subject);
        teacher_Spinner15 = findViewById(R.id.teacher);
        subject_Spinner16= findViewById(R.id.subject);
        teacher_Spinner16 = findViewById(R.id.teacher);
        subject_Spinner17= findViewById(R.id.subject);
        teacher_Spinner17 = findViewById(R.id.teacher);
        subject_Spinner18= findViewById(R.id.subject);
        teacher_Spinner18 = findViewById(R.id.teacher);
        subject_Spinner19= findViewById(R.id.subject);
        teacher_Spinner19 = findViewById(R.id.teacher);
        subject_Spinner20= findViewById(R.id.subject);
        teacher_Spinner20 = findViewById(R.id.teacher);
        subject_Spinner21= findViewById(R.id.subject);
        teacher_Spinner21 = findViewById(R.id.teacher);
        subject_Spinner22= findViewById(R.id.subject);
        teacher_Spinner22 = findViewById(R.id.teacher);
        subject_Spinner23= findViewById(R.id.subject);
        teacher_Spinner23 = findViewById(R.id.teacher);
        subject_Spinner24= findViewById(R.id.subject);
        teacher_Spinner24 = findViewById(R.id.teacher);
        subject_Spinner25= findViewById(R.id.subject);
        teacher_Spinner25 = findViewById(R.id.teacher);
        subject_Spinner26= findViewById(R.id.subject);
        teacher_Spinner26 = findViewById(R.id.teacher);
        subject_Spinner27= findViewById(R.id.subject);
        teacher_Spinner27 = findViewById(R.id.teacher);
        subject_Spinner28= findViewById(R.id.subject);
        teacher_Spinner28 = findViewById(R.id.teacher);
        subject_Spinner29= findViewById(R.id.subject);
        teacher_Spinner29 = findViewById(R.id.teacher);
        subject_Spinner30= findViewById(R.id.subject);
        teacher_Spinner30 = findViewById(R.id.teacher);

        ArrayAdapter<CharSequence> subjectAdapter1 = ArrayAdapter.createFromResource(this, R.array.subjectM1, android.R.layout.simple_spinner_item);
        subjectAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner1.setAdapter(subjectAdapter1);
        subject_Spinner1.setOnItemSelectedListener(this);
        teacher_Spinner1.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter2 = ArrayAdapter.createFromResource(this, R.array.subjectM2, android.R.layout.simple_spinner_item);
        subjectAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner2.setAdapter(subjectAdapter2);
        subject_Spinner2.setOnItemSelectedListener(this);
        teacher_Spinner2.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter3 = ArrayAdapter.createFromResource(this, R.array.subjectM3, android.R.layout.simple_spinner_item);
        subjectAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner3.setAdapter(subjectAdapter3);
        subject_Spinner3.setOnItemSelectedListener(this);
        teacher_Spinner3.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter4 = ArrayAdapter.createFromResource(this, R.array.subjectM4, android.R.layout.simple_spinner_item);
        subjectAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner4.setAdapter(subjectAdapter4);
        subject_Spinner4.setOnItemSelectedListener(this);
        teacher_Spinner4.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter5 = ArrayAdapter.createFromResource(this, R.array.subjectM5, android.R.layout.simple_spinner_item);
        subjectAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner5.setAdapter(subjectAdapter5);
        subject_Spinner5.setOnItemSelectedListener(this);
        teacher_Spinner5.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter6 = ArrayAdapter.createFromResource(this, R.array.subjectM6, android.R.layout.simple_spinner_item);
        subjectAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner6.setAdapter(subjectAdapter6);
        subject_Spinner6.setOnItemSelectedListener(this);
        teacher_Spinner6.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter7 = ArrayAdapter.createFromResource(this, R.array.subjectTu1, android.R.layout.simple_spinner_item);
        subjectAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner7.setAdapter(subjectAdapter7);
        subject_Spinner7.setOnItemSelectedListener(this);
        teacher_Spinner7.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter8 = ArrayAdapter.createFromResource(this, R.array.subjectTu2, android.R.layout.simple_spinner_item);
        subjectAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner8.setAdapter(subjectAdapter8);
        subject_Spinner8.setOnItemSelectedListener(this);
        teacher_Spinner8.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter9 = ArrayAdapter.createFromResource(this, R.array.subjectTu3, android.R.layout.simple_spinner_item);
        subjectAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner9.setAdapter(subjectAdapter9);
        subject_Spinner9.setOnItemSelectedListener(this);
        teacher_Spinner9.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter10 = ArrayAdapter.createFromResource(this, R.array.subjectTu4, android.R.layout.simple_spinner_item);
        subjectAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner10.setAdapter(subjectAdapter10);
        subject_Spinner10.setOnItemSelectedListener(this);
        teacher_Spinner10.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter11 = ArrayAdapter.createFromResource(this, R.array.subjectTu5, android.R.layout.simple_spinner_item);
        subjectAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner11.setAdapter(subjectAdapter11);
        subject_Spinner11.setOnItemSelectedListener(this);
        teacher_Spinner11.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter12 = ArrayAdapter.createFromResource(this, R.array.subjectTu6, android.R.layout.simple_spinner_item);
        subjectAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner12.setAdapter(subjectAdapter12);
        subject_Spinner12.setOnItemSelectedListener(this);
        teacher_Spinner12.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter13 = ArrayAdapter.createFromResource(this, R.array.subjectW1, android.R.layout.simple_spinner_item);
        subjectAdapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner13.setAdapter(subjectAdapter13);
        subject_Spinner13.setOnItemSelectedListener(this);
        teacher_Spinner13.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter14 = ArrayAdapter.createFromResource(this, R.array.subjectW2, android.R.layout.simple_spinner_item);
        subjectAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner14.setAdapter(subjectAdapter14);
        subject_Spinner14.setOnItemSelectedListener(this);
        teacher_Spinner14.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter15 = ArrayAdapter.createFromResource(this, R.array.subjectW3, android.R.layout.simple_spinner_item);
        subjectAdapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner15.setAdapter(subjectAdapter15);
        subject_Spinner15.setOnItemSelectedListener(this);
        teacher_Spinner15.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter16 = ArrayAdapter.createFromResource(this, R.array.subjectW4, android.R.layout.simple_spinner_item);
        subjectAdapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner16.setAdapter(subjectAdapter16);
        subject_Spinner16.setOnItemSelectedListener(this);
        teacher_Spinner16.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter17 = ArrayAdapter.createFromResource(this, R.array.subjectW5, android.R.layout.simple_spinner_item);
        subjectAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner17.setAdapter(subjectAdapter17);
        subject_Spinner17.setOnItemSelectedListener(this);
        teacher_Spinner17.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter18 = ArrayAdapter.createFromResource(this, R.array.subjectW6, android.R.layout.simple_spinner_item);
        subjectAdapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner18.setAdapter(subjectAdapter18);
        subject_Spinner18.setOnItemSelectedListener(this);
        teacher_Spinner18.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter19 = ArrayAdapter.createFromResource(this, R.array.subjectTh1, android.R.layout.simple_spinner_item);
        subjectAdapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner19.setAdapter(subjectAdapter19);
        subject_Spinner19.setOnItemSelectedListener(this);
        teacher_Spinner19.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter20 = ArrayAdapter.createFromResource(this, R.array.subjectTh2, android.R.layout.simple_spinner_item);
        subjectAdapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner20.setAdapter(subjectAdapter20);
        subject_Spinner20.setOnItemSelectedListener(this);
        teacher_Spinner20.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter21 = ArrayAdapter.createFromResource(this, R.array.subjectTh3, android.R.layout.simple_spinner_item);
        subjectAdapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner21.setAdapter(subjectAdapter21);
        subject_Spinner21.setOnItemSelectedListener(this);
        teacher_Spinner21.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter22 = ArrayAdapter.createFromResource(this, R.array.subjectTh4, android.R.layout.simple_spinner_item);
        subjectAdapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner22.setAdapter(subjectAdapter22);
        subject_Spinner22.setOnItemSelectedListener(this);
        teacher_Spinner22.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter23 = ArrayAdapter.createFromResource(this, R.array.subjectTh5, android.R.layout.simple_spinner_item);
        subjectAdapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner23.setAdapter(subjectAdapter1);
        subject_Spinner23.setOnItemSelectedListener(this);
        teacher_Spinner23.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter24 = ArrayAdapter.createFromResource(this, R.array.subjectTh6, android.R.layout.simple_spinner_item);
        subjectAdapter24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner24.setAdapter(subjectAdapter2);
        subject_Spinner24.setOnItemSelectedListener(this);
        teacher_Spinner24.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter25 = ArrayAdapter.createFromResource(this, R.array.subjectF1, android.R.layout.simple_spinner_item);
        subjectAdapter25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner25.setAdapter(subjectAdapter1);
        subject_Spinner25.setOnItemSelectedListener(this);
        teacher_Spinner25.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter26 = ArrayAdapter.createFromResource(this, R.array.subjectF2, android.R.layout.simple_spinner_item);
        subjectAdapter26.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner26.setAdapter(subjectAdapter26);
        subject_Spinner26.setOnItemSelectedListener(this);
        teacher_Spinner26.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter27 = ArrayAdapter.createFromResource(this, R.array.subjectF3, android.R.layout.simple_spinner_item);
        subjectAdapter27.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner27.setAdapter(subjectAdapter27);
        subject_Spinner27.setOnItemSelectedListener(this);
        teacher_Spinner27.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter28 = ArrayAdapter.createFromResource(this, R.array.subjectF4, android.R.layout.simple_spinner_item);
        subjectAdapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner28.setAdapter(subjectAdapter28);
        subject_Spinner28.setOnItemSelectedListener(this);
        teacher_Spinner28.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter29 = ArrayAdapter.createFromResource(this, R.array.subjectF5, android.R.layout.simple_spinner_item);
        subjectAdapter29.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner29.setAdapter(subjectAdapter29);
        subject_Spinner29.setOnItemSelectedListener(this);
        teacher_Spinner29.setEnabled(false);

        ArrayAdapter<CharSequence> subjectAdapter30= ArrayAdapter.createFromResource(this, R.array.subjectF6, android.R.layout.simple_spinner_item);
        subjectAdapter30.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Spinner30.setAdapter(subjectAdapter30);
        subject_Spinner30.setOnItemSelectedListener(this);
        teacher_Spinner30.setEnabled(false);

        Intent intent = getIntent();
        number1 = intent.getIntExtra("number1",defaultValue);
        number2 = intent.getIntExtra("number2",defaultValue);
        number3 = intent.getIntExtra("number3",defaultValue);
        number4 = intent.getIntExtra("number4",defaultValue);
        number5 = intent.getIntExtra("number5",defaultValue);
        number6 = intent.getIntExtra("number6",defaultValue);
        number7 = intent.getIntExtra("number7",defaultValue);
        number8 = intent.getIntExtra("number8",defaultValue);
        number9 = intent.getIntExtra("number9",defaultValue);
        number10 = intent.getIntExtra("number10",defaultValue);
        number11 = intent.getIntExtra("number11",defaultValue);
        number12 = intent.getIntExtra("number12",defaultValue);
        number13 = intent.getIntExtra("number13",defaultValue);
        number14 = intent.getIntExtra("number14",defaultValue);
        number15 = intent.getIntExtra("number15",defaultValue);
        number16 = intent.getIntExtra("number16",defaultValue);
        number17 = intent.getIntExtra("number17",defaultValue);
        number18 = intent.getIntExtra("number18",defaultValue);
        number19 = intent.getIntExtra("number19",defaultValue);
        number20 = intent.getIntExtra("number20",defaultValue);
        number21 = intent.getIntExtra("number21",defaultValue);
        number22 = intent.getIntExtra("number22",defaultValue);
        number23 = intent.getIntExtra("number23",defaultValue);
        number24 = intent.getIntExtra("number24",defaultValue);
        number25 = intent.getIntExtra("number25",defaultValue);
        number26 = intent.getIntExtra("number26",defaultValue);
        number27 = intent.getIntExtra("number27",defaultValue);
        number28 = intent.getIntExtra("number28",defaultValue);
        number29 = intent.getIntExtra("number29",defaultValue);
        number30 = intent.getIntExtra("number30",defaultValue);

    }

    public void onClick(View v) {
        Intent intent = new Intent(this, ProfileActivity.class);
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        // Firebase Realtime Databaseの"profile"ノードへの参照を取得
        DatabaseReference profileRef = FirebaseDatabase.getInstance().getReference().child("Profile").child(gmail);

        if (number1 == 1) {
            String selectedSubject1 = subject_Spinner1.getSelectedItem().toString();
            intent.putExtra("sj_textView", selectedSubject1);
            profileRef.child("sj_1").setValue(selectedSubject1);

            String selectedTeacher1 = teacher_Spinner1.getSelectedItem().toString();
            intent.putExtra("tn_textView", selectedTeacher1);
            profileRef.child("tn_1").setValue(selectedTeacher1);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
            finish();
        }

        if (number2 == 2) {
            String selectedSubject2 = subject_Spinner2.getSelectedItem().toString();
            intent.putExtra("sj2_textView", selectedSubject2);
            profileRef.child("sj_2").setValue(selectedSubject2);

            String selectedTeacher2 = teacher_Spinner2.getSelectedItem().toString();
            intent.putExtra("tn2_textView", selectedTeacher2);
            profileRef.child("tn_2").setValue(selectedTeacher2);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number3 == 3) {
            String selectedSubject3 = subject_Spinner3.getSelectedItem().toString();
            intent.putExtra("sj3_textView", selectedSubject3);
            profileRef.child("sj_3").setValue(selectedSubject3);

            String selectedTeacher3 = teacher_Spinner3.getSelectedItem().toString();
            intent.putExtra("tn3_textView", selectedTeacher3);
            profileRef.child("tn_3").setValue(selectedTeacher3);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number4 == 4) {
            String selectedSubject4 = subject_Spinner4.getSelectedItem().toString();
            intent.putExtra("sj4_textView", selectedSubject4);
            profileRef.child("sj_4").setValue(selectedSubject4);

            String selectedTeacher4 = teacher_Spinner4.getSelectedItem().toString();
            intent.putExtra("tn4_textView", selectedTeacher4);
            profileRef.child("tn_4").setValue(selectedTeacher4);

            intent.putExtra("gmail",gmail);
            startActivity(intent);

        }

        if (number5 == 5) {
            String selectedSubject5 = subject_Spinner5.getSelectedItem().toString();
            intent.putExtra("sj5_textView", selectedSubject5);
            profileRef.child("sj_5").setValue(selectedSubject5);

            String selectedTeacher5 = teacher_Spinner5.getSelectedItem().toString();
            intent.putExtra("tn5_textView", selectedTeacher5);
            profileRef.child("tn_5").setValue(selectedTeacher5);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number6 == 6) {
            String selectedSubject6 = subject_Spinner6.getSelectedItem().toString();
            intent.putExtra("sj6_textView", selectedSubject6);
            profileRef.child("sj_6").setValue(selectedSubject6);

            String selectedTeacher6 = teacher_Spinner6.getSelectedItem().toString();
            intent.putExtra("tn6_textView", selectedTeacher6);
            profileRef.child("tn_6").setValue(selectedTeacher6);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number7 == 7) {
            String selectedSubject7 = subject_Spinner7.getSelectedItem().toString();
            intent.putExtra("sj7_textView", selectedSubject7);
            profileRef.child("sj_7").setValue(selectedSubject7);

            String selectedTeacher7 = teacher_Spinner7.getSelectedItem().toString();
            intent.putExtra("tn7_textView", selectedTeacher7);
            profileRef.child("tn_7").setValue(selectedTeacher7);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number8 == 8) {
            String selectedSubject8 = subject_Spinner8.getSelectedItem().toString();
            intent.putExtra("sj8_textView", selectedSubject8);
            profileRef.child("sj_8").setValue(selectedSubject8);

            String selectedTeacher8 = teacher_Spinner8.getSelectedItem().toString();
            intent.putExtra("tn8_textView", selectedTeacher8);
            profileRef.child("tn_8").setValue(selectedTeacher8);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number9 == 9) {
            String selectedSubject9 = subject_Spinner9.getSelectedItem().toString();
            intent.putExtra("sj9_textView", selectedSubject9);
            profileRef.child("sj_9").setValue(selectedSubject9);

            String selectedTeacher9 = teacher_Spinner9.getSelectedItem().toString();
            intent.putExtra("tn9_textView", selectedTeacher9);
            profileRef.child("tn_9").setValue(selectedTeacher9);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number10 == 10) {
            String selectedSubject10 = subject_Spinner10.getSelectedItem().toString();
            intent.putExtra("sj10_textView", selectedSubject10);
            profileRef.child("sj_10").setValue(selectedSubject10);

            String selectedTeacher10 = teacher_Spinner10.getSelectedItem().toString();
            intent.putExtra("tn10_textView", selectedTeacher10);
            profileRef.child("tn_10").setValue(selectedTeacher10);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number11 == 11) {
            String selectedSubject11 = subject_Spinner11.getSelectedItem().toString();
            intent.putExtra("sj11_textView", selectedSubject11);
            profileRef.child("sj_11").setValue(selectedSubject11);

            String selectedTeacher11 = teacher_Spinner11.getSelectedItem().toString();
            intent.putExtra("tn11_textView", selectedTeacher11);
            profileRef.child("tn_11").setValue(selectedTeacher11);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number12 == 12) {
            String selectedSubject12 = subject_Spinner12.getSelectedItem().toString();
            intent.putExtra("sj12_textView", selectedSubject12);
            profileRef.child("sj_12").setValue(selectedSubject12);

            String selectedTeacher12 = teacher_Spinner12.getSelectedItem().toString();
            intent.putExtra("tn12_textView", selectedTeacher12);
            profileRef.child("tn_12").setValue(selectedTeacher12);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number13 == 13) {
            String selectedSubject13 = subject_Spinner13.getSelectedItem().toString();
            intent.putExtra("sj13_textView", selectedSubject13);
            profileRef.child("sj_13").setValue(selectedSubject13);

            String selectedTeacher13 = teacher_Spinner13.getSelectedItem().toString();
            intent.putExtra("tn13_textView", selectedTeacher13);
            profileRef.child("tn_13").setValue(selectedTeacher13);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number14 == 14) {
            String selectedSubject14 = subject_Spinner14.getSelectedItem().toString();
            intent.putExtra("sj14_textView", selectedSubject14);
            profileRef.child("sj_14").setValue(selectedSubject14);

            String selectedTeacher14 = teacher_Spinner14.getSelectedItem().toString();
            intent.putExtra("tn14_textView", selectedTeacher14);
            profileRef.child("tn_14").setValue(selectedTeacher14);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number15 == 15) {
            String selectedSubject15 = subject_Spinner15.getSelectedItem().toString();
            intent.putExtra("sj15_textView", selectedSubject15);
            profileRef.child("sj_15").setValue(selectedSubject15);

            String selectedTeacher15 = teacher_Spinner15.getSelectedItem().toString();
            intent.putExtra("tn15_textView", selectedTeacher15);
            profileRef.child("tn_15").setValue(selectedTeacher15);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number16 == 16) {
            String selectedSubject16 = subject_Spinner16.getSelectedItem().toString();
            intent.putExtra("sj16_textView", selectedSubject16);
            profileRef.child("sj_16").setValue(selectedSubject16);

            String selectedTeacher16 = teacher_Spinner16.getSelectedItem().toString();
            intent.putExtra("tn16_textView", selectedTeacher16);
            profileRef.child("tn_16").setValue(selectedTeacher16);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number1 == 17) {
            String selectedSubject17 = subject_Spinner17.getSelectedItem().toString();
            intent.putExtra("sj17_textView", selectedSubject17);
            profileRef.child("sj_17").setValue(selectedSubject17);

            String selectedTeacher17 = teacher_Spinner17.getSelectedItem().toString();
            intent.putExtra("tn17_textView", selectedTeacher17);
            profileRef.child("tn_17").setValue(selectedTeacher17);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number18 == 18) {
            String selectedSubject18 = subject_Spinner2.getSelectedItem().toString();
            intent.putExtra("sj2_textView", selectedSubject18);
            profileRef.child("sj_18").setValue(selectedSubject18);

            String selectedTeacher18 = teacher_Spinner2.getSelectedItem().toString();
            intent.putExtra("tn2_textView", selectedTeacher18);
            profileRef.child("tn_18").setValue(selectedTeacher18);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number19 == 19) {
            String selectedSubject19 = subject_Spinner19.getSelectedItem().toString();
            intent.putExtra("sj19_textView", selectedSubject19);
            profileRef.child("sj_19").setValue(selectedSubject19);

            String selectedTeacher19 = teacher_Spinner19.getSelectedItem().toString();
            intent.putExtra("tn19_textView", selectedTeacher19);
            profileRef.child("tn_19").setValue(selectedTeacher19);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number20 == 20) {
            String selectedSubject20 = subject_Spinner20.getSelectedItem().toString();
            intent.putExtra("sj20_textView", selectedSubject20);
            profileRef.child("sj_20").setValue(selectedSubject20);

            String selectedTeacher20 = teacher_Spinner20.getSelectedItem().toString();
            intent.putExtra("tn20_textView", selectedTeacher20);
            profileRef.child("tn_20").setValue(selectedTeacher20);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number21 == 21) {
            String selectedSubject21 = subject_Spinner21.getSelectedItem().toString();
            intent.putExtra("sj21_textView", selectedSubject21);
            profileRef.child("sj_21").setValue(selectedSubject21);

            String selectedTeacher21 = teacher_Spinner21.getSelectedItem().toString();
            intent.putExtra("tn21_textView", selectedTeacher21);
            profileRef.child("tn_21").setValue(selectedTeacher21);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number22 == 22) {
            String selectedSubject22 = subject_Spinner22.getSelectedItem().toString();
            intent.putExtra("sj22_textView", selectedSubject22);
            profileRef.child("sj_22").setValue(selectedSubject22);

            String selectedTeacher22 = teacher_Spinner22.getSelectedItem().toString();
            intent.putExtra("tn22_textView", selectedTeacher22);
            profileRef.child("tn_22").setValue(selectedTeacher22);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number23 == 23 ) {
            String selectedSubject23 = subject_Spinner23.getSelectedItem().toString();
            intent.putExtra("sj23_textView", selectedSubject23);
            profileRef.child("sj_23").setValue(selectedSubject23);

            String selectedTeacher23 = teacher_Spinner23.getSelectedItem().toString();
            intent.putExtra("tn23_textView", selectedTeacher23);
            profileRef.child("tn_23").setValue(selectedTeacher23);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number24 == 24) {
            String selectedSubject24 = subject_Spinner24.getSelectedItem().toString();
            intent.putExtra("sj24_textView", selectedSubject24);
            profileRef.child("sj_24").setValue(selectedSubject24);

            String selectedTeacher24 = teacher_Spinner24.getSelectedItem().toString();
            intent.putExtra("tn24_textView", selectedTeacher24);
            profileRef.child("tn_24").setValue(selectedTeacher24);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number25 == 25) {
            String selectedSubject25 = subject_Spinner25.getSelectedItem().toString();
            intent.putExtra("sj25_textView", selectedSubject25);
            profileRef.child("sj_25").setValue(selectedSubject25);

            String selectedTeacher25 = teacher_Spinner25.getSelectedItem().toString();
            intent.putExtra("tn25_textView", selectedTeacher25);
            profileRef.child("tn_25").setValue(selectedTeacher25);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number26 == 26) {
            String selectedSubject26 = subject_Spinner26.getSelectedItem().toString();
            intent.putExtra("sj26_textView", selectedSubject26);
            profileRef.child("sj_26").setValue(selectedSubject26);

            String selectedTeacher26 = teacher_Spinner26.getSelectedItem().toString();
            intent.putExtra("tn26_textView", selectedTeacher26);
            profileRef.child("tn_26").setValue(selectedTeacher26);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }
        if (number27 == 27) {
            String selectedSubject27 = subject_Spinner27.getSelectedItem().toString();
            intent.putExtra("sj27_textView", selectedSubject27);
            profileRef.child("sj_27").setValue(selectedSubject27);

            String selectedTeacher27 = teacher_Spinner27.getSelectedItem().toString();
            intent.putExtra("tn27_textView", selectedTeacher27);
            profileRef.child("tn_27").setValue(selectedTeacher27);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number28 == 28) {
            String selectedSubject28 = subject_Spinner28.getSelectedItem().toString();
            intent.putExtra("sj28_textView", selectedSubject28);
            profileRef.child("sj_28").setValue(selectedSubject28);

            String selectedTeacher28 = teacher_Spinner28.getSelectedItem().toString();
            intent.putExtra("tn28_textView", selectedTeacher28);
            profileRef.child("tn_28").setValue(selectedTeacher28);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number29 == 29) {
            String selectedSubject29 = subject_Spinner29.getSelectedItem().toString();
            intent.putExtra("sj29_textView", selectedSubject29);
            profileRef.child("sj_29").setValue(selectedSubject29);

            String selectedTeacher29 = teacher_Spinner29.getSelectedItem().toString();
            intent.putExtra("tn29_textView", selectedTeacher29);
            profileRef.child("tn_29").setValue(selectedTeacher29);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }

        if (number30 == 30) {
            String selectedSubject30 = subject_Spinner30.getSelectedItem().toString();
            intent.putExtra("sj30_textView", selectedSubject30);
            profileRef.child("sj_30").setValue(selectedSubject30);

            String selectedTeacher30 = teacher_Spinner30.getSelectedItem().toString();
            intent.putExtra("tn30_textView", selectedTeacher30);
            profileRef.child("tn_30").setValue(selectedTeacher30);

            intent.putExtra("gmail",gmail);
            startActivity(intent);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String selectedOption = parent.getItemAtPosition(position).toString();
        if (selectedOption.equals("選択してください")) {
            return;
        }

        if (number1 == 1) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_M1_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner1.setAdapter(subjectAdapter);

                    teacher_Spinner1.setEnabled(true);
                } else {
                    teacher_Spinner1.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number2 == 2) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_M2_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner2.setAdapter(subjectAdapter);

                    teacher_Spinner2.setEnabled(true);
                } else {
                    teacher_Spinner2.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number3 == 3) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_M3_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner3.setAdapter(subjectAdapter);

                    teacher_Spinner3.setEnabled(true);
                } else {
                    teacher_Spinner3.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number4 == 4) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_M4_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner4.setAdapter(subjectAdapter);

                    teacher_Spinner4.setEnabled(true);
                } else {
                    teacher_Spinner4.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number5 == 5) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_M5_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner5.setAdapter(subjectAdapter);

                    teacher_Spinner5.setEnabled(true);
                } else {
                    teacher_Spinner5.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number6 == 6) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_M6_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner6.setAdapter(subjectAdapter);

                    teacher_Spinner6.setEnabled(true);
                } else {
                    teacher_Spinner6.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number7 == 7) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Tu1_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner7.setAdapter(subjectAdapter);

                    teacher_Spinner7.setEnabled(true);
                } else {
                    teacher_Spinner7.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number8 == 8) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Tu2_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner8.setAdapter(subjectAdapter);

                    teacher_Spinner8.setEnabled(true);
                } else {
                    teacher_Spinner8.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number9 == 9) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Tu3_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner9.setAdapter(subjectAdapter);

                    teacher_Spinner9.setEnabled(true);
                } else {
                    teacher_Spinner9.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number10 == 10) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Tu4_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner10.setAdapter(subjectAdapter);

                    teacher_Spinner10.setEnabled(true);
                } else {
                    teacher_Spinner10.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number11 == 11) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Tu5_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner11.setAdapter(subjectAdapter);

                    teacher_Spinner11.setEnabled(true);
                } else {
                    teacher_Spinner11.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number12 == 12) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Tu6_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner12.setAdapter(subjectAdapter);

                    teacher_Spinner12.setEnabled(true);
                } else {
                    teacher_Spinner12.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number13 == 13) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_W1_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner13.setAdapter(subjectAdapter);

                    teacher_Spinner13.setEnabled(true);
                } else {
                    teacher_Spinner13.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number14 == 14) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_W2_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner14.setAdapter(subjectAdapter);

                    teacher_Spinner14.setEnabled(true);
                } else {
                    teacher_Spinner14.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number15 == 15) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_W3_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner15.setAdapter(subjectAdapter);

                    teacher_Spinner15.setEnabled(true);
                } else {
                    teacher_Spinner15.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number16 == 16) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_W4_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner16.setAdapter(subjectAdapter);

                    teacher_Spinner16.setEnabled(true);
                } else {
                    teacher_Spinner16.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number17 == 17) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_W5_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner17.setAdapter(subjectAdapter);

                    teacher_Spinner17.setEnabled(true);
                } else {
                    teacher_Spinner17.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number18 == 18) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_W6_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner18.setAdapter(subjectAdapter);

                    teacher_Spinner18.setEnabled(true);
                } else {
                    teacher_Spinner18.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number19 == 19) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Th1_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner19.setAdapter(subjectAdapter);

                    teacher_Spinner19.setEnabled(true);
                } else {
                    teacher_Spinner19.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number20 == 20) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Th2_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner20.setAdapter(subjectAdapter);

                    teacher_Spinner20.setEnabled(true);
                } else {
                    teacher_Spinner20.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number21 == 21) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Th3_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner21.setAdapter(subjectAdapter);

                    teacher_Spinner21.setEnabled(true);
                } else {
                    teacher_Spinner21.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number22 == 22) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Th4_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner22.setAdapter(subjectAdapter);

                    teacher_Spinner22.setEnabled(true);
                } else {
                    teacher_Spinner22.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number23 == 23) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Th5_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner23.setAdapter(subjectAdapter);

                    teacher_Spinner23.setEnabled(true);
                } else {
                    teacher_Spinner23.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number24 == 24) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_Th6_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner24.setAdapter(subjectAdapter);

                    teacher_Spinner24.setEnabled(true);
                } else {
                    teacher_Spinner24.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number25 == 25) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_F1_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner25.setAdapter(subjectAdapter);

                    teacher_Spinner25.setEnabled(true);
                } else {
                    teacher_Spinner25.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number26 == 26) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_F2_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner26.setAdapter(subjectAdapter);

                    teacher_Spinner26.setEnabled(true);
                } else {
                    teacher_Spinner26.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number27 == 27) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_F3_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner27.setAdapter(subjectAdapter);

                    teacher_Spinner27.setEnabled(true);
                } else {
                    teacher_Spinner27.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number28 == 28) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_F4_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner28.setAdapter(subjectAdapter);

                    teacher_Spinner28.setEnabled(true);
                } else {
                    teacher_Spinner28.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number29 == 29) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_F5_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner29.setAdapter(subjectAdapter);

                    teacher_Spinner29.setEnabled(true);
                } else {
                    teacher_Spinner29.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }

        if (number30 == 30) {
            if (parent.getId() == R.id.subject) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                int subjectArrayResourceId = getResources().getIdentifier("subject_F6_" + (position + 1) + "_teacher", "array", getPackageName());

                if (subjectArrayResourceId != 0) {
                    ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this, subjectArrayResourceId, android.R.layout.simple_spinner_item);
                    subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    teacher_Spinner30.setAdapter(subjectAdapter);

                    teacher_Spinner30.setEnabled(true);
                } else {
                    teacher_Spinner30.setEnabled(false);
                }
            } else if (parent.getId() == R.id.teacher) {

                String selectedTeacher = parent.getSelectedItem().toString();

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


