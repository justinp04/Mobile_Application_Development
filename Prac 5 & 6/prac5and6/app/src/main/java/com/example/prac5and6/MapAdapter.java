package com.example.prac5and6;

/* The purpose of the adapter is to assign the information to the view holder*/

import java.util.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MapAdapter extends RecyclerView.Adapter<MapVH>
{
    // Make a reference to the list of data that we are going to be referring to
    ArrayList<MapElement> elements;

    public MapAdapter(ArrayList<MapElement> elements){this.elements = elements;}

    @NonNull
    @Override
    public MapVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // First we must inflate the list item view to be used.
        // Create an inflater to action this
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Assign the correct view using the inflater
        View view = inflater.inflate(R.layout.map_list_item_layout, parent, false);

        // Create an instance of a viewholder and have
        MapVH mapVH = new MapVH(view);

        return mapVH;
    }

    /* This method for the ViewHolder binds the unique information to the viewholder*/
    @Override
    public void onBindViewHolder(@NonNull MapVH holder, int position)
    {
        // Get the information to be binded
        MapElement element = elements.get(position);

        holder.imageNW.setImageResource(element.getNorthWest());
        holder.imageNE.setImageResource(element.getNorthEast());
        holder.imageSE.setImageResource(element.getSouthEast());
        holder.imageSW.setImageResource(element.getSouthWest());

        // Place structure if an element has been built on the grid
        if(element.getStructure() != null)
        {

        }
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }
}
