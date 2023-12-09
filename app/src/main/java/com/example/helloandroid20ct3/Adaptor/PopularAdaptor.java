package com.example.helloandroid20ct3.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.helloandroid20ct3.Domain.FoodDomain;
import com.example.helloandroid20ct3.LastTest.DishActivity1;
import com.example.helloandroid20ct3.LastTest.DishActivity3;
import com.example.helloandroid20ct3.LastTest.DishActivity4;
import com.example.helloandroid20ct3.R;

import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {
    ArrayList<FoodDomain> popularFood;
    Context context;

    public PopularAdaptor(Context context, ArrayList<FoodDomain> popularFood) {
        this.context = context;
        this.popularFood = popularFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(popularFood.get(position).getTitle());
        switch (position){
            case 0:{
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent iListCategory = new Intent(context, DishActivity1.class);
                        context.startActivity(iListCategory);
                    }
                });
                break;
            }
            case 1:{
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent iListCategory = new Intent(context, DishActivity4.class);
                        context.startActivity(iListCategory);
                    }
                });
                break;
            }
            case 2:{
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent iListCategory = new Intent(context, DishActivity3.class);
                        context.startActivity(iListCategory);
                    }
                });
                break;
            }
        }

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return popularFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, detail;
        ImageView pic;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pic = itemView.findViewById(R.id.pic);
            detail = itemView.findViewById(R.id.detail);
            mainLayout = itemView.findViewById(R.id.popularLayout);
        }
    }
}
