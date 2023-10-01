package com.example.fragmentnote;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


// The MainActivityData which extends ViewModel is
public class MainActivityData extends ViewModel
{
    public MutableLiveData<Integer> clickedValue;
    public String title;
    public String body;

    public MainActivityData()
    {
        clickedValue = new MediatorLiveData<Integer>();
        clickedValue.setValue(0);
        title = "Add title";
        body = "Begin typing here";
    }

    public int getClickedValue()
    {
        return clickedValue.getValue();
    }
    public void setClickedValue(int num)
    {
        clickedValue.setValue(num);
    }

    public void setTitle(String title)
    {
        if(this.title != title)
        {
            this.title = title;
        }
    }

    public void setBody(String body)
    {
        if(this.body != body)
        {
            this.body = body;
        }
    }
}
