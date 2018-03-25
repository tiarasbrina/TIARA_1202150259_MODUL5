package com.example.tiarasabrina.tiara_1202150259_modul5;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;



public class database extends SQLiteOpenHelper {
    //deklarasi variable yang akan digunakan kelas database
    Context cntx;
    SQLiteDatabase db;
    //variable bersifat public static final
    public static final String nama_db = "listtodo.db";
    public static final String nama_tabel = "daftartodo";
    public static final String kolom_1 = "todo";
    public static final String kolom_2 = "description";
    public static final String kolom_3 = "priority";
    //kontruktor kelas
    public database(Context context) {
        super(context, nama_db, null, 1);
        this.cntx = context;
        db = this.getWritableDatabase();
        db.execSQL("create table if not exists "+nama_tabel+" (todo varchar(35) primary key, description varchar(50), priority varchar(3))");
    }
    //ketika database dibuat
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists "+nama_tabel+" (todo varchar(35) primary key, description varchar(50), priority varchar(3))");
    }
    //ketika database upgrade
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+nama_tabel);
        onCreate(sqLiteDatabase);
    }

    public boolean inputdata(AddData list) {
        //mencocokkan kolom beserta nilainya
        ContentValues values = new ContentValues();
        values.put(kolom_1, list.getTodo());
        values.put(kolom_2, list.getDesc());
        values.put(kolom_3, list.getPrior());
        long hasil = db.insert(nama_tabel, null, values);
        //kondisi
        if (hasil==-1) {
            return false;
        }else {
            return true;
        }
    }

    //method untuk menghapus data pada database
    public boolean removedata(String ToDo) {
        return db.delete(nama_tabel, kolom_1+"=\""+ToDo+"\"", null)>0;
    }
    //method untuk mengakses dan membaca data dari database
    public void readdata(ArrayList<AddData> daftar){
        Cursor crsr = this.getReadableDatabase().rawQuery("select todo, description, priority from "+nama_tabel, null);
        while (crsr.moveToNext()){
            daftar.add(new AddData(crsr.getString(0), crsr.getString(1), crsr.getString(2)));
        }
    }
}

