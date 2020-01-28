package com.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class Hame extends Fragment {

    RecyclerView hameList;
    ArrayList<Items> hameItems;
    RecyclerViewAdapter hameAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hame, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hameList = Objects.requireNonNull(getView()).findViewById(R.id.recycler_view_hame);

        hameItems = new ArrayList<>();
        hameItems.add(new Items("book1", "تاریخ بیهقی", "نویسنده: ابوالفضل محمد بن حسین بیهقی", "مترجم: ---","راوی: دکتر غلامعلی حداد عادل","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book2", "کوروش کبیر", "نویسنده: پیر بریان", "مترجم: تورج دریایی","راوی: ---","انتشارات: انتشارات توس"));
        hameItems.add(new Items("book3", "میعاد شبانه", "نویسنده: اردشیر محمودی فر", "مترجم: ---","راوی: امیر جوشقانی","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book4", "دلیران خلیج فارس", "نویسنده: منوچهر آتشی", "مترجم: ---","راوی: صدرالدین شجره","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book5", "کالیگولا", "نویسنده: آلبر کامو", "مترجم: ابوالحسن نجفی","راوی: بهروز رضوی","انتشارات: نیلوفر"));
        hameItems.add(new Items("book6", "آخرین سفر شاه", "نویسنده: ویلیام شوکراس", "مترجم: عبدالرضا هوشنگ مهدوی","راوی: ---","انتشارات: نشر آسیم"));
        hameItems.add(new Items("book7", "چند داستان کوتاه ایرانی", "نویسنده: قیصر امین پور", "مترجم: ---","راوی: ساحل کریمی","انتشارات: کتابناک"));
        hameItems.add(new Items("book8", "گل آبی عشق", "نویسنده: همایون ایران پور", "مترجم: ---","راوی: عباس توفیقی","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book9", "داستان زندگی پیامبر", "نویسنده: سید علی موسوی گرمارودی", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book10", "لقمان حکیم", "نویسنده: ابوالقاسم غلامی مایانی", "مترجم: ---","راوی: امید زندگانی","انتشارات: هفت گنبد"));
        hameItems.add(new Items("book11", "زن زیادی", "نویسنده: جلال آل احمد", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book12", "آرش کمانگیر", "نویسنده: فردوسی", "مترجم: ---","راوی: ---","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book13", "امام رئوف", "نویسنده: منوچهر آتشی", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book14", "راز تولد", "نویسنده: یوستین گُردر", "مترجم: ---","راوی: امید زندگانی","انتشارات: هفت گنبد"));
        hameItems.add(new Items("book15", "کوثرنامه", "نویسنده: وحیده آزمند", "مترجم: ---","راوی: ---","انتشارات: نخبه"));
        hameItems.add(new Items("book16", "سلیمان در وادی مورچگان", "نویسنده: مرضیه رشیدبیگی", "مترجم: ---","راوی: امیر زنده دلان","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book17", "در همسایگی خدا", "نویسنده: حمیدرضا زاهدی", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book18", "بلال بلال", "نویسنده: اچ ای کریگ", "مترجم: عبدالرضا هوشنگ مهدوی","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        hameItems.add(new Items("book19", "از سجاده تا سریر", "نویسنده: غلامرضا کاووسی", "مترجم: ---","راوی: بیوك میرزایی","انتشارات: کتاب گویا"));

        hameAdapter = new RecyclerViewAdapter(getContext(), hameItems);

        hameList.setLayoutManager(new LinearLayoutManager(getContext()));
        hameList.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL));
        hameList.setAdapter(hameAdapter);
    }
}
