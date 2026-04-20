package com.example.astrorehber;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AstroRehber.db";
    private static final int DATABASE_VERSION = 3;

    private static final String TABLE_USERS = "users";
    private static final String COL_USER_ID = "id";
    private static final String COL_FULL_NAME = "full_name";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";
    private static final String COL_BIRTHDATE = "birthdate";

    private static final String TABLE_ZODIACS = "zodiacs";
    private static final String COL_ZODIAC_ID = "id";
    private static final String COL_ZODIAC_NAME = "name";
    private static final String COL_DATE_RANGE = "date_range";
    private static final String COL_DAILY = "daily_comment";
    private static final String COL_WEEKLY = "weekly_comment";
    private static final String COL_MONTHLY = "monthly_comment";
    private static final String COL_ELEMENT = "element";
    private static final String COL_PLANET = "planet";
    private static final String COL_LUCKY_NUM = "lucky_number";
    private static final String COL_LUCKY_COLOR = "lucky_color";
    private static final String COL_ICON_RES = "icon_res_id";
    private static final String COL_COVER_RES = "cover_res_id";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE " + TABLE_USERS + " (" +
                COL_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_FULL_NAME + " TEXT, " +
                COL_EMAIL + " TEXT UNIQUE, " +
                COL_PASSWORD + " TEXT, " +
                COL_BIRTHDATE + " TEXT)";
        db.execSQL(createUsersTable);

        String createZodiacsTable = "CREATE TABLE " + TABLE_ZODIACS + " (" +
                COL_ZODIAC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ZODIAC_NAME + " TEXT, " +
                COL_DATE_RANGE + " TEXT, " +
                COL_DAILY + " TEXT, " +
                COL_WEEKLY + " TEXT, " +
                COL_MONTHLY + " TEXT, " +
                COL_ELEMENT + " TEXT, " +
                COL_PLANET + " TEXT, " +
                COL_LUCKY_NUM + " TEXT, " +
                COL_LUCKY_COLOR + " TEXT, " +
                COL_ICON_RES + " INTEGER, " +
                COL_COVER_RES + " INTEGER)";
        db.execSQL(createZodiacsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ZODIACS);
        onCreate(db);
    }

    public boolean addUser(String fullName, String email, String password, String birthdate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_FULL_NAME, fullName);
        values.put(COL_EMAIL, email);
        values.put(COL_PASSWORD, password);
        values.put(COL_BIRTHDATE, birthdate);

        long result = db.insert(TABLE_USERS, null, values);
        return result != -1; // -1 dönerse kayıt başarısız
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COL_USER_ID};
        String selection = COL_EMAIL + "=?" + " and " + COL_PASSWORD + "=?";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }

    public boolean checkNameExists(String fullName) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COL_FULL_NAME + " = ?", new String[]{fullName});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public boolean checkEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COL_EMAIL + " = ?", new String[]{email});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public void addZodiac(Zodiac zodiac) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ZODIAC_NAME, zodiac.getName());
        values.put(COL_DATE_RANGE, zodiac.getDateRange());
        values.put(COL_DAILY, zodiac.getDailyComment());
        values.put(COL_WEEKLY, zodiac.getWeeklyComment());
        values.put(COL_MONTHLY, zodiac.getMonthlyComment());
        values.put(COL_ELEMENT, zodiac.getElement());
        values.put(COL_PLANET, zodiac.getPlanet());
        values.put(COL_LUCKY_NUM, zodiac.getLuckyNumber());
        values.put(COL_LUCKY_COLOR, zodiac.getLuckyColor());
        values.put(COL_ICON_RES, zodiac.getIconResId());
        values.put(COL_COVER_RES, zodiac.getCoverResId());

        db.insert(TABLE_ZODIACS, null, values);
    }

    public List<Zodiac> getAllZodiacs() {
        List<Zodiac> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ZODIACS, null);

        if (cursor.moveToFirst()) {
            do {
                Zodiac zodiac = new Zodiac(
                        cursor.getString(1), // name
                        cursor.getString(2), // dateRange
                        cursor.getInt(10),   // icon
                        cursor.getInt(11),   // cover
                        cursor.getString(3), // daily
                        cursor.getString(4), // weekly
                        cursor.getString(5), // monthly
                        cursor.getString(6), // element
                        cursor.getString(7), // planet
                        cursor.getString(8), // luckyNum
                        cursor.getString(9)  // luckyColor
                );
                list.add(zodiac);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public boolean isZodiacTableEmpty() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT count(*) FROM " + TABLE_ZODIACS, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        return count == 0;
    }

    public String getUserFullName(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COL_FULL_NAME + " FROM " + TABLE_USERS + " WHERE " + COL_EMAIL + " = ?", new String[]{email});
        String fullName = "Yıldız Tozu"; // Varsayılan isim
        if (cursor.moveToFirst()) {
            fullName = cursor.getString(0);
        }
        cursor.close();
        return fullName;
    }
}