package fpt.phamvannho.lab1_md19304;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        Button loginWithEmail = findViewById(R.id.loginWithEmail);
        Button loginWithPhone = findViewById(R.id.loginWithPhone);

        loginWithEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến Activity đăng ký Email
                startActivity(new Intent(MainActivity.this, EmailRegistrationActivity.class));
            }
        });

        loginWithPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến Activity đăng ký Số điện thoại
                startActivity(new Intent(MainActivity.this, PhoneRegistrationActivity.class));
            }
        });
    }
}