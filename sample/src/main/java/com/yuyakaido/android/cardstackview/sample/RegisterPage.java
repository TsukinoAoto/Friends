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

public class RegisterPage extends AppCompatActivity {

    TextInputEditText editTextEmail,editTextPassword;
    Button signUp;
    TextView signIn;
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        editTextEmail=findViewById(R.id.email);
        editTextPassword=findViewById(R.id.password);
        signIn=findViewById(R.id.sign_in);
        signUp=findViewById(R.id.sign_up);

        signIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(RegisterPage.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email,password;
                email=String.valueOf(editTextEmail.getText());
                password=String.valueOf(editTextPassword.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterPage.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterPage.this,"Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task){
                                if(task.isSuccessful()){
                                    Toast.makeText(RegisterPage.this,"Registration Successfully",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(RegisterPage.this,LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    showToast("Gmailとパスワードは既に登録してあります");
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