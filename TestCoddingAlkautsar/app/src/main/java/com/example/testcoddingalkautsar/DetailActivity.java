package com.example.testcoddingalkautsar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView gridData;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        gridData = findViewById(R.id.griddata);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);

        System.out.println("NAMA = "+receivedName);

        gridData.setText(receivedName);
        imageView.setImageResource(receivedImage);
    }
}
