package com.diplomna.diplomna.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.diplomna.diplomna.DTOs.ItemDTO;
import com.diplomna.diplomna.R;
import com.diplomna.diplomna.http.API;


import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewListingActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    @Inject
    SharedPreferences sharedPreferences;

    public Button createButton;
    private EditText txtItemName, txtUnit, txtPrice, txtDesc, txtQuant;
    private Spinner spnrCategory;

    public String getItemName(){
        return txtItemName.getText().toString().trim();
    }

    public String getUnit(){
        return txtUnit.getText().toString().trim();
    }

    public Double getPrice(){
        return Double.parseDouble(txtPrice.getText().toString().trim());
    }

    public String getDesc(){
        return txtDesc.getText().toString().trim();
    }

    public Integer getQuant(){
        return Integer.parseInt(txtQuant.getText().toString().trim());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_listing);
        ButterKnife.bind(this);

        init();
    }

    @OnClick(R.id.btnCreate)
    public void submit(View view){

        API service = retrofit.create(API.class);

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setName(getItemName());
        itemDTO.setUser(sharedPreferences.getString("username", "N/A"));
        itemDTO.setBasePricePerUnit(getPrice());
        itemDTO.setDescription(getDesc());
        itemDTO.setSubCategory("Notebooks");
        itemDTO.setQuantity(getQuant());

        service.createNewListing(itemDTO).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    Log.d("listing", "successful");
                }else{
                    Log.d("listing","not successful");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("Retro",t.getMessage());
            }
        });

        //service.

    }

    public void init(){
        createButton = findViewById(R.id.btnCreate);
        txtItemName = findViewById(R.id.txtNameOfItem);
        txtUnit = findViewById(R.id.txtUnit);
        txtPrice = findViewById(R.id.txtPrice);
        txtDesc = findViewById(R.id.txtDescription);
        txtQuant = findViewById(R.id.txtQuantity);
        //spnrCategory = findViewById(R.id.spnrCategory);
    }








}
