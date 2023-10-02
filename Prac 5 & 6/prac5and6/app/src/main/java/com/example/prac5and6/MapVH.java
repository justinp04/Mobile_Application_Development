package com.example.prac5and6;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// The purpose of the ViewHolder class is to be the frame that holds the unique data for each unique entry
// in the list of items in RecyclerView

public class MapVH extends RecyclerView.ViewHolder
{
    public ImageView imageNW;
    public ImageView imageNE;
    public ImageView imageSE;
    public ImageView imageSW;

    public MapVH(@NonNull View itemView)
    {
        super(itemView);
        imageNW = itemView.findViewById(R.id.elementNW);
        imageNE = itemView.findViewById(R.id.elementNE);
        imageSE = itemView.findViewById(R.id.elementSE);
        imageSW = itemView.findViewById(R.id.elementSW);
    }
}
