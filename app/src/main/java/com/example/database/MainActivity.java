package com.example.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.database.dbfiles.myDatabase;

public class MainActivity extends AppCompatActivity {

    TextView name,location,salary;
    Button btn;
    ListView lv;
    myDatabase mdb=new myDatabase(this);
    Cursor cursor;
    SimpleCursorAdapter scb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.textViewName);
        location=findViewById(R.id.textViewLocation);
        salary=findViewById(R.id.textViewSalary);
        lv=findViewById(R.id.lv);
        btn=findViewById(R.id.insert);

        mdb.open();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strName = name.getText().toString();
                String strLoc = location.getText().toString();
                Integer intsla = Integer.parseInt(salary.getText().toString());

                ContentValues cv = new ContentValues();
                cv.put("name", strName);
                cv.put("location", strLoc);
                cv.put("salary", intsla);

                mdb.insertEmp(cv);

                name.setText(null);
                location.setText(null);
                salary.setText(null);

                cursor.requery();
                }
            });
            cursor=mdb.getEmp();
            String[] frontDB={"name","location","salary"};
            int[] toXml={R.id.name,R.id.location,R.id.salary};

            scb=new SimpleCursorAdapter(this,R.layout.row,cursor,frontDB,toXml,0);
            lv.setAdapter(scb);
            scb.notifyDataSetChanged();
            cursor.requery();
            }
    }


