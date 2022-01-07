package com.example.projetintegrationspringboot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterOffreStage extends RecyclerView.Adapter<AdapterOffreStage.myviewholder> {

    ArrayList<Offremodel> datamodels;
    private final Context ct;

    public AdapterOffreStage(ArrayList<Offremodel> datamodels, Context ct) {
        this.datamodels = datamodels;
        this.ct = ct;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_offre_stage, parent, false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        String a = datamodels.get(position).getImage();
        Picasso.with(ct).load(a).into(holder.img);

        holder.t1.setText(datamodels.get(position).getTitle());
        holder.t2.setText(datamodels.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return datamodels.size();
    }


    class myviewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView t1, t2;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);


        }
    }
}
