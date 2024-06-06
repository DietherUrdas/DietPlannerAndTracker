package com.example.dietplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.dietplanner.database.AppDatabase;
import com.example.dietplanner.models.User;

public class SignupActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    private EditText ageInput;
    private EditText weightInput;
    private EditText heightInput;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_signup);

        // Initialize the views
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        ageInput = findViewById(R.id.ageInput);
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        signupButton = findViewById(R.id.signupButton);

        // Set onClickListener for the signup button
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String ageText = ageInput.getText().toString().trim();
                String weightText = weightInput.getText().toString().trim();
                String heightText = heightInput.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty() || ageText.isEmpty() || weightText.isEmpty() || heightText.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    int age = Integer.parseInt(ageText);
                    float weight = Float.parseFloat(weightText);
                    float height = Float.parseFloat(heightText);

                    // Save the user data to the database
                    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                            AppDatabase.class, "dietplanner-db").allowMainThreadQueries().build();
                    User user = new User();
                    user.name = username;
                    user.age = age;
                    user.weight = weight;
                    user.height = height;
                    db.userDao().insertUser(user);

                    Toast.makeText(SignupActivity.this, "User registered successfully!", Toast.LENGTH_SHORT).show();

                    // Navigate to login screen or main activity
                    Intent intent = new Intent(SignupActivity.this, log_in.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
