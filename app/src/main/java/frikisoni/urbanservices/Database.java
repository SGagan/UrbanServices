package frikisoni.urbanservices;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yash on 28/07/17.
 */

public class Database extends SQLiteOpenHelper {

    public static final String dbname = "company12.db";
    public static final String tbname = "user21";
    public static final String col1 = "_id";
    public static final String col2 = "name";
    public static final String col3 = "email";
    public static final String col4 = "pass";

    final String createTable = " create table " + tbname + " ( _id integer primary key autoincrement,name text,email text,pass text)";

    static SQLiteDatabase db;

    public Database(Context context) {
        super(context, dbname, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists" + tbname);
        onCreate(db);
    }

    public boolean insertData(String name, String email, String pass){
        db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2, name);
        cv.put(col3, email);
        cv.put(col4, pass);
        long result=db.insert(tbname, null, cv);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(String email, String pass){
        db=this.getWritableDatabase();
        Cursor res=db.rawQuery(" select * from " + tbname + " where email=? and pass=?", new String[]{email,pass});
        return res;
    }
}