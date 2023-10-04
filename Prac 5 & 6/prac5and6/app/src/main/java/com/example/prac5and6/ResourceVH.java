package com.example.prac5and6;

import android.util.Log;
import android.view.View;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prac5and6.R;


// The purpose of this class is to hold references to the views in the list item layout.
// Essentially for each thing that is added, a View Holder instance is created to hold the unique information.

public class ResourceVH extends RecyclerView.ViewHolder
{
    public ImageView image;
    public TextView label;

    public int drawableId = 0;

    public ResourceVH(@NonNull View itemView)
    {
        super(itemView);
        image = itemView.findViewById(R.id.imageView);
        label = itemView.findViewById(R.id.textLabel);

        image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ResourceFragment rf = new ResourceFragment();
                rf.setDrawableId(drawableId);
            }
        });

        label.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ResourceFragment rf = new ResourceFragment();
                rf.setDrawableId(drawableId);
            }
        });
    }
}
