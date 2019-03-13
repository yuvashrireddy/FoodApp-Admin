package com.example.hemapriya.domain;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemapriya.domain.Model.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditPriceActivity extends AppCompatActivity {

    Button add;
    TextView foodName;
    EditText foodPrice,foodDesc;
    String desc="";
    DatabaseReference databaseFood= FirebaseDatabase.getInstance().getReference("Food");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_price);
        add=(Button)findViewById(R.id.addToMenu);
        foodName=(TextView) findViewById(R.id.name);
        foodPrice=(EditText) findViewById(R.id.price);
        foodDesc=(EditText) findViewById(R.id.desc);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFood();
            }
        });

        Intent intent=getIntent();
        String dish = intent.getStringExtra("pid");
        Toast.makeText(EditPriceActivity.this, dish, Toast.LENGTH_LONG).show();

        databaseFood=FirebaseDatabase.getInstance().getReference("Food").child(dish);

        databaseFood.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child("dish").getValue().toString();
                foodName.setText(name);
                String desc=dataSnapshot.child("desc").getValue().toString();
              foodDesc.setText(desc);
                String price=dataSnapshot.child("price").getValue().toString();
                foodPrice.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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

DatabaseReference foodref =FirebaseDatabase.getInstance().getReference().child("Food");
        Food food1 = new Food(dish, price, desc);
        foodref.child(food).setValue(food1);
        Toast.makeText(this, "Food is Added in the menu", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(EditPriceActivity.this,MainActivity.class);
        startActivity(intent);

    }
}


