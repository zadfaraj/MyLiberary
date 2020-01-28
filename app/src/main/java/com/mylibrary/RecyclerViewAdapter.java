package com.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    private Context mContext;
    private ArrayList<Items> mItem;

    public RecyclerViewAdapter(Context mContext, ArrayList<Items> mItem) {
        this.mContext = mContext;
        this.mItem = mItem;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, final int i) {

        final Items currentItem = mItem.get(i);

        myViewHolder.titleBook.setText(currentItem.getTitleBook());
        myViewHolder.writerBook.setText(currentItem.getWriterBook());
        myViewHolder.motarjemBook.setText(currentItem.getMotarjemBook());
        myViewHolder.raviBook.setText(currentItem.getRaviBook());
        myViewHolder.entesharatBook.setText(currentItem.getEntesharatBook());

        String mUri = "@drawable/" + currentItem.getImageBook();
        int imageSource = mContext.getResources().getIdentifier(mUri, null, mContext.getPackageName());
        myViewHolder.imageBook.setImageDrawable(ResourcesCompat.getDrawable(mContext.getResources(), imageSource, null));

        myViewHolder.selected_item.setOnClickListener(new View.OnClickListener() {

            public static final String ID_MESSAGE = "IDMESSAGE";
            String bookId;

            @Override
            public void onClick(View v) {

                Intent showbook = new Intent(mContext, ShowBooks.class);

                bookId = currentItem.getTitleBook();

                showbook.putExtra(ID_MESSAGE, bookId);

                mContext.startActivity(showbook);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView imageBook;
        TextView titleBook;
        TextView writerBook;
        TextView motarjemBook;
        TextView raviBook;
        TextView entesharatBook;

        LinearLayout selected_item;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageBook = itemView.findViewById(R.id.image_Book);
            titleBook = itemView.findViewById(R.id.title_Book);
            writerBook = itemView.findViewById(R.id.writer_Book);
            motarjemBook = itemView.findViewById(R.id.motarjem_Book);
            raviBook = itemView.findViewById(R.id.ravi_Book);
            entesharatBook = itemView.findViewById(R.id.entesharat_Book);

            selected_item = itemView.findViewById(R.id.selected_item);
        }
    }
}
