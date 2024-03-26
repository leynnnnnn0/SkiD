package com.leynnnnnn.skid;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VehicleSelection extends AppCompatActivity {
    RecyclerView recyclerView;
    VehicleInfo[] vehicles;
    VehiclesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vehicle_selection);

        recyclerView = findViewById(R.id.vehiclesRecylerView);
        vehicles = new VehicleInfo[] {
             new VehicleInfo(R.drawable.bicycle, "Bicycle Delivery", 60, 16.00),
                new VehicleInfo(R.drawable.motorbike, "Motorbike Delivery", 20, 20.50),
                new VehicleInfo(R.drawable.car, "Car Delivery", 30, 25.00),
                new VehicleInfo(R.drawable.van, "Van Delivery", 40, 30.00),
        };
        adapter = new VehiclesAdapter(this, vehicles);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}