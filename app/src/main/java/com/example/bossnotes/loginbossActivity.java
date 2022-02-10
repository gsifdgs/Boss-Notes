package com.example.bossnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginbossActivity extends AppCompatActivity {
private Button button8;
    private EditText editText3, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loginboss);
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openemp();
            }
        });
        editText3 = findViewById(R.id.editText3);
        editText2=findViewById(R.id.editText2);
    }

    public void openemp(){
        Intent intent= new Intent(this, Bossregister.class);
        startActivity(intent);
    }
    public void login (View v){
        String email= editText3.getText().toString().trim();
        String password= editText2.getText().toString().trim();
        BossSqlite helper = new BossSqlite(this);
        Boolean result= helper.checkBoss(email, password);
        if(result==true){
            Toast.makeText(this, "Succesfully logged in", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(this, PageBoss.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Failed to log in", Toast.LENGTH_SHORT).show();
        }
    }
}
