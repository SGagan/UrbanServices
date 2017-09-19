package frikisoni.urbanservices;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class carpenter extends Fragment {
    View v;

    public ArrayList<String> results = new ArrayList<String>();
    public String tableName = DatabaseHelper2.tbname;
    public SQLiteDatabase newDB;


    TextView tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_carpenter, container, false);
        ListView li=(ListView) v.findViewById(R.id.listView);
        ArrayAdapter<String> a=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,results);
        li.setAdapter(a);
        try{
            DatabaseHelper2 d2 = new DatabaseHelper2(this.getActivity());
            newDB=d2.getWritableDatabase();
            Cursor c=newDB.rawQuery(" select * from " + tableName , null);
            if(c!=null){
                if(c.moveToFirst()){
                    do{
                        String first =c.getString(c.getColumnIndex("name"));
                        String add =c.getString(c.getColumnIndex("address"));
                        results.add("name" + first + " " + "address" + add);
                    }
                    while (c.moveToNext());
                }
            }


        }
        catch (SQLiteException se){
            Log.e(getClass().getSimpleName(),"not");

        }
        finally {
            if(newDB!=null)
                newDB.execSQL("DELETE FROM " + tableName);
            newDB.close();
     }
        return v;



    }



    }

