package com.yuyakaido.android.cardstackview.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.yuyakaido.android.cardstackview.sample.R;
import com.yuyakaido.android.cardstackview.sample.RegisterPage;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText editTextEmail,editTextPassword;
    Button signIn;
    TextView signUp;
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail=findViewById(R.id.email);
        editTextPassword=findViewById(R.id.password);
        signIn=findViewById(R.id.sign_in);
        signUp=findViewById(R.id.sign_up);

        signUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(LoginActivity.this, RegisterPage.class);
                startActivity(intent);
                finish();
            }
        });

        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Firebase Authenticationで認証されたユーザーのGmailを取得
                                    String authenticatedEmail = firebaseAuth.getCurrentUser().getEmail();
                                    String gmail0 = firebaseAuth.getCurrentUser().getEmail().replace("@g.tohoku-gakuin.ac.jp", "");
                                    String gmail=gmail0.replace("s","");
                                    Intent intent = new Intent(LoginActivity.this, SettingActivity.class);
                                    intent.putExtra("gmail",gmail);


                                    // 取得したGmailをFirebase Realtime Databaseに保存
                                    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Gmail");
                                    databaseRef.child(gmail).setValue(authenticatedEmail);
                                    databaseRef.child(gmail).setValue(gmail)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> saveTask) {
                                                    if (saveTask.isSuccessful()) {
                                                        Intent intent = new Intent(LoginActivity.this, SubActivity.class);
                                                        intent.putExtra("gmail",gmail);
                                                        startActivity(intent);
                                                        finish();
                                                    } else {
                                                        showToast("Gmailの保存に失敗しました");
                                                    }
                                                }
                                            });
                                } else {
                                    showToast("Gmailまたはパスワードが違います");
                                }
                            }
                        });
            }
        });

    }

    private void showToast(String message) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View customToastView = layoutInflater.inflate(R.layout.toast_layout, null);

        // TextViewのテキストを変更する
        ((TextView) customToastView.findViewById(R.id.msg)).setText(message);

        Toast toast = new Toast(customToastView.getContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(customToastView);
        toast.show();
    }
}