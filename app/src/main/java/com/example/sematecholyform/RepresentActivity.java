package com.example.sematecholyform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RepresentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_represent);
        Intent returnIntent = getIntent();
        String myName = returnIntent.getStringExtra("name");
        String myFamily = returnIntent.getStringExtra("family");
        String myMail = returnIntent.getStringExtra("mail");
        String myAge = returnIntent.getStringExtra("age");
        final TextView txtShowName = findViewById(R.id.txtShowName);
        txtShowName.setText(myName);
        final TextView txtFamily =findViewById(R.id.txtFamily);
        txtFamily.setText(myFamily);
        final TextView txtEmail = findViewById(R.id.txtEmail);
        txtEmail.setText(myMail);
        final TextView txtAge = findViewById(R.id.txtAge);
        txtAge.setText(myAge);
        Button btnOk = findViewById(R.id.btnOk);
        Button btnEdit = findViewById(R.id.btnEdit);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("n", txtShowName.getText().toString());
                i.putExtra("f", txtFamily.getText().toString());
                i.putExtra("m", txtEmail.getText().toString());
                i.putExtra("a", txtAge.getText().toString());
                PreferenceManager.getDefaultSharedPreferences(RepresentActivity.this).edit().putString("n",txtShowName.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(RepresentActivity.this).edit().putString("f",txtFamily.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(RepresentActivity.this).edit().putString("m",txtEmail.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(RepresentActivity.this).edit().putString("a",txtAge.getText().toString()).apply();
                setResult(Activity.RESULT_OK,i);
                finish();

            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("n",txtShowName.getText().toString());
                i.putExtra("f",txtFamily.getText().toString());
                i.putExtra("m",txtEmail.getText().toString());
                i.putExtra("a",txtAge.getText().toString());
                finish();

            }
        });
    }
}
