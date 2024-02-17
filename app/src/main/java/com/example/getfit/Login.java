package com.example.getfit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Login extends AppCompatActivity {

    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mCreateButton;
    ProgressBar progressBar;


    FirebaseAuth fAuth;
    boolean passwordVisible;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmail=findViewById(R.id.email);
        mPassword=findViewById(R.id.password);
        mLoginBtn=findViewById(R.id.Login_button);
        mCreateButton=findViewById(R.id.create_text1);
        progressBar=findViewById(R.id.progressbar);

        fAuth=FirebaseAuth.getInstance();

        mPassword.setOnTouchListener((v, motionEvent) -> {
            final int Right=2;
            if(motionEvent.getAction()==MotionEvent.ACTION_UP)
            {
                if(motionEvent.getRawX()>=mPassword.getRight()-mPassword.getCompoundDrawables()[Right].getBounds().width())
                {
                    int selection=mPassword.getSelectionEnd();
                    if(passwordVisible)
                    {
                        mPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_off_24,0 );
                        mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        passwordVisible=false;
                    }
                    else
                    {
                        mPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_24,0 );
                        mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        passwordVisible=true;
                    }

                    mPassword.setSelection(selection);
                    return true;
                }
            }
            return false;
        });
        mCreateButton.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Register.class)));


        mLoginBtn.setOnClickListener(v -> {
            String email=mEmail.getText().toString().trim();
            String password=mPassword.getText().toString().trim();


            if(TextUtils.isEmpty(email))
            {
                mEmail.setError("Email is Required");
                return;
            }

            if(TextUtils.isEmpty(password))
            {
                mPassword.setError("Password is Required");
                return;
            }

            if(password.length()<=6)
            {
                mPassword.setError("Weak Password. Needs at least 6 characters long.");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    Toast.makeText(Login.this,"Welcome",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Unable to Login"+ Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

            });
        });
    }
}