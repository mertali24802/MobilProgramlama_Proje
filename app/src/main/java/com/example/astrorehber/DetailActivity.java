package com.example.astrorehber;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Geçiş animasyonu
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        // UI Elemanlarını Bağla
        ImageView ivBackButton = findViewById(R.id.ivBackButton);
        ImageView ivDetailHeader = findViewById(R.id.ivDetailHeader);
        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvDate = findViewById(R.id.tvDetailDate);

        TextView tvElement = findViewById(R.id.tvElement);
        TextView tvPlanet = findViewById(R.id.tvPlanet);
        TextView tvNumber = findViewById(R.id.tvNumber);
        TextView tvColor = findViewById(R.id.tvColor);

        TextView tvDailyTitle = findViewById(R.id.tvDailyTitle);
        TextView tvDailyComment = findViewById(R.id.tvDailyComment);
        TextView tvWeeklyComment = findViewById(R.id.tvWeeklyComment);
        TextView tvMonthlyComment = findViewById(R.id.tvMonthlyComment);

        // Geri Butonu İşlemi
        ivBackButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        // Dinamik Tarih Oluşturma (Bugünün tarihi)
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM EEEE", new Locale("tr"));
        String currentDate = sdf.format(new Date());
        tvDailyTitle.setText("🌟 Günlük Analiz (" + currentDate + ")");

        // HomeActivity'deki Adapter'dan gelen dev Zodiac nesnesini al
        Zodiac selectedZodiac = (Zodiac) getIntent().getSerializableExtra("ZODIAC_OBJECT");

        // Nesne boş değilse ekrana bas
        if (selectedZodiac != null) {
            tvName.setText(selectedZodiac.getName() + " Burcu");
            tvDate.setText(selectedZodiac.getDateRange());

            // Kapak resmini bas (örn: koc2.png, boga2.png)
            if(selectedZodiac.getCoverResId() != 0) {
                ivDetailHeader.setImageResource(selectedZodiac.getCoverResId());
            }

            // İstatistikler
            tvElement.setText(selectedZodiac.getElement());
            tvPlanet.setText(selectedZodiac.getPlanet());
            tvNumber.setText(selectedZodiac.getLuckyNumber());
            tvColor.setText(selectedZodiac.getLuckyColor());

            // Yorumlar (Veritabanından gelen uzun yazılar)
            tvDailyComment.setText(selectedZodiac.getDailyComment());
            tvWeeklyComment.setText(selectedZodiac.getWeeklyComment());
            tvMonthlyComment.setText(selectedZodiac.getMonthlyComment());
        }
    }

    // Telefonun kendi fiziksel geri tuşuna basıldığında da animasyon çalışsın
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}