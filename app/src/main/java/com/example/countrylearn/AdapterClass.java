package com.example.countrylearn;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countrylearn.databinding.GorunumBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.RecylerAdapter> {
ArrayList<CountryConteyner> countryConteynerArrayList;
String [] color = {"#D8D8F6","#1e81b0","#44bcd8","#edb879"};

    public AdapterClass(ArrayList<CountryConteyner> countryConteynerArrayList) {
        this.countryConteynerArrayList = countryConteynerArrayList;
    }

    @NonNull
    @Override
    public RecylerAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GorunumBinding binding = GorunumBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RecylerAdapter(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerAdapter holder, int position) {
        holder.binding.backs.setBackgroundColor(Color.parseColor(color[position% color.length]));
        Picasso.get().load(countryConteynerArrayList.get(position).flag).into(holder.binding.flag1, new Callback() {
            @Override
            public void onSuccess() {
                holder.binding.progressbar.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onError(Exception e) {

            }
        });
        holder.binding.name1.setText("Ölkə : " + countryConteynerArrayList.get(position).name);
        holder.binding.capital1.setText("Paytaxt : " +countryConteynerArrayList.get(position).capital);
        holder.binding.currency1.setText("Valyuta : " +countryConteynerArrayList.get(position).currency);
        holder.binding.region1.setText("Region : " +countryConteynerArrayList.get(position).region);
        holder.binding.language1.setText("Dil : " +countryConteynerArrayList.get(position).language);
    }

    @Override
    public int getItemCount() {
        return countryConteynerArrayList.size();
    }

    public class RecylerAdapter extends RecyclerView.ViewHolder{
        GorunumBinding binding;
        public RecylerAdapter(GorunumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
