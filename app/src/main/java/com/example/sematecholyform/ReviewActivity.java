package com.example.sematecholyform;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        final EditText edtName = findViewById(R.id.edtName);
        final EditText edtFamily = findViewById(R.id.edtFamily);
        final EditText edtMail = findViewById(R.id.edtMail);
        final EditText edtAge = findViewById(R.id.edtAge);
        Button btnReview = findViewById(R.id.btnReview);
        String defaultName = PreferenceManager.getDefaultSharedPreferences(ReviewActivity.this).getString("n",edtName.getText().toString());
        String defaultFamily = PreferenceManager.getDefaultSharedPreferences(ReviewActivity.this).getString("f",edtFamily.getText().toString());
        String defaultMail =PreferenceManager.getDefaultSharedPreferences(ReviewActivity.this).getString("m",edtMail.getText().toString());
        String defaultAge =PreferenceManager.getDefaultSharedPreferences(ReviewActivity.this).getString("a",edtAge.getText().toString());
        edtName.setText(defaultName);
        edtFamily.setText(defaultFamily);
        edtMail.setText(defaultMail);
        edtAge.setText(defaultAge);
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewActivity.this,RepresentActivity.class);
                String username = edtName.getText().toString();
                String lastName = edtFamily.getText().toString();
                String userMail = edtMail.getText().toString();
                String userAge = edtAge.getText().toString();
                intent.putExtra("name",username);
                intent.putExtra("family",lastName);
                intent.putExtra("mail",userMail);
                intent.putExtra("age",userAge);
                startActivityForResult(intent,500);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 500){
            if(resultCode == Activity.RESULT_OK){
                String n = data.getStringExtra("n");
                final EditText edtName = findViewById(R.id.edtName);
                edtName.setText(n);
                String r = data.getStringExtra("f");
                final EditText edtFamily = findViewById(R.id.edtFamily);
                edtFamily.setText(r);
                String m = data.getStringExtra("m");
                final EditText edtMail = findViewById(R.id.edtMail);
                edtMail.setText(m);
                String a = data.getStringExtra("m");
                final EditText edtAge = findViewById(R.id.edtAge);
                edtAge.setText(a);
                Toast.makeText(ReviewActivity.this,"Everything is done successfully!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
