package com.example.loginpage;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UrunlerAdapter extends RecyclerView.Adapter<UrunlerAdapter.UrunlerHolder> {

    private ArrayList<Urunler> urunlerList;

    public UrunlerAdapter(ArrayList<Urunler> urunlerList, Context context) {
        this.urunlerList = urunlerList;
        this.context = context;
    }

    private Context context;

    @NonNull
    @Override
    public UrunlerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.urunler,parent,false);
        return new UrunlerHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UrunlerHolder holder, int position) {
        Urunler urunler = urunlerList.get(position);
        holder.setData(urunler);

    }

    @Override
    public int getItemCount() {
        return urunlerList.size();
    }

    class UrunlerHolder extends RecyclerView.ViewHolder{

        TextView urunIsmi,urunAciklamasi;
        ImageView urunResim;


        public UrunlerHolder(@NonNull View itemView) {
            super(itemView);
            urunIsmi=(TextView)itemView.findViewById(R.id.text_UrunAdi);
            urunAciklamasi=(TextView)itemView.findViewById(R.id.text_UrunAciklamasi);
            urunResim=(ImageView)itemView.findViewById(R.id.urunler_ImageView);
        }

        public void setData(Urunler urunler){
            this.urunIsmi.setText(urunler.getUrunIsmi());
            this.urunAciklamasi.setText(urunler.getUrunAciklamasi());
            this.urunResim.setBackgroundResource(urunler.getUrunResim());
        }
    }



}
