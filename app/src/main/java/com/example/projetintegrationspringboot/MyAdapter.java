package com.example.projetintegrationspringboot;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewholder>{

    ArrayList<Datamodel>datamodels;


    public MyAdapter(ArrayList<Datamodel> datamodels) {
        this.datamodels = datamodels;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_demande_stage,parent,false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.img.setImageResource(datamodels.get(position).getImage());
        holder.t2.setText(datamodels.get(position).getNiv());
        holder.t1.setText(datamodels.get(position).getDesc());


    }

    @Override
    public int getItemCount() {
        return datamodels.size();
    }



    class myviewholder extends RecyclerView.ViewHolder{
ImageView img;
TextView t1,t2;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image);
            t1=itemView.findViewById(R.id.text1);
            t2=itemView.findViewById(R.id.text2);


        }
    }
}
