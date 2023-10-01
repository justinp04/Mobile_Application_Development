package com.example.singleactivitymuliplefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    AuFragment auFragment = new AuFragment();
    EuFragment euFragment = new EuFragment();

    MenuFragment menuFragment = new MenuFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadMenuFragment();
        MainActivityData mainActivityDataViewModel = new ViewModelProvider(this)
                .get(MainActivityData.class);
        mainActivityDataViewModel.clickedValue.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(mainActivityDataViewModel.getClickedValue()==1){
                    loadAuFragment();
                }
                if(mainActivityDataViewModel.getClickedValue()==2){
                    loadEuFragment();
                }

            }
        });
        /*
        Button auButton = menuFragment.getAuButton();
        Button euButton = menuFragment.getEuButton();
        auButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAuFragment();
            }
        });
        euButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadEuFragment();
            }
        });*/
    }

    private void loadMenuFragment(){
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.menu_container);
        if(frag==null){
            fm.beginTransaction().add(R.id.menu_container,menuFragment).commit();
        }
    }
    private void loadAuFragment(){
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.f_container);
        if(frag==null){
            fm.beginTransaction().add(R.id.f_container,auFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.f_container,auFragment).commit();
        }
    }
    private void loadEuFragment(){
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.f_container);
        if(frag==null){
            fm.beginTransaction().add(R.id.f_container,euFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.f_container,euFragment).commit();
        }
    }
}