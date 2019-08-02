package com.example.retrofitdemo2.Activity.Main;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.retrofitdemo2.Activity.Resource.ResourceActivity;
import com.example.retrofitdemo2.Models.Resource;
import com.example.retrofitdemo2.Models.User;
import com.example.retrofitdemo2.Models.UserList;
import com.example.retrofitdemo2.R;
import com.example.retrofitdemo2.RestApi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    UserList userList ;
    ListView listView;
    int randValue;
    TextView txt;
    List<User> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);;
        txt = (TextView) findViewById(R.id.textId);
        txt.setTextColor(Color.BLUE);
        randValue = (int)(Math.random() * 3 + 1);
        getRequest(randValue);

        toolbar.setTitle("Users List");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.resourceItem){
            Intent intent = new Intent(getApplicationContext(), ResourceActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void getRequest(final int value) {
        userList = new UserList();
        Call<UserList> call = ManagerAll.getIntance().UsersList(value);
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                if(response.isSuccessful()){
                    userList = response.body();
                    user =  userList.getUser();
                    MyAdapter adapter = new MyAdapter(getApplicationContext(),user);
                    listView.setAdapter(adapter);
                    setPageString(value);
                }
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

            }
        });
    }
    void setPageString(int value){
      switch (value){
          case 1: txt.setText("Users from the first page : ");
                 break;
          case 2: txt.setText("Users from the second page : ");
                 break;
          case 3: txt.setText("Users from the third page :");
                 break;
          case 4: txt.setText("Users from the fourth page :");
                 break;

      }
    }
}
