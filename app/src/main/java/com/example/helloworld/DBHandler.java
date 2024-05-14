package com.example.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "HotelApp";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private final Context context;
    private SQLiteDatabase db;

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }


    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.

        db.execSQL("CREATE TABLE Member(" +
                "nic TEXT PRIMARY KEY," +
                "mem_name TEXT," +
                "mem_address TEXT," +
                "mem_phone TEXT," +
                "mem_email TEXT);");


        db.execSQL("CREATE TABLE Booking(" +
                "booking_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "mem_nic TEXT," +
                "hotel_name TEXT," +
                "room_type TEXT," +
                "no_rooms INTEGER," +
                "booking_date DATETIME ," +
                "payment NUMBER(7,2)," +
                "FOREIGN KEY(mem_nic) REFERENCES Member(nic));");


    }

    // this method is use to add new course to our sqlite database.

    public Boolean addNewMember(String nic, String name, String address, String phone, String email) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("nic", nic);
        values.put("mem_name", name);
        values.put("mem_address", address);
        values.put("mem_phone", phone);
        values.put("mem_email", email);

        // after adding all values we are passing
        // content values to our table.

        long result = db.insert("Member", null, values);
        db.close();

        if (result == -1) {
            return false;
        } else {
            return true;
        }
        // at l
    }


    public boolean validateUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Member where mem_email =? AND nic = ?", new String[]{email,password});

        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS Member;");
        db.execSQL("DROP TABLE IF EXISTS Booking;");
        onCreate(db);
    }

    public Boolean addBooking(String nic, String sHname, String sRoomType, int noOfRooms, double rent_per_room) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        double fullPayment = noOfRooms* rent_per_room;

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("mem_nic", nic);
        values.put("hotel_name", sHname);
        values.put("room_type", sRoomType);
        values.put("no_rooms", noOfRooms);
        values.put("booking_date", getDateTime());
        values.put("payment", fullPayment);

        // after adding all values we are passing
        // content values to our table.

        long result = db.insert("Booking", null, values);
        db.close();

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

   public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Booking",null);
        return cursor;
   }
}

