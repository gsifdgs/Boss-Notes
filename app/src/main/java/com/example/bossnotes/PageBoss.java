package com.example.bossnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PageBoss extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_boss);
    }
    public void employee(View v){
        Intent intent= new Intent(this, AddEmployee.class);
        startActivity(intent);
    }
    public void Boss(View v){
        Intent intent= new Intent(this, AddBoss.class);
        startActivity(intent);
    }
}
