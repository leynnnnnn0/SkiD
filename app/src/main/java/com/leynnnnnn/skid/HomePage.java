package com.leynnnnnn.skid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomePage extends AppCompatActivity implements HomePageInterface {
    HomePageGridItem[] items;
    RecyclerView recyclerView;
    HomePageAdapter adapater;
    TextView usernameField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        Intent intent = getIntent();
        items = new HomePageGridItem[] {
                new HomePageGridItem(R.drawable.food, "Food", "Less than 5kg"),
                new HomePageGridItem(R.drawable.parcel, "Parcel", "Less than 10kg"),
                new HomePageGridItem(R.drawable.grocery, "Groceries", "Less than 15kg")
        };
        usernameField = findViewById(R.id.usernameField);
        usernameField.setText(intent.getStringExtra("use"));
        recyclerView = findViewById(R.id.homeRecyclerView);
        adapater = new HomePageAdapter(this, items, this);
        recyclerView.setAdapter(adapater);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, ItemInfo.class);
        intent.putExtra("orderType", items[position].getType());
        Toast.makeText(this, items[position].getType() + " selected.", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }
}