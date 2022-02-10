package com.example.bossnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeActivity extends AppCompatActivity {
    TextView TextViewEmail;
    EditText editTextName,editTextPass, editTextNumber, editTextBirth;
    String genderr;
    RadioButton erkek, kadin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        editTextName=findViewById(R.id.editTextName);
        editTextPass=findViewById(R.id.editTextPass);
        editTextNumber=findViewById(R.id.editTextNumber);
        erkek =(RadioButton) findViewById(R.id.radioButton);
        kadin =(RadioButton) findViewById(R.id.radioButton2);
        editTextBirth=findViewById(R.id.editTextBirth);
        TextViewEmail=findViewById(R.id.textViewEmail);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            TextViewEmail.setText(value);
        }
        else{
            String value="hata";
            TextViewEmail.setText(value);
        }
    }
    public void update(View v){
        try{
            if(erkek.isChecked()){
                genderr="Erkek";
            }
            else{
                genderr="Kadin";
            }
            BossSqlite helper = new BossSqlite(this);
            String name = editTextName.getText().toString();
            String password= editTextPass.getText().toString();
            String numberr= editTextNumber.getText().toString(); int number= Integer.parseInt(numberr);
            String birth= editTextBirth.getText().toString();
            String gender= genderr;
            String email = TextViewEmail.getText().toString();
            String result= helper.UpdateEmailEmployee(name, email, password, number, gender, birth);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
