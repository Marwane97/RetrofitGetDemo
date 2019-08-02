package com.example.retrofitdemo2.Activity.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.retrofitdemo2.Models.Resource;
import com.example.retrofitdemo2.Models.ResourceList;
import com.example.retrofitdemo2.Models.User;
import com.example.retrofitdemo2.R;

import java.util.List;

public class MyAdapter extends ArrayAdapter<User> {
    List<User> modelList;
    Context context;
    int resource;
    int textId;
    public MyAdapter(Context context, List<User> modelList) {
        super(context, R.layout.list_item,modelList);
        this.modelList = modelList;
        this.context = context;
    }



    public MyAdapter(Context context, int resource, List<User> modelList, int textId) {
        super(context, resource, modelList);
        this.modelList = modelList;
        this.context = context;
        this.resource = resource;
        this.textId = textId;
    }


    /**public MyAdapter(Context context, int resource, List<ResourceList> resourceList, int textId) {
        super(context, resource, resourceList);
        this.resourceList = resourceList;
        this.context = context;
        this.resource = resource;
        this.textId = textId;
    }**/

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,null,true);
        TextView txt = view.findViewById(R.id.txt_view);
        txt.setText(modelList.get(position).toString());
        return view;
    }
}
