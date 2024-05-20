package com.example.tazabilim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private Button signUpButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        signInButton = findViewById(R.id.sign_in_btn);
        signUpButton = findViewById(R.id.sign_up_btn);
        databaseHelper = new DatabaseHelper(this); // Инициализация DatabaseHelper

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                if (!username.isEmpty() && !password.isEmpty()) {
                    registerUser(username, password);
                } else {
                    Toast.makeText(MainActivity.this, "Username or password cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                if (!username.isEmpty() && !password.isEmpty()) {
                    loginUser(username, password);
                } else {
                    Toast.makeText(MainActivity.this, "Username or password cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registerUser(String username, String password) {
        databaseHelper.addUser(username, password);
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
    }

    private void loginUser(String username, String password) {
        if (databaseHelper.checkUser(username, password)) {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
