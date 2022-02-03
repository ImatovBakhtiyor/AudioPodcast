package com.example.audiopodcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<ParentModelClass> parentModelClassArrayList;
ArrayList<ChildModelClass> childModelClassArrayList;
ArrayList<ChildModelClass>  recomendedForYouList;
ArrayList<ChildModelClass>  bestSellerList;
ArrayList<ChildModelClass>  newReleasesList;
    ArrayList<ChildModelClass>  trendingNovList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.rv_parent);
        childModelClassArrayList = new ArrayList<>();
        recomendedForYouList =  new ArrayList<>();
        bestSellerList = new ArrayList<>();
        newReleasesList = new ArrayList<>();
        trendingNovList = new ArrayList<>();
        parentModelClassArrayList = new ArrayList<>();
        ParentAdapter parentAdapter;

        bestSellerList.add(new ChildModelClass(R.drawable.instantbook));
        bestSellerList.add(new ChildModelClass(R.drawable.koreanbook));
        bestSellerList.add(new ChildModelClass(R.drawable.lovecontentbook));
        bestSellerList.add(new ChildModelClass(R.drawable.koreanbook));

        recomendedForYouList.add(new ChildModelClass(R.drawable.one));
        recomendedForYouList.add(new ChildModelClass(R.drawable.two));
        recomendedForYouList.add(new ChildModelClass(R.drawable.three));
        recomendedForYouList.add(new ChildModelClass(R.drawable.instantbook));

        newReleasesList.add(new ChildModelClass(R.drawable.four));
        newReleasesList.add(new ChildModelClass(R.drawable.five));
        newReleasesList.add(new ChildModelClass(R.drawable.six));
        newReleasesList.add(new ChildModelClass(R.drawable.one));

        trendingNovList.add(new ChildModelClass(R.drawable.seven));
        trendingNovList.add(new ChildModelClass(R.drawable.instantbook));
        trendingNovList.add(new ChildModelClass(R.drawable.koreanbook));
        trendingNovList.add(new ChildModelClass(R.drawable.five));


        parentModelClassArrayList.add(new ParentModelClass("Recommended for you",recomendedForYouList));
        parentModelClassArrayList.add(new ParentModelClass("Best Seller",bestSellerList));
        parentModelClassArrayList.add(new ParentModelClass("New Releases",newReleasesList));
        parentModelClassArrayList.add(new ParentModelClass("Trending Now",trendingNovList));


        parentAdapter = new ParentAdapter(parentModelClassArrayList,HomePage.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();
    }
};