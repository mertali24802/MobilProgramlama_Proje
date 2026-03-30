package com.example.astrorehber;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ZodiacAdapter adapter;
    private List<Zodiac> zodiacList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerViewZodiacs);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        zodiacList = new ArrayList<>();


        zodiacList.add(new Zodiac(
                "Koç", "21 Mar - 19 Nis", R.drawable.koc, R.drawable.koc2,
                "Gezegenlerin bugünkü dizilimi, içindeki savaşçı ruhu ön plana çıkarıyor! Kariyerinde veya okulunda uzun süredir ertelediğin o büyük adımı atmak için gökyüzü sana tam destek veriyor. Akşam saatlerinde enerjini spora yönlendirmek iyi gelebilir.",
                "Bu hafta maddi konularda beklenmedik sürprizlere açık ol. Haftanın ortasında alacağın bir haber, tüm planlarını değiştirebilir. Enerjini doğru yönetirsen haftayı büyük bir zaferle kapatacaksın.",
                "Bu ay tamamen yenilenme ve küllerinden doğma ayı! Mars'ın etkisiyle hem fiziksel hem zihinsel olarak zirvede hissedeceksin. Özellikle ayın 15'inden sonra aşk hayatında romantik rüzgarlar esmeye başlıyor.",
                "Ateş", "Mars", "9", "Kırmızı"
        ));

        zodiacList.add(new Zodiac(
                "Boğa", "20 Nis - 20 May", R.drawable.boga, R.drawable.boga2,
                "Bugün konfor alanından çıkmak istemeyebilirsin ve bunda tamamen haklısın. Kendine vakit ayır, sevdiğin bir kahveyi iç ve zihnini dinlendir. Akşama doğru yakın bir dostunla yapacağın derin sohbet sana çok iyi gelecek.",
                "Venüs'ün konumu bu hafta seni adeta bir mıknatıs gibi çekici yapıyor. Çevrendeki insanların ilgisi sürekli senin üzerinde olacak. İş hayatında sabrının meyvelerini toplamaya başlayacağın verimli bir hafta.",
                "Finansal anlamda altın çağını yaşamaya hazır mısın? Bu ay, geçmişte ektiğin tohumların hasadını yapacaksın. Ancak inatçı tavırlarından biraz ödün vermen, ikili ilişkilerde işleri senin için çok daha kolaylaştıracak.",
                "Toprak", "Venüs", "6", "Zümrüt Yeşili"
        ));

        zodiacList.add(new Zodiac(
                "İkizler", "21 May - 20 Haz", R.drawable.ikizler, R.drawable.ikizler2,
                "Zihninin bugün saatte bin kilometre hızla çalıştığını hissedebilirsin! Yeni fikirler üretmek ve iletişim kurmak için harika bir gün. Ancak aynı anda çok fazla işe odaklanıp enerjini bölmemeye dikkat et.",
                "Bu hafta sosyallik tavan yapıyor. Eski arkadaşlarından alacağın mesajlar veya sürpriz davetler haftanı renklendirecek. Perşembe günü karşına çıkacak yeni bir fırsatı değerlendirmeden önce iki kez düşün.",
                "Merkür'ün hareketleri bu ay sana yeni bir eğitim veya seyahat kapısı aralayabilir. Kendini geliştirmek istediğin o konuya başlamanın tam vakti. Aşk hayatında ise yüzeysel tartışmalardan uzak durmalısın.",
                "Hava", "Merkür", "5", "Sarı"
        ));

        zodiacList.add(new Zodiac(
                "Yengeç", "21 Haz - 22 Tem", R.drawable.yengec, R.drawable.yengec2,
                "Bugün duygusal antenlerin çok açık. Çevrendeki insanların ne hissettiğini onlardan bile önce anlayabilirsin. Empati yeteneğin sayesinde bir arkadaşının büyük bir sorununu çözeceksin.",
                "Ailevi konuların ve ev yaşantısının ön planda olduğu bir hafta. Evinde yapacağın ufak bir dekorasyon değişikliği veya temizlik, ruhunu inanılmaz derecede arındıracak. Cuma günü harcamalarına dikkat et.",
                "Ay'ın fazları duygusal dünyanda medcezirler yaratsa da, bu ay içsel huzuru bulacağın o özel döneme giriyorsun. Sezgilerine güvenerek aldığın kararların ne kadar doğru olduğunu ay sonuna doğru net bir şekilde göreceksin.",
                "Su", "Ay", "2", "Gümüş/Beyaz"
        ));

        zodiacList.add(new Zodiac(
                "Aslan", "23 Tem - 22 Ağu", R.drawable.aslan, R.drawable.aslan2,
                "Sahne senin! Bugün girdiğin her ortamda dikkatleri üzerine çekmeyi başaracaksın. Özgüvenin sayesinde liderlik vasıflarını gösterebileceğin bir durumla karşılaşabilirsin. Parlamaktan çekinme.",
                "Yaratıcılığının zirvesinde olduğun bir hafta. İster bir proje, ister bir sanat eseri olsun; elini attığın her şeyi güzelleştireceksin. Hafta sonu romantik bir sürprize hazırlıklı ol.",
                "Güneş'in enerjisi tüm ay boyunca sana canlılık verecek. Kariyerinde büyük bir sıçrama yaşama ihtimalin çok yüksek. Ancak bu başarı sarhoşluğu içinde, sana her zaman destek olan insanları ihmal etmemelisin.",
                "Ateş", "Güneş", "1", "Altın/Turuncu"
        ));

        zodiacList.add(new Zodiac(
                "Başak", "23 Ağu - 22 Eyl", R.drawable.basak, R.drawable.basak2,
                "Detayların gücü bugün senin elinde. Başkalarının gözden kaçırdığı o ufak tefek şeyleri fark edip büyük bir krizi önleyebilirsin. Sadece kendine ve çevrendekilere karşı fazla eleştirel olmamaya çalış.",
                "Rutinlerini yeniden düzenlemek ve sağlığına odaklanmak için mükemmel bir hafta. Spora başlamak veya diyetini gözden geçirmek istiyorsan yıldızlar seni destekliyor. İş yerinde takdir edileceksin.",
                "Analitik zekanın sana büyük paralar veya başarılar kazandırabileceği bir ay. Planlı ve programlı ilerlediğin sürece önünde hiçbir engel duramaz. Ayın 20'sinden sonra eski bir borç veya alacak gündeme gelebilir.",
                "Toprak", "Merkür", "5", "Lacivert"
        ));

        zodiacList.add(new Zodiac(
                "Terazi", "23 Eyl - 22 Eki", R.drawable.terazi, R.drawable.terazi2,
                "Uyum ve denge arayışın bugün sonuç veriyor. Etrafındaki çatışmaları tatlı dilinle çözecek ve aranılan arabulucu olacaksın. Estetik konulara ilgin artabilir, kendine küçük bir hediye al.",
                "İkili ilişkiler ve ortaklıklar haftanın ana teması. Sevdiğin kişiyle veya iş ortağınla ortak kararlar almak için harika günlerden geçiyorsun. Kararsızlık huyunu bir kenara bırakıp net adımlar atma zamanı.",
                "Aşk gezegeni Venüs, bu ay seni romantizmin doruklarına çıkaracak. Yalnızsan, katılacağın bir etkinlikte kalbini hızla çarptıracak biriyle tanışabilirsin. İlişkin varsa, bir sonraki ciddiyet aşamasına geçilebilir.",
                "Hava", "Venüs", "6", "Açık Pembe"
        ));

        zodiacList.add(new Zodiac(
                "Akrep", "23 Eki - 21 Kas", R.drawable.akrep, R.drawable.akrep2,
                "Bugün hislerin o kadar kuvvetli ki adeta insanların zihnini okuyorsun. Karşına çıkan fırsatların arka planını rahatça görebilirsin. Sezgilerine güven, onlar seni asla yanıltmaz.",
                "Küllerinden doğma haftası! Bitişler ve yeni başlangıçlar bir arada. Artık sana hizmet etmeyen alışkanlıkları veya toksik ilişkileri hayatından çıkarmak için gereken cesareti kendinde bulacaksın.",
                "Derin tutkular ve finansal stratejiler bu ayına damga vuracak. Miras, kredi veya ortaklıklardan gelecek paralarla ilgili pozitif gelişmeler yaşanabilir. Gizemli tavrın çevrendekileri sana daha çok çekecek.",
                "Su", "Plüton", "8", "Bordo/Siyah"
        ));

        zodiacList.add(new Zodiac(
                "Yay", "22 Kas - 21 Ara", R.drawable.yay, R.drawable.yay2,
                "İçindeki keşfetme arzusu bugün sınır tanımıyor! Rutin işler bugün seni fazlasıyla sıkabilir. Yeni bir şeyler öğrenmek, ufak bir kaçamak yapmak veya farklı kültürlerden insanlarla konuşmak isteyebilirsin.",
                "İyimserliğinin sana kapılar açtığı bir hafta. Şans gezegeni Jüpiter arkanda! Özellikle eğitim, yurt dışı bağlantılı işler veya hukuki konularda beklediğin olumlu sonuçları alacaksın.",
                "Bu ay felsefi düşüncelere dalıp hayatın anlamını sorgulayabilirsin. Büyük resmi görme yeteneğin sayesinde hayatındaki hedefleri güncelleyeceksin. Özgürlüğünden ödün vermeden yaşayacağın macera dolu bir ay.",
                "Ateş", "Jüpiter", "3", "Mor"
        ));

        zodiacList.add(new Zodiac(
                "Oğlak", "22 Ara - 19 Oca", R.drawable.oglak, R.drawable.oglak2,
                "Disiplin ve sorumluluk bugün senin göbek adın. Masandaki işleri büyük bir soğukkanlılıkla ve sırasıyla halledeceksin. Sadece biraz mola vermeyi ve omzundaki yükleri hafifletmeyi unutma.",
                "Kariyer evinde parladığın bir hafta! Yöneticilerin veya hocaların azmini ve çalışma disiplinini fark edecek. Uzun süredir hak ettiğin o terfi veya onayı almak için mükemmel zamanlama.",
                "Satürn'ün çocukları olarak emek vermeden hiçbir şeyin elde edilmeyeceğini çok iyi biliyorsun. Bu ay ektiğin tohumlar yeşerecek. İş hayatındaki bu yoğunluğu, ailenle geçireceğin kaliteli zamanla dengelemelisin.",
                "Toprak", "Satürn", "8", "Koyu Yeşil"
        ));

        zodiacList.add(new Zodiac(
                "Kova", "20 Oca - 18 Şub", R.drawable.kova, R.drawable.kova2,
                "Orijinal fikirlerinle bugün herkesi şaşırtmaya hazırsın. Sorunlara getirdiğin alışılmışın dışındaki çözümler büyük takdir toplayacak. Teknolojik aletlerle ilgili bir alışveriş gündeminde olabilir.",
                "Sosyal çevrenin genişlediği, yeni gruplara ve topluluklara dahil olacağın bir hafta. Birlikte hareket etmek ve ekip çalışmaları sana büyük bir vizyon katacak. İdealist fikirlerini paylaşmaktan çekinme.",
                "Uranüs'ün isyankar ruhu bu ay seni büyük bir değişime zorluyor. Hayatında aniden yön değiştirmek, yeni bir şehre taşınmak veya radikal bir karar almak isteyebilirsin. Geleceğe yönelik umutların yeşeriyor.",
                "Hava", "Uranüs", "4", "Elektrik Mavisi"
        ));

        zodiacList.add(new Zodiac(
                "Balık", "19 Şub - 20 Mar", R.drawable.balik, R.drawable.balik2,
                "Bugün hayal dünyan oldukça renkli ve ilham dolusun. Sanatsal yeteneklerini konuşturmak, müzik dinlemek veya yazı yazmak için harika bir gün. İç sesin sana ne yapman gerektiğini fısıldıyor.",
                "Şefkatinin ve merhametinin ön plana çıktığı bir hafta. Yardıma ihtiyacı olan birine uzatacağın el, evren tarafından sana katlanarak geri dönecek. Rüyalarının mesajlarına bu hafta ekstra dikkat et.",
                "Bilinçaltının derinliklerine inip ruhsal olarak şifalanacağın bir ay. Meditasyon yapmak, su kenarında vakit geçirmek enerjini tazeleyecek. Aşk hayatında ise tamamen ruh eşi bağlantıları arayışındasın.",
                "Su", "Neptün", "7", "Deniz Mavisi"
        ));

        // Adapter'ı bağla
        adapter = new ZodiacAdapter(zodiacList);
        recyclerView.setAdapter(adapter);
    }
}