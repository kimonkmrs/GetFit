package com.example.getfit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Register extends AppCompatActivity {

    EditText mUsername, mEmail, mPassword;
    Button mRegisterBtn;
    ProgressBar progressBar;

    public static final String TAG = "TAG";
    FirebaseFirestore fStore;
    String userID;
    FirebaseAuth fAuth;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUsername = findViewById(R.id.username);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mRegisterBtn = findViewById(R.id.registerBtn);

        progressBar = findViewById(R.id.progressbar);
        RadioGroup radioGroup = findViewById(R.id.register_radiogroup);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();



        /*if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(Register.this, MainActivity.class));
            finish();
        }*/

        mRegisterBtn.setOnClickListener(v -> {
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            String username = mUsername.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                mEmail.setError("Email is Required");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                mPassword.setError("Password is Required");
                return;
            }

            if (password.length() <= 6) {
                mPassword.setError("Weak Password. Needs at least 6 characters long.");
                return;
            }

            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(checkedRadioButtonId);
            String selectedGender = selectedRadioButton.getText().toString();

            progressBar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                progressBar.setVisibility(View.GONE); // Hide the progress bar after task execution
                if (task.isSuccessful()) {
                    FirebaseUser fUser = fAuth.getCurrentUser();
                    if (fUser != null) {
                        fUser.sendEmailVerification().addOnSuccessListener(avoid -> {
                            Toast.makeText(Register.this, "Register Successful", Toast.LENGTH_SHORT).show();
                            userID = fUser.getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("fName", username);
                            user.put("email", email);
                            user.put("gender", selectedGender); // Store the selected gender
                            documentReference.set(user).addOnSuccessListener(unused -> {
                                Log.d(TAG, "onSuccess: User profile created for " + userID);
                                startActivity(new Intent(Register.this, Login.class)); // Go to the login screen after successful registration
                            }).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e));
                        }).addOnFailureListener(e -> Log.d(TAG, "onFailure: Email Not Sent" + e.getMessage()));
                    }
                } else {
                    Toast.makeText(Register.this, "Error " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    public void signup(View view) {
        startActivity(new Intent(Register.this, Login.class));
    }
}
