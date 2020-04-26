package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class GroupDisplay extends AppCompatActivity {
    private MyGroupAdapter adapter;
    private ArrayList<GroupMember> GroupList;
    private AWSAppSyncClient mAWSAppSyncClient;
    private static final String TAG = Events.class.getSimpleName();
    Button newEvent;
    String username = AWSMobileClient.getInstance().getUsername();
    DatabaseAccess myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_display);

        myDb = new DatabaseAccess(this);

        fillExampleList();

        newEvent = findViewById(R.id.button3);

        newEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Group.class);
                startActivity(intent);
            }
        });
    }
    private void fillExampleList() {
        GroupList = new ArrayList<GroupMember>();
        Cursor res = myDb.getAllMembers();
        if(res.getCount() == 0) {
            Log.i("FAILED", "NO ENTITIES");
            return;
        }
        while (res.moveToNext()) {
            GroupList.add(new GroupMember(res.getString(1), res.getString(2)));
        }
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        myDb = new DatabaseAccess(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Context ctx = recyclerView.getContext();

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new MyGroupAdapter(GroupList);

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
                String name = GroupList.get(position).getGroupMember();

                GroupList.remove(GroupList.get(position));
                myDb.deleteGroup(name);
                adapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);
    }
}
