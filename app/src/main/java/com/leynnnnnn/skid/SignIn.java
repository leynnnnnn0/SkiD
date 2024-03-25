package com.leynnnnnn.skid;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class SignIn extends AppCompatActivity {
    DBHelper myDB = new DBHelper(this);
    ArrayList<AccountInfo> users = new ArrayList<>();
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        Button createAnAccountButton = findViewById(R.id.createAnAccountButton);
        createAnAccountButton.setOnClickListener(v -> startActivity(new Intent(SignIn.this, SignUp.class)));

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        Button signInButton = findViewById(R.id.signInButton);
        signInButton.setOnClickListener(v-> {
            Cursor cursor = myDB.doesExist(username.getText().toString());
            if(cursor != null && cursor.moveToFirst()) {
                Toast.makeText(this, "success!!!!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "no user found", Toast.LENGTH_SHORT).show();
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void verifyDetails() {
        Cursor cursor = myDB.getUsers();
        if (cursor != null) {
            while(cursor.moveToNext()) {
                users.add(new AccountInfo(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            }
        }

    }
}