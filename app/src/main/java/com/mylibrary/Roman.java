package com.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class Roman extends AppCompatActivity {

    public static final String ID_MESSAGE = "IDMESSAGE";

    ListView romanList;
    ArrayList<Items> romanItems;
    ListViewAdapter romanAdapter;
    String bookId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roman);

        Objects.requireNonNull(getSupportActionBar()).setTitle("رمان                              ");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.bbb));

        romanList = findViewById(R.id.list_view_roman);

        romanItems = new ArrayList<>();
        romanItems.add(new Items("book1", "تاریخ بیهقی", "نویسنده: ابوالفضل محمد بن حسین بیهقی", "مترجم: ---","راوی: دکتر غلامعلی حداد عادل","انتشارات: کتاب گویا"));
        romanItems.add(new Items("book2", "کوروش کبیر", "نویسنده: پیر بریان", "مترجم: تورج دریایی","راوی: ---","انتشارات: انتشارات توس"));
        romanItems.add(new Items("book3", "میعاد شبانه", "نویسنده: اردشیر محمودی فر", "مترجم: ---","راوی: امیر جوشقانی","انتشارات: کتاب گویا"));
        romanItems.add(new Items("book4", "دلیران خلیج فارس", "نویسنده: منوچهر آتشی", "مترجم: ---","راوی: صدرالدین شجره","انتشارات: کتاب گویا"));
        romanItems.add(new Items("book5", "کالیگولا", "نویسنده: آلبر کامو", "مترجم: ابوالحسن نجفی","راوی: بهروز رضوی","انتشارات: نیلوفر"));
        romanItems.add(new Items("book6", "آخرین سفر شاه", "نویسنده: ویلیام شوکراس", "مترجم: عبدالرضا هوشنگ مهدوی","راوی: ---","انتشارات: نشر آسیم"));
        romanItems.add(new Items("book7", "چند داستان کوتاه ایرانی", "نویسنده: قیصر امین پور", "مترجم: ---","راوی: ساحل کریمی","انتشارات: کتابناک"));
        romanItems.add(new Items("book8", "گل آبی عشق", "نویسنده: همایون ایران پور", "مترجم: ---","راوی: عباس توفیقی","انتشارات: کتاب گویا"));
        romanItems.add(new Items("book9", "داستان زندگی پیامبر", "نویسنده: سید علی موسوی گرمارودی", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        romanItems.add(new Items("book10", "لقمان حکیم", "نویسنده: ابوالقاسم غلامی مایانی", "مترجم: ---","راوی: امید زندگانی","انتشارات: هفت گنبد"));
        romanItems.add(new Items("book11", "زن زیادی", "نویسنده: جلال آل احمد", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));

        romanAdapter = new ListViewAdapter(this, romanItems);

        romanList.setAdapter(romanAdapter);

        romanList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent showbook = new Intent(Roman.this, ShowBooks.class);

                bookId = romanItems.get(i).getTitleBook();

                showbook.putExtra(ID_MESSAGE, bookId);

                startActivity(showbook);
            }
        });
    }
}
