package com.example.tiarasabrina.tiara_1202150259_modul5;


public class AddData {
    //deklarasi variable yang akan digunakan
    String todo, desc, prior;

    //konstruktor kelas
    public AddData(String todo, String desc, String prior) {
        this.todo = todo;
        this.desc = desc;
        this.prior = prior;
    }

    //method setter dan getter untuk to do
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    //method setter dan getter untuk desc
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    //method setter dan getter untuk prior
    public String getPrior() {
        return prior;
    }

    public void setPrior(String prior) {
        this.prior = prior;
    }
}


