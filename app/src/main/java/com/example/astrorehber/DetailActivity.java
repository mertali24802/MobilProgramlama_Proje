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
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

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

        ivBackButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM EEEE", new Locale("tr"));
        String currentDate = sdf.format(new Date());
        tvDailyTitle.setText("🌟 Günlük Analiz (" + currentDate + ")");

        Zodiac selectedZodiac = (Zodiac) getIntent().getSerializableExtra("ZODIAC_OBJECT");

        if (selectedZodiac != null) {
            tvName.setText(selectedZodiac.getName() + " Burcu");
            tvDate.setText(selectedZodiac.getDateRange());

            if(selectedZodiac.getCoverResId() != 0) {
                ivDetailHeader.setImageResource(selectedZodiac.getCoverResId());
            }

            tvElement.setText(selectedZodiac.getElement());
            tvPlanet.setText(selectedZodiac.getPlanet());
            tvNumber.setText(selectedZodiac.getLuckyNumber());
            tvColor.setText(selectedZodiac.getLuckyColor());

            tvDailyComment.setText(selectedZodiac.getDailyComment());
            tvWeeklyComment.setText(selectedZodiac.getWeeklyComment());
            tvMonthlyComment.setText(selectedZodiac.getMonthlyComment());
        }
    }
}