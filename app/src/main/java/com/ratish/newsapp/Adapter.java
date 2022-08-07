package com.ratish.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<NewsModelClass> modelClassArrayList;

    public Adapter(Context context, ArrayList<NewsModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.itemLayout_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsDetail.class);
                intent.putExtra("title", modelClassArrayList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("description", modelClassArrayList.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("author", modelClassArrayList.get(holder.getAdapterPosition()).getAuthor());
                intent.putExtra("image", modelClassArrayList.get(holder.getAdapterPosition()).getUrlToImage());
                intent.putExtra("published", modelClassArrayList.get(holder.getAdapterPosition()).getPublishedAt());

                intent.putExtra("url", modelClassArrayList.get(holder.getAdapterPosition()).getUrl());
                context.startActivity(intent);


            }
        });
        holder.newsTitle.setText(modelClassArrayList.get(position).getTitle());
        holder.newsContent.setText(modelClassArrayList.get(position).getDescription());
        holder.newsAuthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.newsPublishedTime.setText("Published At: " + modelClassArrayList.get(position).getPublishedAt());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.newsImage);


    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle, newsContent, newsAuthor, newsPublishedTime;
        ImageView newsImage;
        CardView itemLayout_CardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsContent = itemView.findViewById(R.id.newsContent);
            newsAuthor = itemView.findViewById(R.id.newsAuthor);
            newsPublishedTime = itemView.findViewById(R.id.newsPublishedTime);
            newsImage = itemView.findViewById(R.id.newsImage);
            itemLayout_CardView = itemView.findViewById(R.id.itemLayout_CardView);

        }
    }
}
