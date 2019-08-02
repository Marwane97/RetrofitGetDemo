package com.example.retrofitdemo2.Activity.Resource;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.retrofitdemo2.Models.Resource;
import com.example.retrofitdemo2.R;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Resource> {
    List<Resource> resources;
    Context context;
    public MyAdapter(Context context, List<Resource> resources) {
        super(context, R.layout.list_item2, resources);
        this.context = context;
        this.resources = resources;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item2,null,true);
        TextView txt = view.findViewById(R.id.txt_resource);
        txt.setText(resources.get(position).toString());
        return view;
    }
}
