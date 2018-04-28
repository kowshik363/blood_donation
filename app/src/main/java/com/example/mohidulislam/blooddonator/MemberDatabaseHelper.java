package com.example.mohidulislam.blooddonator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MemberDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "member_table";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "member_table";
    public static final String TABLE_MEMBER_ID = "member_id";
    public static final String TABLE_MEMBER_NAME = "member_name";
    public static final String TABLE_MEMBER_PHONE = "member_phone";
    public static final String TABLE_MEMBER_EMAIL = "member_email";
    public static final String TABLE_MEMBER_PASS = "member_password";
    public static final String TABLE_MEMBER_DOB = "member_date_of_birth";
    public static final String TABLE_MEMBER_GENDER = "member_gender";
    public static final String TABLE_MEMBER_BLOOD_GROUP = "member_blood_group";
    public static final String TABLE_MEMBER_CITY = "member_city";

    public MemberDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String CREATE_TABLE_MEMBER = "create table "+TABLE_NAME+"("+
            TABLE_MEMBER_ID+" integer primary key, "+
            TABLE_MEMBER_NAME+" text, "+
            TABLE_MEMBER_PHONE+" text, "+
            TABLE_MEMBER_EMAIL+" text, "+
            TABLE_MEMBER_PASS+" text, "+
            TABLE_MEMBER_DOB+" date, "+
            TABLE_MEMBER_GENDER+" text, "+
            TABLE_MEMBER_BLOOD_GROUP+" text, "+
            TABLE_MEMBER_CITY+" text);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MEMBER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
