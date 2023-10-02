package com.example.fragmentnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    // Create the fragment objects
    MenuFragment menu = new MenuFragment();
    NoteFragment note = new NoteFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the menu fragment so the user can choose to add a note
        loadMenuFragment();

        // An observer to wait for certain button clicks
        MainActivityData mainActivityDataViewModel = new ViewModelProvider(this).get(MainActivityData.class);
        mainActivityDataViewModel.clickedValue.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(mainActivityDataViewModel.getClickedValue() == 0)
                {
                    loadMenuFragment();
                }
                if(mainActivityDataViewModel.getClickedValue() == 1)
                {
                    loadNoteFragment();
                }
            }
        });
    }

    private void loadMenuFragment()
    {
        // Create a fragment manager to load the fragment
        FragmentManager fm = getSupportFragmentManager();

        // Get the fragment to load
        Fragment frag = fm.findFragmentById(R.id.noteContainer1);

        // Get the orientation of the phone
        int orientation = getResources().getConfiguration().orientation;

        // If the frame container is null, then we add the instance, otherwise we replace
        if(frag == null)
        {
            fm.beginTransaction().add(R.id.noteContainer1, menu).commit();
        }
        else
        {
            fm.beginTransaction().replace(R.id.noteContainer1, menu).commit();
        }
    }

    private void loadNoteFragment()
    {
        // Create a fragment manager to load the fragment
        FragmentManager fm = getSupportFragmentManager();

        // Get the fragment to load
        Fragment frag = fm.findFragmentById(R.id.noteContainer1);
        FragmentContainer container;

        int orientation = getResources().getConfiguration().orientation;

        // If the frame container is null, then we add the instance, otherwise we replace
        if(frag == null && orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            fm.beginTransaction().add(R.id.noteContainer2, note).commit();
        }
        else if(frag != null && orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            fm.beginTransaction().replace(R.id.noteContainer2, note).commit();
        }
        else if(frag == null && orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            fm.beginTransaction().add(R.id.noteContainer1, note).commit();
        }
        else
        {
            fm.beginTransaction().replace(R.id.noteContainer1, note).commit();
        }
    }
}