package com.example.notetakingtwo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addNote, noteOne, noteTwo, noteThree, noteFour;
    int noteCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNote = findViewById(R.id.addNote);
        noteOne = findViewById(R.id.textView1);
        noteTwo = findViewById(R.id.textView2);
        noteThree = findViewById(R.id.textView3);
        noteFour = findViewById(R.id.textView4);

        // Initially set all the buttons to be invisible
        noteOne.setVisibility(View.INVISIBLE);
        noteTwo.setVisibility(View.INVISIBLE);
        noteThree.setVisibility(View.INVISIBLE);
        noteFour.setVisibility(View.INVISIBLE);

        // If there is a saved instance of the program
        if(savedInstanceState != null)
        {
            String noteOneText = savedInstanceState.getString("NOTEONE");
            String noteTwoText = savedInstanceState.getString("NOTETWO");
            String noteThreeText = savedInstanceState.getString("NOTETHREE");
            String noteFourText = savedInstanceState.getString("NOTEFOUR");
            noteCount = savedInstanceState.getInt("COUNT");

            if(noteOneText != null && noteCount >= 1)
            {
                noteOne.setVisibility(View.VISIBLE);
                noteOne.setText(noteOneText);
            }
            if(noteTwoText != null && noteCount >= 2)
            {
                noteTwo.setVisibility(View.VISIBLE);
                noteTwo.setText(noteTwoText);
            }
            if(noteThreeText != null && noteCount >= 3)
            {
                noteThree.setVisibility(View.VISIBLE);
                noteThree.setText(noteFourText);
            }
            if(noteFourText != null && noteCount == 4)
            {
                noteFour.setVisibility(View.VISIBLE);
                noteFour.setText(noteFourText);
            }
        }

        ActivityResultLauncher<Intent> detailActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK)
                    {
                        // Must retrieve the the text input by the user.
                        Intent intent = result.getData();

                        // Each time a note is added, you
                        switch(noteCount)
                        {
                            case 1:
                                // The note count will increase each time a note is added, make the note visible dependent on the number of notes.
                                noteOne.setVisibility(View.VISIBLE);
                                noteOne.setText(intent.getStringExtra("TEXT"));
                                break;
                            case 2:
                                noteTwo.setVisibility(View.VISIBLE);
                                noteTwo.setText(intent.getStringExtra("TEXT"));
                                break;
                            case 3:
                                noteThree.setVisibility(View.VISIBLE);
                                noteThree.setText(intent.getStringExtra("TEXT"));
                                break;
                            case 4:
                                noteFour.setVisibility(View.VISIBLE);
                                noteFour.setText(intent.getStringExtra("TEXT"));
                                addNote.setEnabled(false);
                                break;
                        }
                    }
                }
        );

        // updateView();

        // This what will determine what will happen when the 'addNote' button is pressed.
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //An explicit intent to specify the context class and the target class
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                if(noteCount == 4) {}
                else
                {
                    noteCount++;
                    detailActivityLauncher.launch(intent);
                }
            }
        });

        noteOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // An explicit intent to specify the context class and the target class
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("TEXT", noteOne.getText().toString());

                detailActivityLauncher.launch(intent);
            }
        });

        noteTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // An explicit intent to specify the context class and the target class
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("TEXT", noteTwo.getText().toString());

                detailActivityLauncher.launch(intent);
            }
        });

        noteThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // An explicit intent to specify the context class and the target class
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("TEXT", noteThree.getText().toString());

                detailActivityLauncher.launch(intent);
            }
        });

        noteFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // An explicit intent to specify the context class and the target class
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("TEXT", noteFour.getText().toString());

                detailActivityLauncher.launch(intent);
            }
        });
    }

    public void updateView() {
        //Get the intent of the object that started this activity
        Intent intent = getIntent();

        String noteOneText = intent.getStringExtra("NOTEONE");
        String noteTwoText = intent.getStringExtra("NOTETWO");
        String noteThreeText = intent.getStringExtra("NOTETHREE");
        String noteFourText = intent.getStringExtra("NOTEFOUR");
        int count = intent.getIntExtra("COUNT", 0);

        if (noteOneText != null && count >= 1) {
            noteOne.setVisibility(View.VISIBLE);
            noteOne.setText(noteOneText);
        }
        if (noteTwoText != null && count >= 2) {
            noteTwo.setVisibility(View.VISIBLE);
            noteTwo.setText(noteTwoText);
        }
        if (noteThreeText != null && count >= 3) {
            noteThree.setVisibility(View.VISIBLE);
            noteThree.setText(noteThreeText);
        }
        if (noteFourText != null && count == 4) {
            noteFour.setVisibility(View.VISIBLE);
            noteFour.setText(noteFourText);
        }
    }

    // The intent is how information is passed between different activities
    // Bundles just store the information
//    public static Intent getSavingStateActivityIntent(Context c, String title, Button noteOne, Button noteTwo, Button noteThree, Button noteFour, int noteCount)
//    {
//        Intent intent = new Intent(c, MainActivity.class);
//        intent.putExtra("NOTEONE", noteOne.getText().toString());
//        intent.putExtra("NOTETWO", noteTwo.getText().toString());
//        intent.putExtra("NOTETHREE", noteThree.getText().toString());
//        intent.putExtra("NOTEFOUR", noteFour.getText().toString())
//        intent.putExtra("COUNT", noteCount);
//        return intent;
//    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("NOTEONE", noteOne.getText().toString());
        outState.putString("NOTETWO", noteTwo.getText().toString());
        outState.putString("NOTETHREE", noteThree.getText().toString());
        outState.putString("NOTEFOUR", noteFour.getText().toString());
        outState.putInt("COUNT", noteCount);
    }
}