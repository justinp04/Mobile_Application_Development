package com.example.prac5and6.resource;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prac5and6.R;


// The purpose of this class is to hold references to the views in the list item layout.
// Essentially for each thing that is added, a View Holder instance is created to hold the unique information.

public class ResourceVH extends RecyclerView.ViewHolder
{
    public ImageView image;
    public TextView label;

    public ResourceVH(@NonNull View itemView)
    {
        super(itemView);
        image = itemView.findViewById(R.id.imageView);
        label = itemView.findViewById(R.id.textLabel);
    }
}
