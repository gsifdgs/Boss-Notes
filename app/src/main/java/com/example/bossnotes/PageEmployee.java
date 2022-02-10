package com.example.bossnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PageEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_employee);


    }
    public void Guncelle(View v){
        Intent intent= new Intent(this,EmployeeActivity.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            intent.putExtra("key",value);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "There is an error at sending data", Toast.LENGTH_SHORT).show();
        }
    }
}
