package com.example.sematecholyform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        Button btnDialNumber = findViewById(R.id.btnDialNumber);

        btnDialNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
                final String phoneNumber = edtPhoneNumber.getText().toString();
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" +phoneNumber));
                startActivity(i);
            }
        });
    }
}
