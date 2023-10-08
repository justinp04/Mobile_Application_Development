package com.example.prac5and6;

/* The purpose of the adapter is to assign the information to the view holder*/

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MapAdapter extends RecyclerView.Adapter<MapVH>
{
    // Make a reference to the list of data that we are going to be referring to
    MapData elements;

    public MapAdapter(MapData elements){this.elements = elements;}

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
        MapVH mapVH = new MapVH(view, parent);

        return mapVH;
    }

    /* This method for the ViewHolder binds the unique information to the viewholder*/
    @Override
    public void onBindViewHolder(@NonNull MapVH holder, int position)
    {
        // Get the information to be binded
        int row = position % MapData.HEIGHT;
        int col = position / MapData.HEIGHT;

        MapElement element = elements.get(row, col);

        holder.imageNW.setImageResource(element.getNorthWest());
        holder.imageNE.setImageResource(element.getNorthEast());
        holder.imageSE.setImageResource(element.getSouthEast());
        holder.imageSW.setImageResource(element.getSouthWest());

        holder.structure.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                MainActivityData mainActivityData = new ViewModelProvider((AppCompatActivity) view.getContext()).get(MainActivityData.class);
                holder.structure.setImageResource(mainActivityData.getDrawableId());
                mainActivityData.setDrawableId(0);
            }
        });

        holder.structure.setOnDragListener(new View.OnDragListener()
        {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent)
            {
                MainActivityData mainActivityData = new ViewModelProvider((AppCompatActivity) view.getContext()).get(MainActivityData.class);
                int action = dragEvent.getAction();

                switch(action)
                {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        View v = (View) dragEvent.getLocalState();
                        ViewGroup owner = (ViewGroup) view.getParent();

                        owner.removeView(view);

                        ClipData.Item item = dragEvent.getClipData().getItemAt(0);

                        holder.structure.setImageResource(Integer.parseInt(item.getText().toString()));
                        mainActivityData.setDrawableId(0);

                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return elements.HEIGHT * elements.WIDTH;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public int getItemViewType(int position)
    {
        return position;
    }
}
