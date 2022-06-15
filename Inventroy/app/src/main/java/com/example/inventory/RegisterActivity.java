//This java file holds the code that allows for a user to register a log in for a new user.

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

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText username, password, rePassword;
    Button signUpButton;

    InventoryDB inventoryDB;

    SessionManager sessionManager;

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            signUpButton.setEnabled(!Objects.requireNonNull(username.getText()).toString().trim().isEmpty() &&
                    !Objects.requireNonNull(password.getText()).toString().trim().isEmpty() &&
                    !Objects.requireNonNull(rePassword.getText()).toString().trim().isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        rePassword = findViewById(R.id.rePassword);
        signUpButton = findViewById(R.id.signUpButton);

        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        rePassword.addTextChangedListener(textWatcher);

        inventoryDB = new InventoryDB(this);

        sessionManager = new SessionManager(getApplicationContext());

    }

    public void onSignUpClick(View v) {
        boolean checkUsername = inventoryDB.checkUsername(Objects.requireNonNull(username.getText()).toString());
        if (checkUsername) {
            Toast toast = Toast.makeText(getApplicationContext(), "Username is already registered", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            if (Objects.requireNonNull(password.getText()).toString().equals(Objects.requireNonNull(rePassword.getText()).toString())) {
                boolean addUser = inventoryDB.addUser(username.getText().toString(), password.getText().toString());
                if (addUser) {
                    Toast toast = Toast.makeText(getApplicationContext(), "User registered successfully", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                sessionManager.setLogin(true);
                sessionManager.setUsername(username.getText().toString());
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Passwords must match", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }
    }

    public void onGoToLogInClick(View v) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}