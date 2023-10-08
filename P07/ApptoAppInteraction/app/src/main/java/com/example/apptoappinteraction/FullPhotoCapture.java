package com.example.apptoappinteraction;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.os.BuildCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class FullPhotoCapture extends AppCompatActivity {

    File photoFile;
    Button takePhotoButton;
    ImageView photoView;

    ActivityResultLauncher<Intent> photoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    processPhotoResult(data);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_photo_capture);
        takePhotoButton = findViewById(R.id.takePhotoButton);
        photoView = findViewById(R.id.photoView);

        takePhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photoButtonClicked();
            }
        });
    }

    private void photoButtonClicked(){

        photoFile = new File(getFilesDir(),"photo.jpg");
        Uri cameraUri = FileProvider.getUriForFile(getApplicationContext(), this.getPackageName() +".fileprovider",photoFile);
        Intent photoIntent = new Intent();
        photoIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        photoIntent.putExtra(MediaStore.EXTRA_OUTPUT,cameraUri);

        PackageManager pm = getPackageManager();
        for(ResolveInfo a : pm.queryIntentActivities(
                photoIntent, PackageManager.MATCH_DEFAULT_ONLY)) {

            grantUriPermission(a.activityInfo.packageName, cameraUri,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }

        photoLauncher.launch(photoIntent);

    }
    protected void processPhotoResult(Intent data) {
            Bitmap photo = BitmapFactory.decodeFile(photoFile.toString());
            photoView.setImageBitmap(photo);
    }
}