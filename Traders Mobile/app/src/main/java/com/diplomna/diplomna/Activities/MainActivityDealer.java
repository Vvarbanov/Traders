package com.diplomna.diplomna.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.diplomna.diplomna.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivityDealer extends AppCompatActivity {

    public ImageButton imgbtnNewListing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dealer);

        ButterKnife.bind(this);

        init();

    }

    @OnClick(R.id.imgbtnNewListing)
    public void submit(View view){

        Intent intent = new Intent(MainActivityDealer.this, NewListingActivity.class);
        startActivity(intent);

    }

    public void init(){
        imgbtnNewListing = findViewById(R.id.imgbtnNewListing);
    }
}
