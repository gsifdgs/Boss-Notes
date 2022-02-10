package com.example.bossnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class sqlEmployee extends AppCompatActivity {
    BossSqlite sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_employee);
        ListView listVieww = (ListView) findViewById(R.id.ListView);
        sq = new BossSqlite(this);
        ArrayList<String> thelist = new ArrayList<>();
        Cursor cursorr = sq.getListEmployee();
        String text="";
        if(cursorr.getCount()==0){
            Toast.makeText(sqlEmployee.this, "the database was empty: ", Toast.LENGTH_SHORT).show();
        }else{
            while(cursorr.moveToNext()){
                thelist.add(cursorr.getString(0)+", "+cursorr.getString(1)+", "+cursorr.getString(2)+", "
                        +cursorr.getString(3)+", "+cursorr.getString(4)+", "+cursorr.getString(5)+", "+cursorr.getString(6));
               /* thelist.add(cursorr.getString(0));
                thelist.add(cursorr.getString(1));
                thelist.add(cursorr.getString(2));
                thelist.add(cursorr.getString(3));
                thelist.add(cursorr.getString(4));
                thelist.add(cursorr.getString(5));
                thelist.add(cursorr.getString(6));*/
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                listVieww.setAdapter(listAdapter);
            }
        }

    }
}
