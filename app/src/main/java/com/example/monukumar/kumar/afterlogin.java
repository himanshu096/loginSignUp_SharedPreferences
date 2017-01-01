package com.example.monukumar.kumar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class afterlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterlogin);
        Intent i=getIntent();

        String message = i.getStringExtra("details");
        TextView textView = (TextView)findViewById(R.id.tv);
        textView.setTextSize(40);
        textView.setText(message);

    }
}
