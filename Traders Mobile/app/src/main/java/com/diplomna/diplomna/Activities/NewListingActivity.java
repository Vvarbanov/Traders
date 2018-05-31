package com.diplomna.diplomna.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.diplomna.diplomna.DTOs.ItemDTO;
import com.diplomna.diplomna.DTOs.SubCategoryDTO;
import com.diplomna.diplomna.R;
import com.diplomna.diplomna.http.API;


import java.util.ArrayList;
import java.util.List;

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

    public ImageButton createButton;
    private EditText txtItemName, txtPrice, txtDesc, txtQuant;
    private Spinner spnrCategory;

    public String getItemName(){
        return txtItemName.getText().toString().trim();
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

        API service = retrofit.create(API.class);

        service.getAllSubCategories().enqueue(new Callback<List<SubCategoryDTO>>() {
            @Override
            public void onResponse(Call<List<SubCategoryDTO>> call, Response<List<SubCategoryDTO>> response) {
                if(response.isSuccessful()){

                    List<SubCategoryDTO> subCategoryDTOList = response.body();

                    ArrayList<String> spinnerList = new ArrayList<>();

                    for (SubCategoryDTO subCat: subCategoryDTOList
                         ) {
                        spinnerList.add(subCat.getName().trim());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item, spinnerList);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnrCategory.setAdapter(adapter);
                }else {
                    Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_SHORT).show();
                    Log.v(this.getClass().getSimpleName(),"response:" + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<SubCategoryDTO>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                Log.v(this.getClass().getSimpleName(), "error:" + t.getMessage());
            }
        });

    }

    @OnClick(R.id.imgbtnCreate)
    public void submit(View view){

        API service = retrofit.create(API.class);

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setName(getItemName());
        itemDTO.setUser(sharedPreferences.getString("username", "N/A"));
        itemDTO.setBasePricePerUnit(getPrice());
        itemDTO.setDescription(getDesc());
        itemDTO.setSubCategory(spnrCategory.getSelectedItem().toString());
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

    }

    public void init(){
        createButton = findViewById(R.id.imgbtnCreate);
        txtItemName = findViewById(R.id.txtNameOfItem);
        txtPrice = findViewById(R.id.txtPrice);
        txtDesc = findViewById(R.id.txtDescription);
        txtQuant = findViewById(R.id.txtQuantity);
        spnrCategory = findViewById(R.id.spnrCategory);
    }








}
