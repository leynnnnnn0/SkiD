package com.leynnnnnn.skid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TransactionConfirmation extends AppCompatActivity {
    TextView item, dropOff, pickUp, vehicle, rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transaction_confirmation);

        item = findViewById(R.id.itemTypeConfirmation);
        dropOff = findViewById(R.id.dropOffLocationConfirmation);
        pickUp = findViewById(R.id.pickUpLocationConfirmation);
        vehicle = findViewById(R.id.vehicleTypeConfirmation);
        rate = findViewById(R.id.amountToPay);

        item.setText(getIntent().getStringExtra("orderType"));
        vehicle.setText(getIntent().getStringExtra("vehicleType"));
        pickUp.setText(getIntent().getStringExtra("pickUpLocation"));
        dropOff.setText(getIntent().getStringExtra("dropOffLocation"));
        rate.setText(getIntent().getStringExtra("amount"));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}