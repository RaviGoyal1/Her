package com.raviandroid.she;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    EditText name;
    EditText number;
    ImageButton save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name=findViewById(R.id.callname);
        number=findViewById(R.id.callnumber);
        save=findViewById(R.id.save);
        SharedPreferences sharedPref = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String num=number.getText().toString();
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("Name",n);
                editor.putString("Phone",num);
                editor.apply();
                Toast.makeText(getApplicationContext(),"Details Saved Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}