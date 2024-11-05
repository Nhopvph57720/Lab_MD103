package fpt.phamvannho.lab1_md19304;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneRegistrationActivity extends AppCompatActivity {

    private EditText phoneField;
    private Button sendCodeButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_registration);

        mAuth = FirebaseAuth.getInstance();
        phoneField = findViewById(R.id.phoneField);
        sendCodeButton = findViewById(R.id.sendCodeButton);

        sendCodeButton.setOnClickListener(v -> {
            String phone = phoneField.getText().toString();
            // Gửi mã xác thực
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    PhoneAuthOptions.newBuilder(mAuth)
                            .setPhoneNumber(phone)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(this)
                            .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
                                    // Đăng nhập thành công
                                    mAuth.signInWithCredential(credential)
                                            .addOnCompleteListener(PhoneRegistrationActivity.this, task -> {
                                                if (task.isSuccessful()) {
                                                    startActivity(new Intent(PhoneRegistrationActivity.this, HomeActivity.class));
                                                } else {
                                                    Toast.makeText(PhoneRegistrationActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                    Toast.makeText(PhoneRegistrationActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .build());
        });
    }
}