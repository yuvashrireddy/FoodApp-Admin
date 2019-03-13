package com.example.hemapriya.domain;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hemapriya.domain.Model.Food;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class MenuActivity extends AppCompatActivity {

    Button add;
    EditText foodPrice,foodName,foodDesc;
    String desc="";
    DatabaseReference databaseFood= FirebaseDatabase.getInstance().getReference("Food");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        add=(Button)findViewById(R.id.addToMenu);
        foodName=(EditText) findViewById(R.id.name);
        foodPrice=(EditText) findViewById(R.id.price);
        foodDesc=(EditText) findViewById(R.id.desc);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFood();
            }
        });

    }

    private void addFood() {
        String dish = foodName.getText().toString();
        String price = foodPrice.getText().toString();
        String desc = foodDesc.getText().toString();


        String food = dish;
        if (TextUtils.isEmpty(dish)) {
            foodName.setError("Please enter the username");
            foodName.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(price)) {
            foodPrice.setError("Please enter the username");
            foodPrice.requestFocus();
        }

        dish=dish.substring(0, 1).toUpperCase() +dish.substring(1);
        Food food1 = new Food(dish, price, desc);
        databaseFood.child(dish).setValue(food1);
        Toast.makeText(this, "Food is Added in the menu", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(MenuActivity.this,MainActivity.class);
        startActivity(intent);
    }
}

