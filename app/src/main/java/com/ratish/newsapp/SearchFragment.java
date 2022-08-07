package com.ratish.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment{

    String api="6bf2e4eef2a0478cb4e5b8440f01b75e";
    ArrayList<NewsModelClass> modelClassArrayList;
    Adapter adapter;
    SearchView searchView;
    RecyclerView searchRecyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.searchfragment,null);
        searchView = view.findViewById(R.id.searchView);
        searchRecyclerView=view.findViewById(R.id.rvSearchFragment);
        modelClassArrayList = new ArrayList<>();
        searchRecyclerView.removeView(view);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);


        searchRecyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                findNews(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return view;

    }
    private void findNews(String query) {

        ApiClass.getApiInterface().getQueryNews(query,api).enqueue(new Callback<News>() {
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
