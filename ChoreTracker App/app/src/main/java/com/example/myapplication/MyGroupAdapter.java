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


public class MyGroupAdapter extends RecyclerView.Adapter<MyGroupAdapter.ViewHolder> implements Filterable {
    private List<GroupMember> listData;
    private List<GroupMember> listDataFull;
    // RecyclerView recyclerView;
    public MyGroupAdapter(List<GroupMember> listData) {

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
        GroupMember currentItem = listData.get(position);
        holder.name.setText(currentItem.getGroupMember());
        holder.date.setText(currentItem.getAdmin());
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
        }

    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<GroupMember> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listDataFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (GroupMember item : listDataFull) {
                    if (item.getGroupMember().toLowerCase().contains(filterPattern)) {
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