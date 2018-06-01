package com.diplomna.diplomna.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.diplomna.diplomna.DTOs.ItemDTO;
import com.diplomna.diplomna.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItemInfoActivity extends AppCompatActivity {

    TextView itemQuantity, sellerUsername, itemName, itemDesc, itemPrice;
    Button sellerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        init();

        ButterKnife.bind(this);

        ItemDTO dto = (ItemDTO) getIntent().getExtras().get("item");
        String unit = (String) getIntent().getExtras().get("unit");

        itemName.setText("" + dto.getName());
        itemDesc.setText("" + dto.getDescription());
        itemPrice.setText("Price: " + "Price: " + dto.getBasePricePerUnit() + " bgn/" + unit);
        itemQuantity.setText("Quantity: " + dto.getQuantity() + " " + unit);
        sellerUsername.setText("From: " + dto.getUser());
    }

    public void init(){
        itemQuantity = findViewById(R.id.item_quantity_text);
        sellerUsername = findViewById(R.id.seller_text);
        itemName = findViewById(R.id.item_name);
        itemDesc = findViewById(R.id.item_description);
        itemPrice = findViewById(R.id.item_price_text);
        sellerButton = findViewById(R.id.seller_button);
    }

    @OnClick(R.id.seller_button)
    public void submit(View view){
        Intent intent = new Intent(ItemInfoActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}
