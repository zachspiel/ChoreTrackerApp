package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.Event;
import com.example.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements Filterable {
    private List<Event> listData;
    private List<Event> listDataFull;
    // RecyclerView recyclerView;
    public MyAdapter(List<Event> listData) {

        this.listData = listData;
        listDataFull = new ArrayList<>(listData);

    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.recyclerview_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event currentItem = listData.get(position);
        holder.name.setText(currentItem.getName());
        holder.date.setText(currentItem.getDate());
        holder.endDate.setText(currentItem.getEndDate());
        holder.username.setText(currentItem.getUsername());
        holder.desc.setText(currentItem.getDesc());
    }


    @Override
    public int getItemCount() { return listData.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView date;
        public TextView endDate;
        public TextView username;
        public TextView desc;
        public RelativeLayout relativeLayout;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.date = itemView.findViewById(R.id.season);
            this.username = itemView.findViewById(R.id.price);
            this.endDate = itemView.findViewById(R.id.location);
            this.desc = itemView.findViewById(R.id.time);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);

        }

    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Event> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listDataFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Event item : listDataFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listData.clear();
            listData.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}