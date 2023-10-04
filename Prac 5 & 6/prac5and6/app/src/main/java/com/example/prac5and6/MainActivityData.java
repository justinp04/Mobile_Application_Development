package com.example.prac5and6;

import androidx.lifecycle.ViewModel;

// The purpose of this class is to store information regarding the map and structures
public class MainActivityData extends ViewModel
{
    // Reference to drawable id
    public int drawableId;

    public MainActivityData()
    {
        drawableId = 0;
    }

    public void setDrawableId(int drawableId)
    {
        this.drawableId = drawableId;
    }

    public int getDrawableId()
    {
        return drawableId;
    }
}
