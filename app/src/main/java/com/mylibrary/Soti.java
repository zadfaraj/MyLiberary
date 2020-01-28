package com.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class Soti extends Fragment {

    public static final String ID_MESSAGE = "IDMESSAGE";

    ListView sotiList;
    ArrayList<Items> sotiItems;
    ListViewAdapter sotiAdapter;
    String bookId;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_soti, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sotiList = Objects.requireNonNull(getView()).findViewById(R.id.list_view_soti);

        sotiItems = new ArrayList<>();
        sotiItems.add(new Items("book1", "تاریخ بیهقی", "نویسنده: ابوالفضل محمد بن حسین بیهقی", "مترجم: ---","راوی: دکتر غلامعلی حداد عادل","انتشارات: کتاب گویا"));
        sotiItems.add(new Items("book3", "میعاد شبانه", "نویسنده: اردشیر محمودی فر", "مترجم: ---","راوی: امیر جوشقانی","انتشارات: کتاب گویا"));
        sotiItems.add(new Items("book4", "دلیران خلیج فارس", "نویسنده: منوچهر آتشی", "مترجم: ---","راوی: صدرالدین شجره","انتشارات: کتاب گویا"));
        sotiItems.add(new Items("book5", "کالیگولا", "نویسنده: آلبر کامو", "مترجم: ابوالحسن نجفی","راوی: بهروز رضوی","انتشارات: نیلوفر"));
        sotiItems.add(new Items("book7", "چند داستان کوتاه ایرانی", "نویسنده: قیصر امین پور", "مترجم: ---","راوی: ساحل کریمی","انتشارات: کتابناک"));
        sotiItems.add(new Items("book8", "گل آبی عشق", "نویسنده: همایون ایران پور", "مترجم: ---","راوی: عباس توفیقی","انتشارات: کتاب گویا"));
        sotiItems.add(new Items("book9", "داستان زندگی پیامبر", "نویسنده: سید علی موسوی گرمارودی", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        sotiItems.add(new Items("book10", "لقمان حکیم", "نویسنده: ابوالقاسم غلامی مایانی", "مترجم: ---","راوی: امید زندگانی","انتشارات: هفت گنبد"));
        sotiItems.add(new Items("book11", "زن زیادی", "نویسنده: جلال آل احمد", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        sotiItems.add(new Items("book13", "امام رئوف", "نویسنده: منوچهر آتشی", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        sotiItems.add(new Items("book14", "راز تولد", "نویسنده: یوستین گُردر", "مترجم: ---","راوی: امید زندگانی","انتشارات: هفت گنبد"));
        sotiItems.add(new Items("book16", "سلیمان در وادی مورچگان", "نویسنده: مرضیه رشیدبیگی", "مترجم: ---","راوی: امیر زنده دلان","انتشارات: کتاب گویا"));
        sotiItems.add(new Items("book17", "در همسایگی خدا", "نویسنده: حمیدرضا زاهدی", "مترجم: ---","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        sotiItems.add(new Items("book18", "بلال بلال", "نویسنده: اچ ای کریگ", "مترجم: عبدالرضا هوشنگ مهدوی","راوی: بهروز رضوی","انتشارات: کتاب گویا"));
        sotiItems.add(new Items("book19", "از سجاده تا سریر", "نویسنده: غلامرضا کاووسی", "مترجم: ---","راوی: بیوك میرزایی","انتشارات: کتاب گویا"));

        sotiAdapter = new ListViewAdapter(getContext(), sotiItems);

        sotiList.setAdapter(sotiAdapter);

        sotiList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent showbook = new Intent(getContext(), ShowBooks.class);

                bookId = ((Items) sotiAdapter.getItem(i)).getTitleBook();

                showbook.putExtra(ID_MESSAGE, bookId);

                startActivity(showbook);
            }
        });
    }
}
