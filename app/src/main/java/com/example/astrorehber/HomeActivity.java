package com.example.astrorehber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ZodiacAdapter adapter;
    private DatabaseHelper dbHelper;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dbHelper = new DatabaseHelper(this);
        sessionManager = new SessionManager(this);

        android.widget.TextView tvSelectTitle = findViewById(R.id.tvSelectTitle);
        String userName = sessionManager.getFullName();
        tvSelectTitle.setText("Hoş geldin, " + userName + " ✨");

        // Çıkış Yap Butonu İşlemi
        ImageView btnLogout = findViewById(R.id.btnLogout);
        if(btnLogout != null) {
            btnLogout.setOnClickListener(v -> {
                sessionManager.logoutUser(); // Hafızayı sil
                Toast.makeText(HomeActivity.this, "Oturum kapatıldı.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish(); // Ana sayfayı kapat ki geri tuşuyla dönemesin
            });
        }

        recyclerView = findViewById(R.id.recyclerViewZodiacs);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // EĞER VERİTABANI BOŞSA, 12 BURCU İÇERİ AKTAR
        if (dbHelper.isZodiacTableEmpty()) {
            insertAllZodiacs();
        }

        // Burçları veritabanından çek ve listele
        List<Zodiac> zodiacList = dbHelper.getAllZodiacs();
        adapter = new ZodiacAdapter(zodiacList);
        recyclerView.setAdapter(adapter);
    }

    private void insertAllZodiacs() {
        dbHelper.addZodiac(new Zodiac("Koç", "21 Mar - 19 Nis", R.drawable.koc, R.drawable.koc2,
                "Bugün yönetici gezegenin Mars sana inanılmaz bir cesaret veriyor. Ertelediğin kararları almak için harika bir gün.",
                "Kariyer evinde parlayacağın bir hafta. Özellikle Çarşamba günü alacağın bir mail tüm planlarını olumlu yönde değiştirebilir.",
                "Bu ay tamamen küllerinden doğuyorsun. Hem fiziksel sağlığın hem de zihinsel netliğin zirvede olacak. Aşk hayatında sürprizler yolda.",
                "Ateş", "Mars", "9", "Kırmızı"));

        dbHelper.addZodiac(new Zodiac("Boğa", "20 Nis - 20 May", R.drawable.boga, R.drawable.boga2,
                "Konfor alanından çıkmak istemesen de, bugün karşına çıkacak bir fırsat seni harekete geçmeye zorlayacak. İnatçılığı bırak.",
                "Maddi konuların ön planda olduğu bir hafta. Yatırımlarını gözden geçir ve lüks harcamalardan kaçın.",
                "Venüs'ün etkisiyle bu ay sanatsal ve estetik konulara ilgin artıyor. Kendini şımart, evinde yenilikler yap.",
                "Toprak", "Venüs", "6", "Zümrüt Yeşili"));

        dbHelper.addZodiac(new Zodiac("İkizler", "21 May - 20 Haz", R.drawable.ikizler, R.drawable.ikizler2,
                "Zihnin saatte bin kilometre hızla çalışıyor! Etkili iletişimin sayesinde bir krizin önüne geçeceksin.",
                "Sosyalleşme haftası! Eski dostlarından gelen mesajlar veya spontane buluşmalar modunu çok yükseltecek.",
                "Merkür bu ay sana yeni bir eğitim kapısı aralıyor. Öğrenmek istediğin bir dil veya yazılım varsa tam vakti.",
                "Hava", "Merkür", "5", "Sarı"));

        dbHelper.addZodiac(new Zodiac("Yengeç", "21 Haz - 22 Tem", R.drawable.yengec, R.drawable.yengec2,
                "Sezgilerin bugün alarm veriyor. Karşındaki insanın ne hissettiğini ondan bile önce anlayacaksın.",
                "Ailevi bağların güçlendiği bir hafta. Evinde yapacağın küçük bir değişiklik ruhuna çok iyi gelecek.",
                "Ay'ın hareketleri seni duygusal olarak dalgalandırsa da, ayın sonunda derin bir içsel huzur bulacaksın.",
                "Su", "Ay", "2", "Gümüş Beyazı"));

        dbHelper.addZodiac(new Zodiac("Aslan", "23 Tem - 22 Ağu", R.drawable.aslan, R.drawable.aslan2,
                "Sahne senin! Liderlik vasıflarını ortaya koy. Bugün kimse senin gölgene bile basamaz.",
                "Yaratıcılığın zirvede. İş yerinde veya okulda sunacağın bir fikir büyük alkış toplayacak.",
                "Güneş seni tüm ay boyunca aydınlatıyor. Ancak bu özgüven patlamasında sevdiklerini kırmamaya özen göster.",
                "Ateş", "Güneş", "1", "Altın Sarısı"));

        dbHelper.addZodiac(new Zodiac("Başak", "23 Ağu - 22 Eyl", R.drawable.basak, R.drawable.basak2,
                "Detaylara olan hakimiyetin bugün bir hayat kurtaracak. Mükemmeliyetçilik huyun bugün işe yarıyor.",
                "Rutinlerini yeniden düzenleme zamanı. Sağlıklı beslenme veya yeni bir spor rutini için yıldızlar seni destekliyor.",
                "Analitik zekan bu ay sana maddi kazançlar sağlayacak. İş başvuruları veya projeler için en verimli ayın.",
                "Toprak", "Merkür", "5", "Lacivert"));

        dbHelper.addZodiac(new Zodiac("Terazi", "23 Eyl - 22 Eki", R.drawable.terazi, R.drawable.terazi2,
                "Denge arayışın bugün sonuç veriyor. Kararsızlık huyunu bırakıp net adımlar atma günü.",
                "İkili ilişkilerde romantizmin tavan yaptığı bir hafta. Partnerinle veya yakın bir dostunla sorunları çözeceksiniz.",
                "Venüs seni bu ay sosyalleşmeye itiyor. Katılacağın bir etkinlikte kalbini hızlandıracak biriyle tanışabilirsin.",
                "Hava", "Venüs", "6", "Pembe"));

        dbHelper.addZodiac(new Zodiac("Akrep", "23 Eki - 21 Kas", R.drawable.akrep, R.drawable.akrep2,
                "Küllerinden doğuyorsun. Bugün içsel bir dönüşüm yaşıyor ve toksik bir düşünceyi tamamen zihninden atıyorsun.",
                "Mistik konulara ilgin artabilir. Sezgilerini dinleyerek alacağın bir risk, sana büyük bir kazanç olarak dönecek.",
                "Plüton'un derinliği bu ay seni stratejik yapacak. Maddi konularda çok karlı yatırımlar yapabilirsin.",
                "Su", "Plüton", "8", "Bordo"));

        dbHelper.addZodiac(new Zodiac("Yay", "22 Kas - 21 Ara", R.drawable.yay, R.drawable.yay2,
                "İçindeki macera ateşi yanıyor! Bugün rutin işlerden sıyrılıp yeni bir şeyler keşfetmek isteyeceksin.",
                "Şans gezegeni Jüpiter arkanda. Bu hafta beklediğin hukuki veya eğitimsel bir haber nihayet olumlu sonuçlanacak.",
                "Özgürlüğüne en çok düşkün olduğun aydasın. Hayatı sorgulayacak, yepyeni bir yaşam felsefesi benimseyeceksin.",
                "Ateş", "Jüpiter", "3", "Mor"));

        dbHelper.addZodiac(new Zodiac("Oğlak", "22 Ara - 19 Oca", R.drawable.oglak, R.drawable.oglak2,
                "Disiplin senin göbek adın. Masandaki işleri öyle bir hızla halledeceksin ki, herkes sana hayran kalacak.",
                "Kariyer evinde büyük bir patlama! Yöneticilerin emeklerini nihayet görüyor. Terfi veya prim kapıda.",
                "Satürn'ün zorlayıcı etkileri bu ay meyvesini veriyor. Yorulacaksın ama elde edeceğin başarı buna sonuna kadar değecek.",
                "Toprak", "Satürn", "8", "Koyu Yeşil"));

        dbHelper.addZodiac(new Zodiac("Kova", "20 Oca - 18 Şub", R.drawable.kova, R.drawable.kova2,
                "Orijinal ve asi fikirlerinle bugün kuralları yıkmaya hazırsın. Teknolojik bir sorunu zekanla çözeceksin.",
                "Grup çalışmaları ve ekip projeleri bu haftanın ana teması. Arkadaş grubunla harika bir iş çıkaracaksınız.",
                "Uranüs seni köklü değişimlere itiyor. Taşınma, iş değiştirme veya yeni bir tarz denemek için bu ay çok uygun.",
                "Hava", "Uranüs", "4", "Turkuaz"));

        dbHelper.addZodiac(new Zodiac("Balık", "19 Şub - 20 Mar", R.drawable.balik, R.drawable.balik2,
                "İlham perileri bugün omzunda! Sanatsal yeteneklerini konuşturmak ve hayal kurmak için mükemmel bir gün.",
                "Rüyalarının mesajlarına dikkat et, bilinçaltın sana bu hafta çok önemli şifreler veriyor. Empatin yüksek.",
                "Ruhsal şifalanma ayındasın. Eski yaralarını saracak ve içsel huzuru bulacaksın. Aşkta çok romantik bir dönem.",
                "Su", "Neptün", "7", "Deniz Mavisi"));
    }
}