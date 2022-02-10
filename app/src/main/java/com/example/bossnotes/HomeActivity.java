package com.example.bossnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button button2, button1,button8, buttonkayit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openemp();
            }
        });
        button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openboss();
            }
        });
     //   button8 = findViewById(R.id.button8);
      /*  button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensql();
            }
        });
     //   buttonkayit = findViewById(R.id.buttonkayit);
      //  buttonkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregister();
            }
        });*/
    }
    public void openemp(){
        Intent intent= new Intent(this, loginemployeeActivity.class);
        startActivity(intent);
    }
    public void openboss(){
        Intent intent= new Intent(this, loginbossActivity.class);
        startActivity(intent);
    }
    public void opensql(){
        Intent intent= new Intent(this, sqlBoss.class);
        startActivity(intent);
    }
    public void openregister(){
        Intent intent= new Intent(this, Bossregister.class);
        startActivity(intent);
    }
}

