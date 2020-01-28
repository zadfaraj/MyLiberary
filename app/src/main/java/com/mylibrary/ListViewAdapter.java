package com.mylibrary;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Items> mItem;

    public ListViewAdapter(Context mContext, ArrayList<Items> mItem) {
        this.mContext = mContext;
        this.mItem = mItem;
    }

    @Override
    public int getCount() {
        return mItem.size();
    }

    @Override
    public Object getItem(int i) {
        return mItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup, false);
        }

        ImageView imageBook = view.findViewById(R.id.image_Book);
        TextView titleBook = view.findViewById(R.id.title_Book);
        TextView writerBook = view.findViewById(R.id.writer_Book);
        TextView motarjemBook = view.findViewById(R.id.motarjem_Book);
        TextView raviBook = view.findViewById(R.id.ravi_Book);
        TextView entesharatBook = view.findViewById(R.id.entesharat_Book);

        Items currentItem = mItem.get(i);

        titleBook.setText(currentItem.getTitleBook());
        writerBook.setText(currentItem.getWriterBook());
        motarjemBook.setText(currentItem.getMotarjemBook());
        raviBook.setText(currentItem.getRaviBook());
        entesharatBook.setText(currentItem.getEntesharatBook());

        String mUri = "@drawable/" + currentItem.getImageBook();
        int imageSource = mContext.getResources().getIdentifier(mUri, null, mContext.getPackageName());
        imageBook.setImageDrawable(ResourcesCompat.getDrawable(mContext.getResources(), imageSource, null));

        return view;
    }
}
