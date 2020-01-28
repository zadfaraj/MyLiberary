package com.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class Honari extends AppCompatActivity {

    RecyclerView honariList;
    ArrayList<Items> honariItems;
    RecyclerViewAdapter honariAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honari);

        Objects.requireNonNull(getSupportActionBar()).setTitle("هنری                              ");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.bbb));

        honariList = findViewById(R.id.recycler_view_honari);

        honariItems = new ArrayList<>();
        honariItems.add(new Items("book1", "تاریخ بیهقی", "نویسنده: ابوالفضل محمد بن حسین بیهقی", "مترجم: ---","راوی: دکتر غلامعلی حداد عادل","انتشارات: کتاب گویا"));
        honariItems.add(new Items("book3", "میعاد شبانه", "نویسنده: اردشیر محمودی فر", "مترجم: ---","راوی: امیر جوشقانی","انتشارات: کتاب گویا"));
        honariItems.add(new Items("book5", "کالیگولا", "نویسنده: آلبر کامو", "مترجم: ابوالحسن نجفی","راوی: بهروز رضوی","انتشارات: نیلوفر"));
        honariItems.add(new Items("book7", "چند داستان کوتاه ایرانی", "نویسنده: قیصر امین پور", "مترجم: ---","راوی: ساحل کریمی","انتشارات: کتابناک"));
        honariItems.add(new Items("book9", "داستان زندگی پیامبر", "نویسنده: سید علی موسوی گرمارودی", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        honariItems.add(new Items("book11", "زن زیادی", "نویسنده: جلال آل احمد", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        honariItems.add(new Items("book13", "امام رئوف", "نویسنده: منوچهر آتشی", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        honariItems.add(new Items("book15", "کوثرنامه", "نویسنده: وحیده آزمند", "مترجم: ---","راوی: ---","انتشارات: نخبه"));
        honariItems.add(new Items("book17", "در همسایگی خدا", "نویسنده: حمیدرضا زاهدی", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        honariItems.add(new Items("book19", "از سجاده تا سریر", "نویسنده: غلامرضا کاووسی", "مترجم: ---","راوی: بیوك میرزایی","انتشارات: کتاب گویا"));

        honariAdapter = new RecyclerViewAdapter(this, honariItems);

        honariList.setLayoutManager(new LinearLayoutManager(Honari.this));
        honariList.addItemDecoration(new DividerItemDecoration(Honari.this, DividerItemDecoration.VERTICAL));
        honariList.setAdapter(honariAdapter);
    }
}