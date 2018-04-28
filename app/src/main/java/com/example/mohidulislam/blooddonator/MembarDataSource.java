package com.example.mohidulislam.blooddonator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MembarDataSource {
    private MemberDatabaseHelper helper;
    private SQLiteDatabase db;

    public MembarDataSource(Context context) {
        helper = new MemberDatabaseHelper(context);
    }

    private void openDatabase(){
        db = helper.getWritableDatabase();
    }

    private void closeDatabase(){
        db.close();
    }

    public boolean insetNewMember(Member member) {
        this.openDatabase();
        ContentValues values = new ContentValues();
        values.put(MemberDatabaseHelper.TABLE_MEMBER_NAME,member.getName());
        values.put(MemberDatabaseHelper.TABLE_MEMBER_PHONE,member.getPhone());
        values.put(MemberDatabaseHelper.TABLE_MEMBER_EMAIL,member.getEmail());
        values.put(MemberDatabaseHelper.TABLE_MEMBER_PASS,member.getPassword());
        values.put(MemberDatabaseHelper.TABLE_MEMBER_DOB,member.getDateOfBirth());
        values.put(MemberDatabaseHelper.TABLE_MEMBER_GENDER,member.getGender());
        values.put(MemberDatabaseHelper.TABLE_MEMBER_BLOOD_GROUP,member.getBloodGroup());
        values.put(MemberDatabaseHelper.TABLE_MEMBER_CITY,member.getCity());
        long insertedRow = db.insert(MemberDatabaseHelper.TABLE_NAME,null,values);
        this.closeDatabase();
        if(insertedRow>0) {
            return true;
        }
        return false;
    }

    public List<Member>getAllMembers(){
        this.openDatabase();
        List<Member>members = new ArrayList<>();
        Cursor cursor = db.query(MemberDatabaseHelper.TABLE_NAME,null,null,null,null,null,null);
        if(cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do{
                int ID = cursor.getInt(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_ID));
                String name = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_NAME));
                String phone = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_PHONE));
                String email = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_EMAIL));
                String pass = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_PASS));
                String dob = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_DOB));
                String gender = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_GENDER));
                String bloodGroup = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_BLOOD_GROUP));
                String city = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_CITY));
                Member member = new Member(ID,name,phone,email,pass,dob,gender,bloodGroup,city);
                members.add(member);

            } while (cursor.moveToNext());
        }
        cursor.close();
        this.closeDatabase();
        return members;
    }
    public List<Member> getMembersByCity(String city){
        this.openDatabase();
        List<Member>members = new ArrayList<>();
        String arg = "'"+city+"'";
        String selection = MemberDatabaseHelper.TABLE_MEMBER_CITY+"=?";
        Cursor cursor = db.query(MemberDatabaseHelper.TABLE_NAME,null,selection,new String[]{city},null,null,null);
        if(cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do{
                int ID = cursor.getInt(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_ID));
                String name = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_NAME));
                String phone = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_PHONE));
                String email = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_EMAIL));
                String pass = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_PASS));
                String dob = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_DOB));
                String gender = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_GENDER));
                String bloodGroup = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_BLOOD_GROUP));
                Member member = new Member(ID,name,phone,email,pass,dob,gender,bloodGroup,city);
                members.add(member);

            } while (cursor.moveToNext());
        }
        cursor.close();
        this.closeDatabase();
        return members;
    }

    public Member getMemberByEmail(String email){
        Member member = null;
        this.openDatabase();
        String emailString = String.valueOf(email);
        String arg = "'"+emailString+"'";
        String selection = MemberDatabaseHelper.TABLE_MEMBER_EMAIL+"=?";
        Cursor cursor = db.query(MemberDatabaseHelper.TABLE_NAME,null,selection,new String[]{emailString},null,null,null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            int ID = cursor.getInt(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_ID));
            String name = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_PHONE));
            String pass = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_PASS));
            String dob = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_DOB));
            String gender = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_GENDER));
            String bloodGroup = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_BLOOD_GROUP));
            String city = cursor.getString(cursor.getColumnIndex(MemberDatabaseHelper.TABLE_MEMBER_CITY));
            member = new Member(ID,name,phone,email,pass,dob,gender,bloodGroup,city);
        }
        cursor.close();
        this.closeDatabase();
        return member;
    }
}
