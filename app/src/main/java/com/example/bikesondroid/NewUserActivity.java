package com.example.bikesondroid;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewUserActivity extends AppCompatActivity {


    //grab UI controls
    private EditText name;
    private EditText email;
    private EditText password;
    private Button signupButton;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        setupViews();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()) {
                    // we are good...register user and write to database
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewUserActivity.this, HomeActivity.class));
            }
        });

    }

    private void setupViews() {
        name = (EditText)findViewById(R.id.editUsername);
        email = (EditText)findViewById(R.id.editEmail);
        password = (EditText)findViewById(R.id.password);
        signupButton = (Button)findViewById(R.id.buttonRegister);
        login = (TextView)findViewById(R.id.alreadySignedUp);
    }

    private Boolean validate() {
        Boolean valid = false;
        String uName = name.getText().toString();
        String uPassword = password.getText().toString();
        String uEmail = email.getText().toString();

        if(uName.isEmpty() && uPassword.isEmpty() && uEmail.isEmpty()) {
            Toast.makeText(this, "Information Missing.", Toast.LENGTH_SHORT);
        } else {
            valid = true;
        }

        return valid;
    }
}
