package com.ratish.newsapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    String api="6bf2e4eef2a0478cb4e5b8440f01b75e";
    ArrayList<NewsModelClass> modelClassArrayList;
    Adapter adapter;

    String q = "apple";
    RecyclerView homeRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homefragment,null);

        homeRecyclerView=view.findViewById(R.id.rvHomeFragment);
        modelClassArrayList = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        homeRecyclerView.setLayoutManager(manager);
        homeRecyclerView.setHasFixedSize(true);
        adapter = new Adapter(getContext(),modelClassArrayList);
        homeRecyclerView.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
        ApiClass.getApiInterface().getNews(q,api).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });


    }
}
