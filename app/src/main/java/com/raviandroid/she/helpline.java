package com.raviandroid.she;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class helpline extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    Button womenHelpline;
    Button police;
    Button wid;
    Button Ambulance;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpline);

        womenHelpline = findViewById(R.id.womenHelpine);
        womenHelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callWomenHelpline();
            }
        });

        police = findViewById(R.id.police);
        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPolice();
            }
        });

        wid = findViewById(R.id.wid);
        wid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callWid();
            }
        });

        Ambulance = findViewById(R.id.Ambulance);
        Ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callAmbulance();
            }
        });
    }


    private void callWomenHelpline() {
        String number = "181";
        if (ContextCompat.checkSelfPermission(helpline.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(helpline.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            String dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

    private void callPolice(){
        String number = "100";
        if (ContextCompat.checkSelfPermission(helpline.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(helpline.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            String dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

    private void callWid() {
        String number = "1091";
        if (ContextCompat.checkSelfPermission(helpline.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(helpline.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            String dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

    private void callAmbulance() {
        String number = "108";
        if (ContextCompat.checkSelfPermission(helpline.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(helpline.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            String dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callWomenHelpline();
                callPolice();
                callWid();
                callAmbulance();
            } else {
                Toast.makeText(this, "permission DENIED", Toast.LENGTH_SHORT).show();
            }

        }
    }






}

