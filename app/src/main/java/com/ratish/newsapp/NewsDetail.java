package com.ratish.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewsDetail extends AppCompatActivity {
    TextView title,tvAuthor,tvPublished,tvContent;
    ImageView imageView;
    ImageButton backBtn;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title=findViewById(R.id.title);
        tvAuthor=findViewById(R.id.tvAuthor);
        tvPublished=findViewById(R.id.tvPublished);
        tvContent=findViewById(R.id.tvContent);
        imageView=findViewById(R.id.imageView);
        backBtn=findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        intent  = getIntent();
        String nTitle = intent.getStringExtra("title");
        String nAuthor= intent.getStringExtra("author");
        String nDescription= intent.getStringExtra("description");
        String nPublished= intent.getStringExtra("published");

        Glide.with(this).load(intent.getStringExtra("image")).into(imageView);




        title.setText(nTitle);
        tvAuthor.setText(nAuthor);
        tvContent.setText(nDescription);
        tvPublished.setText("Published At: "+nPublished);

    }
}