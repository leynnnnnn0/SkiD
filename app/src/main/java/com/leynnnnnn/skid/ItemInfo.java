package com.leynnnnnn.skid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ItemInfo extends AppCompatActivity {
    Button next;
    EditText itemInfo, additionalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_info);

        itemInfo = findViewById(R.id.itemInfo);
        additionalInfo = findViewById(R.id.additionalInfo);

        next = findViewById(R.id.toLocationButton);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(ItemInfo.this, Location.class);
            intent.putExtra("itemInfo", itemInfo.getText().toString());
            intent.putExtra("additionalInfo", itemInfo.getText().toString());
            intent.putExtra("orderType", getIntent().getStringExtra("orderType"));

            if(itemInfo.getText().toString().isEmpty()) {
                Toast.makeText(this, "Pleas fill up the information needed.", Toast.LENGTH_SHORT).show();
            }else {
                startActivity(intent);
            }


        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}