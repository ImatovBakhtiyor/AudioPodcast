package com.example.audiopodcast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<ParentModelClass> parentModelClassArrayList;
ArrayList<ChildModelClass> childModelClassArrayList;
ArrayList<ChildModelClass>  recomendedForYouList;
ArrayList<ChildModelClass>  bestSellerList;
ArrayList<ChildModelClass>  newReleasesList;
ArrayList<ChildModelClass>  trendingNovList;
private  FirebaseAuth mAuth;
Intent intent;
Toolbar toolbarM;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ParentAdapter parentAdapter;
        init();
        setSupportActionBar(toolbarM);
        fillArrays();


        parentModelClassArrayList.add(new ParentModelClass("Recommended for you",recomendedForYouList));
        parentModelClassArrayList.add(new ParentModelClass("Best Seller",bestSellerList));
        parentModelClassArrayList.add(new ParentModelClass("New Releases",newReleasesList));
        parentModelClassArrayList.add(new ParentModelClass("Trending Now",trendingNovList));


        parentAdapter = new ParentAdapter(parentModelClassArrayList,HomePage.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                mAuth.signOut();
                intent = new Intent(HomePage.this,Login.class);
                startActivity(intent);
                return true;
            case R.id.deactivate:
                Toast.makeText(this,  item.getItemId(), Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void init(){
        toolbarM = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rv_parent);
        childModelClassArrayList = new ArrayList<>();
        recomendedForYouList =  new ArrayList<>();
        bestSellerList = new ArrayList<>();
        newReleasesList = new ArrayList<>();
        trendingNovList = new ArrayList<>();
        parentModelClassArrayList = new ArrayList<>();
        mAuth=FirebaseAuth.getInstance();

    }
    private void fillArrays(){
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
    }
};