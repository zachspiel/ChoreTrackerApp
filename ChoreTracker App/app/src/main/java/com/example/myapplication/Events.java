package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Events extends AppCompatActivity {
    private MyAdapter adapter;
    private ArrayList<Event> EventList;
    private AWSAppSyncClient mAWSAppSyncClient;
    private static final String TAG = Events.class.getSimpleName();

    String username = AWSMobileClient.getInstance().getUsername();
    DatabaseAccess myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chore_list);

        myDb = new DatabaseAccess(this);
        String TAG = "EVENTS";

        Log.i(TAG, "In Events correctly");

        fillExampleList();

        Button newEvent = findViewById(R.id.button6);

        newEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), addEvents.class);
                startActivity(intent);
            }
        });
    }

    private void fillExampleList() {
        EventList = new ArrayList<Event>();
        Cursor res = myDb.getAllEvents();
        if(res.getCount() == 0) {
            Log.i("FAILED", "NO ENTITIES");
            return;
        }
        while (res.moveToNext()) {
            EventList.add(new Event(res.getString(2), res.getString(3), res.getString(4), username));
        }
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        myDb = new DatabaseAccess(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Context ctx = recyclerView.getContext();

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new MyAdapter(EventList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
               int position = viewHolder.getAdapterPosition();
               String name = EventList.get(position).getName();

               EventList.remove(EventList.get(position));
               myDb.deleteItem(name);
               adapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);
    }
}

