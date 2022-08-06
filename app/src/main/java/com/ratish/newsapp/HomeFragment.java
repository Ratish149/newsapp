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

    RecyclerView homeRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homefragment,null);

        homeRecyclerView=view.findViewById(R.id.rvHomeFragment);
        modelClassArrayList = new ArrayList<>();
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        homeRecyclerView.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
        ApiClass.getApiInterface().getNews(api).enqueue(new Callback<News>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<News> call, @NonNull Response<News> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }
}
