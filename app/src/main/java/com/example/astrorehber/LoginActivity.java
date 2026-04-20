package com.example.astrorehber;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private SessionManager sessionManager; // Oturum yöneticimiz

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = new SessionManager(this);

        // EĞER ZATEN GİRİŞ YAPILMIŞSA DİREKT ANA SAYFAYA AT!
        if (sessionManager.isLoggedIn()) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
            return; // Login ekranını çizmekle uğraşma
        }

        setContentView(R.layout.activity_login);
        dbHelper = new DatabaseHelper(this);

        findViewById(R.id.loginCard).startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up));

        // DİKKAT: XML'deki ID'n etLoginEmail (Büyük L) ise burayı da öyle yapmalısın.
        // Senin kodunda etloginEmail (küçük l) kalmış, XML'inle aynı olduğundan emin ol.
        TextInputEditText etLoginEmail = findViewById(R.id.etloginEmail);
        TextInputEditText etLoginPassword = findViewById(R.id.etLoginPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String email = etLoginEmail.getText().toString().trim();
            String pass = etLoginPassword.getText().toString().trim();

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "E-posta ve şifre boş olamaz!", Toast.LENGTH_SHORT).show();
            } else {
                if (dbHelper.checkUser(email, pass)) {

                    // 1. YENİ KISIM: Veritabanından giriş yapan kişinin adını soyadını çek
                    String fullName = dbHelper.getUserFullName(email);

                    // 2. YENİ KISIM: Oturumu sadece e-posta ile değil, İSİM ile de kaydet!
                    sessionManager.createLoginSession(email, fullName);

                    // 3. YENİ KISIM: Toast mesajında ismini göstererek havalı bir giriş yap
                    Toast.makeText(this, "Yıldızlara Bağlanıldı, " + fullName + "!", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                } else {
                    Toast.makeText(this, "Hatalı e-posta veya şifre!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.tvRegister).setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        });
    }
}