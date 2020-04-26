package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.dynamodbv2.document.Table;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import org.w3c.dom.Document;

import androidx.appcompat.app.AppCompatActivity;

import static type.CustomType.ID;

public class DatabaseAccess extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "choretrackerapp.db";
    public static final String USER_TABLE = "users";
    public static final String EVENTS_TABLE = "events";
    public static final String GROUP_TABLE = "groups";
    public static final String COL_USERNAME = "USERNAME";
    public static final String COL_EVENT_NAME = "EVENT_NAME";
    public static final String COL_EVENT_DATE = "EVENT_DATE";
    public static final String COL_EVENT_END_DATE = "EVENT_END_DATE";
    public static final String COL_EVENT_DESC = "EVENT_DESC";
    public static final String COL_GROUP_NAME = "GROUP_NAME";
    public static final String COL_GROUP_ADMIN = "GROUP_ADMIN";
    public static final String COL_SETTINGS_COLOR = "SETTINGS_COLOR";
    public static final String COL_PICTURE = "SETTINGS_PICTURE";

    /* Table: users
    *  ID  USERNAME  SETTINGS_COLOR  SETTINGS_PICTURE
    * */

    /* Table: events
     *  ID  USERNAME  EVENT_NAME  EVENT_DATE  EVENT_END_DATE  EVENT_DESC
     * */

    /* Table: Groups
     *  ID  GROUP_NAME  USERNAME  ADMIN
     * */

    public DatabaseAccess(Context context) {
        super(context, DATABASE_NAME, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + USER_TABLE + "  (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, SETTINGS_COLOR TEXT, SETTINGS_PICTURE TEXT) ");
        db.execSQL("create table " + EVENTS_TABLE + "  (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, EVENT_NAME TEXT, EVENT_DATE TEXT, EVENT_DESC TEXT) ");
        db.execSQL("create table " + GROUP_TABLE + "  (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, GROUP_ADMIN TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + EVENTS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + GROUP_TABLE);
        onCreate(db);
    }

    public boolean insertUser(String name, String color, String picture) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_USERNAME,name);
        contentValues.put(COL_SETTINGS_COLOR, color);
        contentValues.put(COL_PICTURE, picture);

        long result = db.insert(USER_TABLE,null, contentValues);
        if( result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean addEvent(String name, String eventName, String eventStart, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_USERNAME, name);
        contentValues.put(COL_EVENT_NAME, eventName);
        contentValues.put(COL_EVENT_DATE, eventStart);
        contentValues.put(COL_EVENT_DESC, description);

        long result = db.insert(EVENTS_TABLE,null, contentValues);
        if( result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean addGroup(String groupName, String admin ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_USERNAME, groupName);
        contentValues.put(COL_GROUP_ADMIN, admin);

        long result = db.insert(GROUP_TABLE,null, contentValues);
        if( result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getAllEvents() {
        SQLiteDatabase db = this.getWritableDatabase();
        String username = AWSMobileClient.getInstance().getUsername();
        Cursor res = db.rawQuery("select * from " + EVENTS_TABLE, null);
        return res;
    }

    public Cursor getAllMembers() {
        SQLiteDatabase db = this.getWritableDatabase();
        String username = AWSMobileClient.getInstance().getUsername();
        Cursor res = db.rawQuery("select * from " + GROUP_TABLE, null);
        return res;
    }

    public void deleteItem(String event) {
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(EVENTS_TABLE, COL_EVENT_NAME + " = ?", new String[] {String.valueOf(event)});

        if( result > 0) {
            Log.i("DELETED", "SUCCESSFULL");
        }
        else {
            Log.i("FAILED", "NOT DOUND");
        }
    }

    public void deleteGroup(String event) {
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(GROUP_TABLE, COL_USERNAME + " = ?", new String[] {String.valueOf(event)});

        if( result > 0) {
            Log.i("DELETED", "SUCCESSFULL");
        }
        else {
            Log.i("FAILED", "NOT DOUND");
        }
    }
}

