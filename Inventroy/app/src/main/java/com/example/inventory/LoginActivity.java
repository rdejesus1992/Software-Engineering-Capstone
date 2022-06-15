/*
 This java file contains the code that manages the log in activity for all users. This code manages
 existing users log ins as well as allowing for new users to create log ins as well.
*/

package com.example.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inventroy.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username, password;
    Button logInButton, signUpButton;

    InventoryDB inventoryDB;

    SessionManager sessionManager;

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            logInButton.setEnabled(!username.getText().toString().trim().isEmpty() && !password.getText().toString().trim().isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        logInButton = findViewById(R.id.logInButton);
        signUpButton = findViewById(R.id.signUpButton);

        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        inventoryDB = new InventoryDB(this);

        sessionManager = new SessionManager(getApplicationContext());
    }

    public void onLogInClick(View v) {
        boolean checkUsername = inventoryDB.checkUsername(username.getText().toString());
        if (!checkUsername) {
            Toast toast = Toast.makeText(getApplicationContext(), "Username is not registered", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            boolean checkPassword;
            checkPassword = inventoryDB.checkPassword(username.getText().toString(), password.getText().toString());
            if (!checkPassword) {
                Toast toast = Toast.makeText(getApplicationContext(), "Incorrect Username/Password", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            } else {
                sessionManager.setLogin(true);
                sessionManager.setUsername(username.getText().toString());
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }
    }

    public void onGoToSignUpClick(View v) {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }
}