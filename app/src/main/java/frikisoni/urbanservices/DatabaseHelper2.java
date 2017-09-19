package frikisoni.urbanservices;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yash on 19/07/17.
 */

public class DatabaseHelper2 extends SQLiteOpenHelper {
    public static final String dbname = "fab3.db";
    public static final String tbname = "Carpenter";

    public static final String col1 = "_id";
    public static final String col2 = "name";
    public static final String col3="address";
    public static final String col4 = "email";
    public static final String col5 = "pass";
    public static final String col6="ph_no";

    final String createTable = " create table " + tbname + " ( _id integer primary key autoincrement,name text,address text,email text,pass text,ph_no text)";

    static SQLiteDatabase db2;

    public DatabaseHelper2(Context context) {
        super(context, dbname, null, 3);
    }
    @Override
    public void onCreate(SQLiteDatabase db2) {
        db2.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
        db2.execSQL(" drop table if exists " + tbname);
        onCreate(db2);
    }

    public boolean insertData(String name, String address, String email, String pass,String ph_no){
        db2=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2, name);
        cv.put(col3, address);
        cv.put(col4, email);
        cv.put(col5, pass);
        cv.put(col6,ph_no);
        long result=db2.insert(tbname, null, cv);
        if(result == -1)
            return false;
        else
            return true;
    }

    }



