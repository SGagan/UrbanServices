package frikisoni.urbanservices;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yash on 19/07/17.
 */

public class DatabaseHelper1 extends SQLiteOpenHelper {
    public static final String dbname = "fab2.db";
    public static final String tbname = "Electrician";

    public static final String col1 = "_id";
    public static final String col2 = "name";
    public static final String col3="address";
    public static final String col4 = "email";
    public static final String col5 = "pass";
    public static final String col6="ph_no";

    final String createTable = " create table " + tbname + " ( _id integer primary key autoincrement,name text,address text,email text,pass text,ph_no integer)";

    static SQLiteDatabase db1;

    public DatabaseHelper1(Context context) {
        super(context, dbname, null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase db1) {
        db1.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {
        db1.execSQL(" drop table if exists " + tbname);
        onCreate(db1);
    }

    public boolean insertData(String name, String address, String email, String pass,String ph_no){
        db1=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2, name);;
        cv.put(col3, address);
        cv.put(col4, email);
        cv.put(col5, pass);
        cv.put(col6,ph_no);
        long result=db1.insert(tbname, null, cv);
        if(result == -1)
            return false;
        else
            return true;
    }

    }


