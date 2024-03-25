package com.leynnnnnn.skid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondPage extends AppCompatActivity {
    Animation popUp;
    CardView cardView;
    FloatingActionButton nextPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_page);

        popUp = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        cardView = findViewById(R.id.popUpButton);
        cardView.setAnimation(popUp);

        nextPageButton = findViewById(R.id.nextPageButton);
        nextPageButton.setOnClickListener(v -> {
            startActivity(new Intent(SecondPage.this, SignIn.class));
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}