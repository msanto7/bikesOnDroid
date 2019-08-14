package com.example.bikesondroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // private variables corresponding to controls on the UI
    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int cnt = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        info = (TextView)findViewById((R.id.info));
        login = (Button) findViewById(R.id.btn_login);

        // set text to show user num attempts initially
        info.setText("# of attempts remaining: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });

    }

    // validate function
    private void validate(String uName, String uPassword) {
        if((uName.equals("root")) && (uPassword.equals("password"))) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        } else {
            // incorrect username or password
            cnt--;

            info.setText("# of attempts remaining: " + String.valueOf(cnt));

            // check counter to see if the user has entered invalid credentials psat the limit
            if(cnt == 0) {
                // disable the button when out of attempts
                login.setEnabled(false);
            }
        }
    }
}
