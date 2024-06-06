package com.example.androidlabactivitysaromo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.room.Room;
//
//import com.example.androidlabactivitysaromo.database.AppDatabase;
//import com.example.androidlabactivitysaromo.models.User;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button breakfastButton;
    Button lunchButton;
    Button dinnerButton;
    Button snackButton;
    Button recipesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        TextView welcomeMessage = findViewById(R.id.welcomeMessage);
        textView = findViewById(R.id.textView);
        breakfastButton = findViewById(R.id.breakfastButton);
        lunchButton = findViewById(R.id.lunchButton);
        dinnerButton = findViewById(R.id.dinnerButton);
        snackButton = findViewById(R.id.snackButton);
        recipesButton = findViewById(R.id.button);

        // Set welcome message, this could be dynamically set based on user data
        welcomeMessage.setText(getString(R.string.dashboard));
        textView.setText(getString(R.string.welcome_user));

        // Set onClickListeners for the buttons
        breakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to breakfast planning activity
                Intent intent = new Intent(MainActivity.this, plan_breakfast.class);
                startActivity(intent);
            }
        });

        lunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to lunch planning activity
                Intent intent = new Intent(MainActivity.this, plan_lunch.class);
                startActivity(intent);
            }
        });

        dinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to dinner planning activity
                Intent intent = new Intent(MainActivity.this, plan_dinner.class);
                startActivity(intent);
            }
        });

        snackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to snack planning activity
                Intent intent = new Intent(MainActivity.this, plan_snack.class);
                startActivity(intent);
            }
        });

        recipesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to recipes activity
                Intent intent = new Intent(MainActivity.this, recipes.class);
                startActivity(intent);
            }
        });
    }
}
