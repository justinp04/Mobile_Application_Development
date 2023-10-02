package com.example.prac5and6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    MapFragment map = new MapFragment();
    ResourceFragment resource = new ResourceFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the fragments
        loadMapFragment();
        loadResourceFragment();
    }

    private void loadMapFragment()
    {
        // To load a fragment, we must create a fragment manager to bring it in
        FragmentManager fm = getSupportFragmentManager();

        // We must then get the fragment and see if it is already loaded or not.
        Fragment frag = fm.findFragmentById(R.id.mapFragment);

        // Either add or replace it depending on it if it already loaded in the frame or not
        if(frag == null)
        {
            // If it is not there already, we must add it
            fm.beginTransaction().add(R.id.mapFragment, map).commit();
        }
        else
        {
            // If there is already a fragment there
            fm.beginTransaction().replace(R.id.mapFragment, map).commit();
        }
    }

    private void loadResourceFragment()
    {
        FragmentManager fm = getSupportFragmentManager();

        Fragment frag = fm.findFragmentById(R.id.resourceFragment);

        if(frag == null)
        {
            fm.beginTransaction().add(R.id.resourceFragment, resource).commit();
        }
        else
        {
            fm.beginTransaction().replace(R.id.resourceFragment, resource).commit();
        }
    }

}