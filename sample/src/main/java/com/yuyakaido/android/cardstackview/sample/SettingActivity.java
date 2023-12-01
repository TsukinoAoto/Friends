package com.yuyakaido.android.cardstackview.sample;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class SettingActivity extends Activity implements AdapterView.OnItemSelectedListener {


    private static final int PHOTO_PICKER_REQUEST_CODE = 1;
    private ImageView imageView;


    private Spinner departmentSpinner;
    private Spinner subjectSpinner;
    private Spinner gradeSpinner;
    private Spinner classSpinner;
    private Spinner genderSpinner;
    private List<CheckBox> hobbyCheckBoxes = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        imageView = findViewById(R.id.imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);


        departmentSpinner = findViewById(R.id.department_spinner);
        subjectSpinner = findViewById(R.id.subject_spinner);
        gradeSpinner = findViewById(R.id.grade_spinner);
        classSpinner = findViewById(R.id.class_spinner);
        genderSpinner = findViewById(R.id.gender_spinner);


        // 各スピナーのアダプターを設定
        ArrayAdapter<CharSequence> departmentAdapter = ArrayAdapter.createFromResource(this,
                R.array.department, android.R.layout.simple_spinner_item);
        departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentSpinner.setAdapter(departmentAdapter);
        departmentSpinner.setOnItemSelectedListener(this);


        // 学科スピナーを初期状態では無効にしておく
        subjectSpinner.setEnabled(false);


        ArrayAdapter<CharSequence> gradeAdapter = ArrayAdapter.createFromResource(this,
                R.array.grades, android.R.layout.simple_spinner_item);
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gradeSpinner.setAdapter(gradeAdapter);
        gradeSpinner.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(this,
                R.array.group, android.R.layout.simple_spinner_item);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);
        classSpinner.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.genders, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);
        genderSpinner.setOnItemSelectedListener(this);


        // 各スピナーの初期選択を空欄に設定
        departmentSpinner.setSelection(0);
        gradeSpinner.setSelection(0);
        classSpinner.setSelection(0);
        genderSpinner.setSelection(0);


        // CheckBoxを動的に生成してリストに追加
        String[] hobbies = getResources().getStringArray(R.array.hobbies);
        for (String hobby : hobbies) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(hobby);
            hobbyCheckBoxes.add(checkBox);
        }


        // LinearLayoutを取得
        LinearLayout checkboxLayout = findViewById(R.id.hobby_checkbox_layout);


        // CheckBoxをLinearLayoutに追加
        for (CheckBox checkBox : hobbyCheckBoxes) {
            checkboxLayout.addView(checkBox);
        }


        // CheckBoxの状態変更リスナーを設定
        for (CheckBox checkBox : hobbyCheckBoxes) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String hobbyText = checkBox.getText().toString();
                    if (isChecked) {
                        // チェックされた場合の処理
                    } else {
                        // チェックが解除された場合の処理
                    }
                }
            });
        }
    }


    private Uri selectedImageUri;


    public void selectImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PHOTO_PICKER_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PHOTO_PICKER_REQUEST_CODE) {
                selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    Bitmap bitmap = loadImageFromUri(selectedImageUri);
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }


    private Bitmap loadImageFromUri(Uri uri) {
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void onClick2_1(View v) {
        Intent intent = new Intent(this, ProfileActivity.class);
        Intent intentG = getIntent();
        String gmail = intentG.getStringExtra("gmail");
        Log.d("SettingActivity", "gmail: " + gmail);


        // Firebase Realtime Databaseの"profile"ノードへの参照を取得
        DatabaseReference profileRef = FirebaseDatabase.getInstance().getReference("Profile").child(gmail);




        // 画像 URI を渡す
        if (selectedImageUri != null) {
            String imageUriString = selectedImageUri.toString();
            intent.putExtra("imageUri", selectedImageUri.toString());


            try {
                //inputstreamにuri情報を入れる
                InputStream inputStream = this.getApplicationContext().getContentResolver().openInputStream(selectedImageUri);


                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int bytesRead;
                byte[] data = new byte[1024]; // データを読み込むバッファサイズを指定


                while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, bytesRead);
                }
                buffer.flush();


                byte[] base64Bytes = Base64.getEncoder().encode(buffer.toByteArray());
                String base64BytesString = new String(base64Bytes, StandardCharsets.UTF_8);




                profileRef.child("Base64Image").setValue(base64BytesString);


            }catch (IOException e){
                Log.d("ごりら", "う");
            }
        }


        // 名前を渡す
        EditText editText = findViewById(R.id.nameText);
        String name = editText.getText().toString();
        intent.putExtra("name", name);


        // 自己紹介を渡す
        EditText editText5 = findViewById(R.id.syoukaiText);
        String selfIntroduction = editText5.getText().toString();
        intent.putExtra("syoukai", selfIntroduction);


        // 性別を渡す
        String selectedGender = genderSpinner.getSelectedItem().toString();
        intent.putExtra("gender", selectedGender);


        // 学年を渡す
        String selectedGrade = gradeSpinner.getSelectedItem().toString();
        intent.putExtra("grade", selectedGrade);


        // グループを渡す
        String selectedGroup = classSpinner.getSelectedItem().toString();
        intent.putExtra("group", selectedGroup);


        // 学部を渡す
        String selectedDepartment = departmentSpinner.getSelectedItem().toString();
        intent.putExtra("department", selectedDepartment);


        // 学科を渡す
        String selectedSubject = subjectSpinner.getSelectedItem().toString();
        intent.putExtra("subject", selectedSubject);


        // 選択された趣味を渡す
        ArrayList<String> selectedHobbies = new ArrayList<>();
        for (CheckBox checkBox : hobbyCheckBoxes) {
            if (checkBox.isChecked()) {
                selectedHobbies.add(checkBox.getText().toString());
            }
        }
        profileRef.child("hobbies").setValue(selectedHobbies);


        //学籍番号を渡す7
        intent.putExtra("number",gmail);






        // プロフィール情報を取得
        selectedDepartment = departmentSpinner.getSelectedItem().toString();
        selectedSubject = subjectSpinner.getSelectedItem().toString();
        selectedGrade = gradeSpinner.getSelectedItem().toString();
        selectedGroup = classSpinner.getSelectedItem().toString();
        selectedGender = genderSpinner.getSelectedItem().toString();
        name = editText.getText().toString();
        selfIntroduction = editText5.getText().toString();






        // プロフィール情報をFirebase Realtime Databaseに保存
        profileRef.child("department").setValue(selectedDepartment);
        profileRef.child("subject").setValue(selectedSubject);
        profileRef.child("grade").setValue(selectedGrade);
        profileRef.child("group").setValue(selectedGroup);
        profileRef.child("gender").setValue(selectedGender);
        profileRef.child("name").setValue(name);
        profileRef.child("introduction").setValue(selfIntroduction);
        profileRef.child("number").setValue(gmail);




        setResult(RESULT_CANCELED, intent);
        intent.putExtra("gmail",gmail);
        startActivity(intent);
        finish();


    }




    // AdapterView.OnItemSelectedListenerの実装
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // 選択項目が変更されたときの処理をここに記述
        String selectedOption = parent.getItemAtPosition(position).toString();
        if (selectedOption.equals(getString(R.string.default_selection))) {
            // デフォルトの選択肢（空欄）が選択された場合、特別な処理を行わない
            return;
        }


        if (parent.getId() == R.id.department_spinner) {
            // 学部スピナーが選択された場合の処理


            String selectedDepartment = parent.getItemAtPosition(position).toString();


            // 選択された学部に基づいて関連する学科のリソースIDを取得
            int subjectsArrayResourceId = getResources().getIdentifier(
                    "department_" + (position + 1) + "_subjects", "array", getPackageName());


            if (subjectsArrayResourceId != 0) {
                ArrayAdapter<CharSequence> subjectAdapter = ArrayAdapter.createFromResource(this,
                        subjectsArrayResourceId, android.R.layout.simple_spinner_item);
                subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                subjectSpinner.setAdapter(subjectAdapter);


                // 学科スピナーを有効にする
                subjectSpinner.setEnabled(true);
            } else {
                // 学科リソースが見つからない場合は学科スピナーを無効にする
                subjectSpinner.setEnabled(false);
            }


        } else if (parent.getId() == R.id.subject_spinner) {
            // 学科スピナーが選択された場合の処理
            String selectedSubject = parent.getItemAtPosition(position).toString();
            // 選択された学科を表示する例
        } else if (parent.getId() == R.id.grade_spinner) {
            // 学年スピナーが選択された場合の処理
        } else if (parent.getId() == R.id.class_spinner) {
            // クラススピナーが選択された場合の処理
        } else if (parent.getId() == R.id.gender_spinner) {
            // 性別スピナーが選択された場合の処理
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // 何も選択されていない状態の処理をここに記述
    }
}
