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

public class Location extends AppCompatActivity {
    Button next;
    EditText dropOffLocation, pickUpLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_location);

        dropOffLocation = findViewById(R.id.dropOffLocation);
        pickUpLocation = findViewById(R.id.pickUpLocation);

        next = findViewById(R.id.toVehicleButton);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(Location.this, VehicleSelection.class);
            intent.putExtra("pickUpLocation", pickUpLocation.getText().toString());
            intent.putExtra("dropOffLocation", dropOffLocation.getText().toString());
            intent.putExtra("orderType", getIntent().getStringExtra("orderType"));
            intent.putExtra("itemInfo", getIntent().getStringExtra("itemInfo"));
            intent.putExtra("additionalInfo", getIntent().getStringExtra("additionalInfo"));
            if(dropOffLocation.getText().toString().isEmpty() || pickUpLocation.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please input the information needed.", Toast.LENGTH_SHORT).show();
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