package com.example.bossnotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BossSqlite extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "BossData";
    public static final String TABLE1 = "bossdataa";
    public static final String Table2 = "employeedataa";
    public static final String Table_id = "id";
    public static final String Table_name = "Name";
    public static final String Table_email="email";
    public static final String Table_password="password";
    public static final String Table_birth="birth";
    public static final String Table_gender="gender";
    public static final String Table_number="number";
    public BossSqlite(Context c){
        super(c, DATABASE_NAME,null,1);
    }
    @Override

    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+TABLE1+" ("+Table_id+" integer primary key autoincrement, "+Table_name+" text, "+Table_email+" text, "+Table_password+" text, "+Table_birth+" text,"+Table_gender+" text, "+Table_number+" integer)";
        String sql1 = "create table "+Table2+" ("+Table_id+" integer primary key autoincrement, "+Table_name+" text, "+Table_email+" text, "+Table_password+" text, "+Table_birth+" text,"+Table_gender+" text, "+Table_number+" integer)";
        db.execSQL(sql);
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop table if exists " +TABLE1);
db.execSQL("drop table if exists " +Table2);
onCreate(db);
    }
    public String AddBoss(String name, String email, String password, int Number, String gender, String Birth){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Table_name, name);
        values.put(Table_email, email);
        values.put(Table_password, password);
        values.put(Table_number, Number);
        values.put(Table_gender, gender);
        values.put(Table_birth, Birth);

        long result =  db.insert(TABLE1,null, values);
        String msg = "Adding Failed";
        if(result>0){
            msg="Adding completed";
        }
        return msg;
    }
    public String UpdateBoss(int id, String name, String email, String password, int Number, String gender, String Birth){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
     //   values.put(Table_id, id);
        values.put(Table_name, name);
        values.put(Table_email, email);
        values.put(Table_password, password);
        values.put(Table_number, Number);
        values.put(Table_gender, gender);
        values.put(Table_birth, Birth);
        String whereId =Table_id +" = ? ";
        String whereArgs [] = new String[]{String.valueOf(id)};
        long result =  db.update(TABLE1, values, whereId, whereArgs);
        String msg = "Update Failed";
        if(result>0){
            msg="Update completed";
        }
        return msg;
    }
    public String DeleteBoss(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String whereId = Table_id +" = ? ";
        String whereArgs [] = new String[]{String.valueOf(id)};
        long result = db.delete(TABLE1, whereId, whereArgs);
        String msg = "Deletion Failed";
        if(result>0){
            msg="Deletion Successfully completed";
        }
    return msg;
    }
public String GetAllBoss(){
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.query(TABLE1, null,null,null,null,null,null);
    String text="";
    while(cursor.moveToNext()){
        text+= cursor.getString(0) + ","/*cursor.getInt(0) + ","*/
        +cursor.getString(1)+ ","
        +cursor.getString(2)+ ","
        +cursor.getString(3)+ ","
        +cursor.getString(4)+ ","
                +cursor.getString(5)+ ","
        /*+cursor.getInt(6)+*/+cursor.getString(6)+ "\n";
    }
    cursor.close();
    return text;
}
public Cursor  getListBoss(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursorr = db.rawQuery("SELECT * FROM " + TABLE1, null);
return cursorr;
}
    public boolean checkBoss (String email, String password){
        String[] columns = { Table_id };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = Table_email + "=?" + " and " + Table_password + "=?";
        String selectionArgs [] = {email, password};
        Cursor cursor = db.query(TABLE1, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        if(count>0){
            return true;
        }
        else return false;
    }






    public String AddEmployee(String name, String email, String password, int Number, String gender, String Birth){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Table_name, name);
        values.put(Table_email, email);
        values.put(Table_password, password);
        values.put(Table_number, Number);
        values.put(Table_gender, gender);
        values.put(Table_birth, Birth);

        long result = db.insert(Table2,null, values);
        String msg = "Adding Failed";
        if(result>0){
            msg="Adding completed";
        }
        return msg;
    }
    public String UpdateEmployee(int id, String name, String email, String password, int Number, String gender, String Birth){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        //   values.put(Table_id, id);
        values.put(Table_name, name);
        values.put(Table_email, email);
        values.put(Table_password, password);
        values.put(Table_number, Number);
        values.put(Table_gender, gender);
        values.put(Table_birth, Birth);
        String whereId = Table_id +" = ? ";
        String whereArgs [] = new String[]{String.valueOf(id)};
        long result =  db.update(Table2, values, whereId, whereArgs);
        String msg = "Update Failed";
        if(result>0){
            msg="Update completed";
        }
        return msg;
    }
    public String UpdateEmailEmployee(String name, String email, String password, int Number, String gender, String Birth){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        //   values.put(Table_id, id);
        values.put(Table_name, name);
        values.put(Table_password, password);
        values.put(Table_number, Number);
        values.put(Table_gender, gender);
        values.put(Table_birth, Birth);
        String whereId = Table_email +" = ? ";
        String whereArgs [] = new String[]{String.valueOf(email)};
        long result =  db.update(Table2, values, whereId, whereArgs);
        String msg = "Update Failed";
        if(result>0){
            msg="Update completed";
        }
        return msg;
    }
    public String DeleteEmployee(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String whereId = Table_id +" = ? ";
        String whereArgs [] = new String[]{String.valueOf(id)};
        long result = db.delete(Table2, whereId, whereArgs);
        String msg = "Deletion Failed";
        if(result>0){
            msg="Deletion completed";
        }
        return msg;

    }
    public String GetAllEmployee(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Table2, null,null,null,null,null,null);
        String text="";
        while(cursor.moveToNext()){
            text+= cursor.getString(0) + ","/*cursor.getInt(0) + ","*/
                    +cursor.getString(1)+ ","
                    +cursor.getString(2)+ ","
                    +cursor.getString(3)+ ","
                    +cursor.getString(4)+ ","
                    +cursor.getString(5)+ ","
                    /*+cursor.getInt(6)+*/+cursor.getString(6)+ "\n";
        }
        cursor.close();
        return text;
    }
    public Cursor  getListEmployee(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursorr = db.rawQuery("SELECT * FROM " + Table2, null);
        return cursorr;
    }
    public boolean checkEmployee (String email, String password){
        String[] columns = { Table_id };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = Table_email + "=?" + " and " + Table_password + "=?";
        String selectionArgs [] = {email, password};
        Cursor cursor = db.query(Table2, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        if(count>0){
            return true;
        }
        else return false;
    }

}
