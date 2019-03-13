package com.example.hemapriya.domain;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    private TextView closeTextBtn,saveTextButton;

    private EditText  userPh, fullNameEditText,addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);



        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        fullNameEditText = (EditText) findViewById(R.id.settings_phone_number);
        addressEditText = (EditText) findViewById(R.id.settings_address);
        userPh = (EditText) findViewById(R.id.settings_full_name);
        closeTextBtn = (TextView) findViewById(R.id.close_settings);

        saveTextButton = (TextView) findViewById(R.id.update_settings);

        databaseReference=FirebaseDatabase.getInstance().getReference("Admin");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String phone=dataSnapshot.child("phone").getValue().toString();
                userPh.setText(phone);
                String name=dataSnapshot.child("name").getValue().toString();
                fullNameEditText.setText(name);
                String addr=dataSnapshot.child("addr").getValue().toString();
                addressEditText.setText(addr);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        saveTextButton.setOnClickListener(this);
        closeTextBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v==saveTextButton)
        {
            String name,addr,phone;
            phone=userPh.getText().toString();

            name = fullNameEditText.getText().toString().toUpperCase();
            addr=addressEditText.getText().toString();
            User user=new User(name,phone,addr);
            if(TextUtils.isEmpty(name)){
                fullNameEditText.setError("Please enter the Admin Name");
                fullNameEditText.requestFocus();
                return;}
            if(TextUtils.isEmpty(phone)||phone.length()!=10){
                userPh.setError("Please enter the valid Phone Number");
                userPh.requestFocus();
                return;}



            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(intent);

            Toast.makeText(this,"Details Updated",Toast.LENGTH_SHORT).show();

        }
        else if(v==closeTextBtn)
        {
            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }
}