package com.example.notetakingtwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout/window to display the xml file 'activity_detail' instead of main
        setContentView(R.layout.activity_detail);

        // Reference the button where we are going to be adding text
        TextView noteText = findViewById(R.id.noteText);
        Button saveNote = findViewById(R.id.saveNote);

        Intent intent = getIntent();

        if(intent.getStringExtra("TEXT") != null)
        {
            noteText.setText(intent.getStringExtra("TEXT"));
        }

        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to send back data
                Intent intent = new Intent();
                intent.putExtra("TEXT", noteText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}

