package com.example.tiarasabrina.tiara_1202150259_modul5;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;



public class adapter extends RecyclerView.Adapter<adapter.holder> {
    private Context ctx; //deklarasi variable untuk view context
    private List<AddData> lst; //deklarasi variable untuk view List<AddData>
    int clr; //deklarasi variable untuk color

    //konstruktor
    public adapter(Context cntx, List<AddData> list, int color){
        this.ctx=cntx;
        this.lst=list;
        this.clr=color;
    }

    //menentukan viewholder untuk recyclerview
    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //membuat view baru
        View view = LayoutInflater.from(ctx).inflate(R.layout.cardview_list, parent, false);
        holder hldr = new holder(view);
        return hldr;
    }

    //menyetting nilai yang didapatkan pada viewholder
    @Override
    public void onBindViewHolder(holder holder, int position) {
        AddData data = lst.get(position);
        holder.ToDo.setText(data.getTodo()); //setting nilai dari To Do
        holder.Description.setText(data.getDesc()); //setting nilai dari Description
        holder.Priority.setText(data.getPrior()); //setting nilai dari Priority
        holder.cardv.setCardBackgroundColor(ctx.getResources().getColor(this.clr));
    }

    //mendapatkan jumlah list
    @Override
    public int getItemCount() {
        return lst.size();
    }
    //mendapatkan list dari adapter
    public AddData getData(int position){
        return lst.get(position);
    }
    //untuk menghapus list pada todolist
    public void deleteData(int i){
        //remove item yang terpilih
        lst.remove(i);
        //memberi notifikasi item yang di remove
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, lst.size());
    }
    class holder extends RecyclerView.ViewHolder{
        //deklarasi variable yang akan digunakan
        public TextView ToDo, Description, Priority;
        public CardView cardv;
        public holder(View itemView){
            super(itemView);
            //mengakses id text view pada layout dan juga cardview
            ToDo = itemView.findViewById(R.id.headline); //akses id headline dan simpan nilai ke variable
            Description = itemView.findViewById(R.id.explanation); //akses id explanation dan simpan nilai ke variable
            Priority = itemView.findViewById(R.id.number); //akses id number dan simpan nilai ke variable
            cardv = itemView.findViewById(R.id.cardlist); //akses id cardlist dan simpan nilai ke variable
        }
    }
}