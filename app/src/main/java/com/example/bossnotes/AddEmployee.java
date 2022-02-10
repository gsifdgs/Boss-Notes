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

public class AddEmployee extends AppCompatActivity {
    EditText editTextName,editTextEmail,editTextPass, editTextNumber, editTextBirth, editTextId;
    String genderr;
    RadioButton erkek, kadin;
    private Button button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_employee);
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
        erkek =(RadioButton) findViewById(R.id.radioButton);
        kadin =(RadioButton) findViewById(R.id.radioButton2);
        editTextBirth=findViewById(R.id.editTextBirth);
        editTextId=findViewById(R.id.editTextId);
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
    public void Delete(View v){
        try{
            BossSqlite helper = new BossSqlite(this);
            String idd= editTextId.getText().toString(); int id=Integer.parseInt(idd);
            String result= helper.DeleteEmployee(id);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void openemp(){
        Intent intent= new Intent(this, sqlEmployee.class);
        startActivity(intent);
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
            String email = editTextEmail.getText().toString();
            String password= editTextPass.getText().toString();
            String numberr= editTextNumber.getText().toString(); int number= Integer.parseInt(numberr);
            String birth= editTextBirth.getText().toString();
            String gender= genderr;
            String idd= editTextId.getText().toString(); int id=Integer.parseInt(idd);
            String result= helper.UpdateEmployee(id, name, email, password, number, gender, birth);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
