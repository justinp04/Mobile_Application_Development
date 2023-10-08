package com.example.apptoappinteraction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button call = findViewById(R.id.callButton);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callButtonClicked();
            }
        });

        Button viewMap = findViewById(R.id.viewMap);

        viewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMapButtonClicked();
            }
        });

        Button sendText = findViewById(R.id.sendText);

        sendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTextButtonClicked();
            }
        });

        Button sendEmail = findViewById(R.id.sendEmail);

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmailButtonClicked();
            }
        });

        Button viewWeb = findViewById(R.id.viewWeb);

        viewWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewWebButtonClicked();
            }
        });

        Button thumbNailActivity = findViewById(R.id.thumbNailActivity);
        thumbNailActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThumbNailCapture.class);
                startActivity(intent);
            }
        });

        Button pickContactActivity = findViewById(R.id.contactActivity);
        pickContactActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PickContact.class);
                startActivity(intent);
            }
        });

        Button photoContactActivity = findViewById(R.id.photoActivity);
        photoContactActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FullPhotoCapture.class);
                startActivity(intent);
            }
        });
    }

    private void callButtonClicked(){
        int phone = 1234567;
        Uri uri = Uri.parse(String.format("tel:%d", phone));
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);

    }

    private void viewMapButtonClicked(){
        double latitude = -31.95;
        double longitute = 115.86;
        Uri uri = Uri.parse(String.format("geo:%f,%f", latitude, longitute));
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);
    }

    private void sendTextButtonClicked(){
        int phone = 1234567;
        String smsText = "Hello this is the test text";
        Uri uri = Uri.parse(String.format("smsto:%d", phone));

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(uri);
        intent.putExtra("sms_body", smsText);
        startActivity(intent);
    }

    private void sendEmailButtonClicked(){
        String [] mailto = {"abc@gmail.com"};
        String subject = "Test";
        String mailbody = "We are testing our email";
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL,mailto);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, mailbody);
        startActivity(intent);

    }

    private void viewWebButtonClicked(){
        String url = "http://curtin.edu.au";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(uri);

        PackageManager pm = getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent,0);
        if(resolveInfo!=null)
        {
            Log.d("Name", resolveInfo.activityInfo.packageName);
            startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this,
                    "No suitbale package found", Toast.LENGTH_LONG).show();
        }

    }

}