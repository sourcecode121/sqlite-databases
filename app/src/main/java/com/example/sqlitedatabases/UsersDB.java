package com.example.sqlitedatabases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by Anand on 26/10/2016.
 */

public class UsersDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DBUsers.db";
    private static final String USERS_TABLE_NAME = "users";
    private static final String USERS_COLUMN_ID = "id";
    private static final String USERS_COLUMN_FIRST_NAME = "first_name";
    private static final String USERS_COLUMN_LAST_NAME = "last_name";
    private static final String USERS_COLUMN_AGE = "age";

    private static final String USERS_TABLE_CREATE =
                    "CREATE TABLE IF NOT EXISTS " + USERS_TABLE_NAME + " (" +
                    USERS_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    USERS_COLUMN_FIRST_NAME + " TEXT, " +
                    USERS_COLUMN_LAST_NAME + " TEXT, " +
                    USERS_COLUMN_AGE + " INTEGER" +
                    ")";

    private static final String USERS_DROP_TABLE =
                    "DROP TABLE IF EXISTS " + USERS_TABLE_NAME;

    public UsersDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(USERS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(USERS_DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public boolean insertUserDetails(String firstName, String lastName, int age) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_COLUMN_FIRST_NAME, firstName);
        contentValues.put(USERS_COLUMN_LAST_NAME, lastName);
        contentValues.put(USERS_COLUMN_AGE, age);
        sqLiteDatabase.insert(USERS_TABLE_NAME, null, contentValues);
        return true;
    }
}
