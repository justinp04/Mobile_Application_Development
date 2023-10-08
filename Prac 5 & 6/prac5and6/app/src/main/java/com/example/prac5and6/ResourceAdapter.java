package com.example.prac5and6;

import java.util.*;

import android.content.ClipData;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

public class ResourceAdapter extends RecyclerView.Adapter<ResourceVH>
{
    // Start by referencing the data that will be scrollable.
    // For us, this data is stored in StructureData
    ArrayList<Structure> data;
    public ResourceAdapter(ArrayList<Structure> data)
    {
        this.data = data;
    }

    // The onCreateViewHolder method is responsible for giving the view holder the correct layout
    @NonNull
    @Override
    public ResourceVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.resource_list_item_layout, parent, false);

        // Creates the view holder to hold to correct view which was inflated in the previous line.
        ResourceVH myResourceVH = new ResourceVH(view);
        return myResourceVH;
    }

    /* The onBindViewHolder is responsible for taking the data from the data source and giving
    * it to the view holder to display the correct unique data */
    @Override
    public void onBindViewHolder(@NonNull ResourceVH holder, int position)
    {
        // This value is to store the single piece of data that we will be referencing.
        Structure dataValue = data.get(position);

        // Have the holder remember what image resource it uses.
        holder.drawableId = dataValue.getDrawableId();

        // Assigns the image to the ImageView
        holder.image.setImageResource(dataValue.getDrawableId());

        holder.image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                MainActivityData mainActivityData = new ViewModelProvider((AppCompatActivity) view.getContext()).get(MainActivityData.class);
                mainActivityData.setDrawableId(holder.drawableId);
            }
        });

        holder.image.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                MainActivityData mainActivityData = new ViewModelProvider((AppCompatActivity) view.getContext()).get(MainActivityData.class);
                mainActivityData.setDrawableId(holder.drawableId);

                String id = Integer.toString(holder.drawableId);

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    ClipData data = ClipData.newPlainText("drawable", id);
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDragAndDrop(data, shadowBuilder, view, 0);
                    return true;
                }
                return false;
            }
        });

        // Assigns the title of the image to the text view
        holder.label.setText(dataValue.getLabel());

        holder.label.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                MainActivityData mainActivityData = new ViewModelProvider((AppCompatActivity) view.getContext()).get(MainActivityData.class);
                mainActivityData.setDrawableId(holder.drawableId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
