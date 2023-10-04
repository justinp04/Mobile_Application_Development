package com.example.prac5and6;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

// The purpose of this class is to store information regarding the map and structures
public class MainActivityData extends ViewModel
{
    // Reference to drawable id
    public MutableLiveData<Integer> drawableId = new MutableLiveData<>();

    public MainActivityData()
    {
        drawableId = new MediatorLiveData<Integer>();
        drawableId.setValue(0);
    }

    public void setDrawableId(int drawableId)
    {
        this.drawableId.setValue(drawableId);
    }

    public int getDrawableId()
    {
        return drawableId.getValue();
    }
}
