package com.example.database.dbfiles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class myDatabase {
    public static final String MY_DB="empDB";
    Context myContext;
    myHelper mh;
    SQLiteDatabase sdb;

    public myDatabase(Context context){
        this.myContext=context;

        mh=new myHelper(myContext,MY_DB,null,1);
    }
    public void open(){
        //to seek permission for writing the DB
        sdb=mh.getWritableDatabase();
    }
    public void insertEmp(ContentValues cv){
        sdb.insert("employee",null,cv);
    }
    public Cursor getEmp() {
        sdb = mh.getReadableDatabase();

        Cursor c = sdb.query("employee", null, null, null, null,null,null);
        return c;

    }

}
