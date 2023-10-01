package com.example.recycleviewdemo;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyDataVHAdv extends RecyclerView.ViewHolder{
    public TextView nameTextBox;
    public Button callButton;
    public MyDataVHAdv(@NonNull View itemView, ViewGroup parent) {
        super(itemView);
        int hSize = parent.getMeasuredHeight() /3;
        //int wSize = parent.getMeasuredWidth()/2;
        ViewGroup.LayoutParams lp = itemView.getLayoutParams();
        lp.height = hSize;
        //lp.width = wSize;
        nameTextBox = itemView.findViewById(R.id.textView);
        callButton = itemView.findViewById(R.id.button);
    }
}

