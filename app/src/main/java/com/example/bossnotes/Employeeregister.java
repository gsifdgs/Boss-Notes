package com.example.bossnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Employeeregister extends AppCompatActivity {
    EditText editTextName,editTextEmail,editTextPass, editTextNumber, editTextBirth;
    String genderr;
    RadioButton erkek, kadin;
    TextView tvShowData;
    private Button button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_employeeregister);
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openemp();
            }
        });
        editTextName=findViewById(R.id.editTextName);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPass=findViewById(R.id.editTextPass);
        editTextNumber=findViewById(R.id.editTextNumber);
        tvShowData = findViewById(R.id.textView9);
        erkek =(RadioButton) findViewById(R.id.radioButton);
        kadin =(RadioButton) findViewById(R.id.radioButton2);
        editTextBirth=findViewById(R.id.editTextBirth);
    }
    public void kayitol(View v){
        try{
            if(erkek.isChecked()){
                genderr="Erkek";
            }
            else{
                genderr="Kadin";
            }
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String password= editTextPass.getText().toString();
            String birth= editTextBirth.getText().toString();
            String gender= genderr;
            String numberr= editTextNumber.getText().toString(); int number= Integer.parseInt(numberr);
            BossSqlite helper = new BossSqlite(this);
            String result= helper.AddEmployee(name, email, password, number,gender, birth);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void ShowBoss(View v){
        try{
            BossSqlite helper = new BossSqlite(this);
            tvShowData.setText( helper.GetAllEmployee());
        }
        catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void openemp(){
        Intent intent= new Intent(this, sqlEmployee.class);
        startActivity(intent);
    }
}

