package com.leynnnnnn.skid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VehicleSelection extends AppCompatActivity implements VehicleSelectionInterface {
    RecyclerView recyclerView;
    VehicleInfo[] vehicles;
    VehiclesAdapter adapter;
    Button toConfirmation;
    TransactionDetails transactionDetails;
    int index;

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
        adapter = new VehiclesAdapter(this, vehicles, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        transactionDetails = new TransactionDetails(getIntent().getStringExtra("orderType"),
                getIntent().getStringExtra("itemInfo"),
                getIntent().getStringExtra("additionalInfo"),
                getIntent().getStringExtra("pickUpLocation"),
                getIntent().getStringExtra("dropOffLocation"),
                vehicles[index].getVehicleType(),
                vehicles[index].getRate()
                );

        toConfirmation = findViewById(R.id.toConfirmation);
        toConfirmation.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), TransactionConfirmation.class);
            intent.putExtra("orderType", getIntent().getStringExtra("orderType"));
            intent.putExtra("pickUpLocation", getIntent().getStringExtra("pickUpLocation"));
            intent.putExtra("dropOffLocation", getIntent().getStringExtra("dropOffLocation"));
            intent.putExtra("vehicleType", vehicles[index].getVehicleType());
            intent.putExtra("amount", String.valueOf(vehicles[index].getRate()));

            startActivity(intent);


        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemClick(int pos) {
        Toast.makeText(this, vehicles[pos].getVehicleType() + " is selected.", Toast.LENGTH_SHORT).show();
        index = pos;
    }
}