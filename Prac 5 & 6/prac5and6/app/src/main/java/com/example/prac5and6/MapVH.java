package com.example.prac5and6;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prac5and6.R;

// The purpose of the ViewHolder class is to be the frame that holds the unique data for each unique entry
// in the list of items in RecyclerView

public class MapVH extends RecyclerView.ViewHolder
{
    public ImageView imageNW;
    public ImageView imageNE;
    public ImageView imageSE;
    public ImageView imageSW;
    public ImageView structure;

    public MapVH(@NonNull View itemView, ViewGroup parent)
    {
        super(itemView);
        imageNW = itemView.findViewById(R.id.elementNW);
        imageNE = itemView.findViewById(R.id.elementNE);
        imageSE = itemView.findViewById(R.id.elementSE);
        imageSW = itemView.findViewById(R.id.elementSW);
        structure = itemView.findViewById(R.id.structure);

        int size = parent.getMeasuredHeight() / MapData.HEIGHT + 1;
        ViewGroup.LayoutParams lp = itemView.getLayoutParams();
        lp.width = size;
        lp.height = size;

    }
}
