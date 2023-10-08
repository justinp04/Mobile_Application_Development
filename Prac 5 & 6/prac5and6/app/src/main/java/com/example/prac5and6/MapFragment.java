package com.example.prac5and6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // A reference to the resource fragment
    public ResourceFragment resourceFragment;

    public int drawable;

    MapData data = MapData.get();

    public MapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment map.
     */
    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance(String param1, String param2)
    {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        MainActivityData mainActivityData = new ViewModelProvider(getActivity()).get(MainActivityData.class);

        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setStructure(mainActivityData);
                Log.d("ONCLICK", "ONLICK has been called");
            }
        });

        // Observe changes to drawableId
        mainActivityData.drawableId.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer drawableId) {
                // Handle the updated drawableId here
                drawable = drawableId;
                Log.d("MAPFRAG", "" + drawableId);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<MapElement> list = new ArrayList<>();

        // Get the information to be stored.

        for(int i = 0; i < data.HEIGHT; i++)
        {
            for(int j = 0; j < data.WIDTH; j++)
            {
                list.add(MapData.get(i ,j));
            }
        }

        // Make a reference to the RecyclerView
        RecyclerView rv = view.findViewById(R.id.mapRecycler);

        // Set the layout manager
        rv.setLayoutManager(new GridLayoutManager(getActivity(), MapData.HEIGHT, GridLayoutManager.HORIZONTAL,false));

        MapAdapter adapter = new MapAdapter(data);
        rv.setAdapter(adapter);
    }

    // Mutator to set the resource fragment
    public void setResourceFragment(Fragment resourceFragment)
    {
        this.resourceFragment = (ResourceFragment)resourceFragment;
    }

    public void setStructure(MainActivityData mainActivityData)
    {
        drawable = mainActivityData.getDrawableId();
        Log.d("MAPFRAG", "" + resourceFragment.getDrawableId());
    }


    public int getStructure()
    {
        drawable = resourceFragment.getDrawableId();
//        Log.d("MAPFRAG", "" + resourceFragment.getDrawableId());
        return drawable;
    }
}