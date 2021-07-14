package com.example.database.dbfiles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class myHelper extends SQLiteOpenHelper {
    public myHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name, factory, version);
}
    @Override
    public void onCreate(SQLiteDatabase sd) {
        sd.execSQL("create table employee_id integer primary key,+ " +
                        "name text,location text, salary integer);");
              //Toast.makeText(contE,"",Toast.LENGTH_SHORT).show();
              Log.d("myHelper class","table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
