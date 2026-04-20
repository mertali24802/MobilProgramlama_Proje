package com.example.astrorehber;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DatabaseHelper(this); // Veritabanını başlattık

        TextView tvBackToLogin = findViewById(R.id.tvBackToLogin);
        TextInputEditText etBirthDate = findViewById(R.id.etBirthDate);
        // TASARIMINDAN ID'LERİ KENDİNE GÖRE UYARLA
        TextInputEditText etFullName = findViewById(R.id.etName);
        TextInputEditText etEmail = findViewById(R.id.etRegEmail);
        TextInputEditText etPassword = findViewById(R.id.etRegPassword);
        Button btnRegister = findViewById(R.id.btnRegister);

        tvBackToLogin.setOnClickListener(v -> finish());

        // Tarih Seçici (Senin harika kodun)
        etBirthDate.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    RegisterActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        String formattedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        etBirthDate.setText(formattedDate);
                    },
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        // KAYIT OL BUTONU İŞLEMİ
        btnRegister.setOnClickListener(v -> {
            String fullName = etFullName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();
            String date = etBirthDate.getText().toString().trim();

            if (fullName.isEmpty() || email.isEmpty() || pass.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun!", Toast.LENGTH_SHORT).show();
            } else {
                // 1. KONTROL: Bu e-posta daha önce alınmış mı?
                if (dbHelper.checkEmailExists(email)) {
                    Toast.makeText(this, "Bu e-posta adresi zaten kullanılıyor!", Toast.LENGTH_SHORT).show();
                }
                // 2. KONTROL: Bu Ad Soyad daha önce alınmış mı?
                else if (dbHelper.checkNameExists(fullName)) {
                    Toast.makeText(this, "Bu Ad Soyad ile zaten bir kayıt var!", Toast.LENGTH_SHORT).show();
                }
                // HER ŞEY TAMAMSA KAYDET
                else {
                    boolean insert = dbHelper.addUser(fullName, email, pass, date);
                    if (insert) {
                        Toast.makeText(this, "Kayıt Başarılı! Giriş yapabilirsiniz.", Toast.LENGTH_SHORT).show();
                        finish(); // Logine dön
                    } else {
                        Toast.makeText(this, "Kayıt başarısız oldu.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}