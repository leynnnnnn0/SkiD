package com.leynnnnnn.skid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {
    DBHelper myDB = new DBHelper(this);
    EditText usernameInput, emailInput, passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        usernameInput = findViewById(R.id.usernameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);

        Button createAnAccount = findViewById(R.id.addNewAccount);
        createAnAccount.setOnClickListener(v -> {
            Boolean res = addNewUser(usernameInput.getText().toString(), emailInput.getText().toString(), passwordInput.getText().toString());
            if (res) {
                Toast.makeText(SignUp.this, "Account Created.", Toast.LENGTH_SHORT).show();
                Log.d("Success", myDB.getUsers().toString());
            }else {
                Toast.makeText(SignUp.this, "Incomplete Details.", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private Boolean addNewUser(String username, String email, String password) {
        if (username != null && email != null && password != null) {
            return myDB.addUser(username, email, password);
        } else {
            return false;
        }
    }
}