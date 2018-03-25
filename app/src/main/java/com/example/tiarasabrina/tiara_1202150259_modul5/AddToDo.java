package com.example.tiarasabrina.tiara_1202150259_modul5;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDo extends AppCompatActivity {

    //deklarasi variable yang akan digunakan kelas AddToDo
    EditText todo, desc, prior;
    database db;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do); //atur content view dari kelas
        //set title menjadi add to do
        setTitle("Add To Do");
        //mengakses id edit text pada layout
        todo = (EditText) findViewById(R.id.editTodo);
        desc = (EditText) findViewById(R.id.editDesc);
        prior = (EditText) findViewById(R.id.editPriority);
        db = new database(this);
    }

    @Override

    public void onBackPressed() {
        //intent dari add to do menuju list to do
        Intent intent = new Intent(AddToDo.this, ListToDo.class);
        //memulai intent
        startActivity(intent);
        //menutup aktivitas setelah intent dijalankan
        this.finish();
    }

    //method yang dijalanan ketika tombol tambah to do di klik
    public void tambah(View view) {
        //apabila data todoname, deskripsi dan prioritas di isi,
        if (db.inputdata(new AddData(todo.getText().toString(), desc.getText().toString(), prior.getText().toString()))){
            //maka akan menampilkan toast bawha data berhasil di tambahkan ke dalam list
            Toast.makeText(this, "To Do List added!", Toast.LENGTH_SHORT).show();
            //berpindah dari add to do ke list to do
            startActivity(new Intent(AddToDo.this, ListToDo.class));
            //menutup aktivitas agar tidak kembali ke activity yang dijalankan setelah intent
            this.finish();
        }else {
            //apabila edit text kosong maka akan muncul toast bahwa tidak bisa menambah ke dalam list
            Toast.makeText(this, "Cannot add the list", Toast.LENGTH_SHORT).show();
            todo.setText(null); //set null pada variable to do
            desc.setText(null); //set null pada variable desc
            prior.setText(null); //set null pada variable prior
        }
    }
}