package com.example.rxjavademoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavademoapp.model.Entry;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private final List<Entry> mEntries = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        //holder.txtname.setText(mStringList.get(position));
        Entry entry=mEntries.get(position);
        holder.setTextName(entry.getEntryName());
        holder.setTextPrice(entry.getentryPrice());
        holder.setTextDate(entry.getEntryDate());
    }

    @Override
    public int getItemCount() {
        return mEntries.size();
    }

    public void addEntriesItems(Entry entry) {
        mEntries.add(entry);
        notifyItemInserted(mEntries.size() - 1);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textName)
        TextView textName;
        @BindView(R.id.textDate)
        TextView textDate;
        @BindView(R.id.textPrice)
        TextView textPrice;

        private final NumberFormat ENTRY_PRICE_FORMAT=new DecimalFormat("#0.00");

        public void setTextName(String textName) {
            this.textName.setText(textName);
        }

        public void setTextDate(Date textDate) {
            this.textDate.setText(android.text.format.DateFormat.format("yyyy-mm-dd hh:mm",textDate));
        }

        public void setTextPrice(double textPrice) {
            this.textPrice.setText(ENTRY_PRICE_FORMAT.format(textPrice));
        }

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
