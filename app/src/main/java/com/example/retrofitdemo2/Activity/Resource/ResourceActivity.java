package com.example.retrofitdemo2.Activity.Resource;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.retrofitdemo2.Activity.Main.MainActivity;
import com.example.retrofitdemo2.Models.Resource;
import com.example.retrofitdemo2.Models.ResourceList;
import com.example.retrofitdemo2.R;
import com.example.retrofitdemo2.RestApi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResourceActivity extends AppCompatActivity {
    ResourceList resourceList;
    List<Resource> resources;
    ListView listView;
    TextView textView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);
        listView = (ListView) findViewById(R.id.resourceList);
        textView = (TextView) findViewById(R.id.resourceText);

        textView.setTextColor(Color.BLUE);
        textView.setText("Resource List : ");
        android.support.v7.widget.Toolbar toolbar = findViewById ( R.id.tool_bar );
        setSupportActionBar ( toolbar );
        toolbar.setTitleTextColor(Color.WHITE);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        resourceRequest();

    }

    void resourceRequest(){
        resourceList = new ResourceList();
        Call<ResourceList> call = ManagerAll.getIntance().ResourceList();
        call.enqueue(new Callback<ResourceList>() {
            @Override
            public void onResponse(Call<ResourceList> call, Response<ResourceList> response) {
                if (response.isSuccessful()){
                    resourceList = response.body();
                    resources = resourceList.getResource();
                    loadListView();
                }
            }

            @Override
            public void onFailure(Call<ResourceList> call, Throwable t) {

            }
        });
    }
    void loadListView(){
       MyAdapter adapter = new MyAdapter(getApplicationContext(),resources);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent geriButonu = new Intent(getApplicationContext(), MainActivity.class);
            NavUtils.navigateUpTo(this, geriButonu);
            return true;
        }
        return true;
    }
}

