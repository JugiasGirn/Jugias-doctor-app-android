package com.example.mylab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    TextView TVloginsignup;
    Button Btsignup;
    EditText Etemailsignup,Etpasssignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TVloginsignup =findViewById(R.id.TVloginsignup);
        Btsignup =findViewById(R.id.Btsignup);
        Etemailsignup =findViewById(R.id.Etemailsignup);
        Etpasssignup =findViewById(R.id.Etpasssignup);


        Btsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Etemailsignup.getText().toString();
                String password = Etpasssignup.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(SignupActivity.this,"Please Enter Email ID!",Toast.LENGTH_SHORT).show();
                }else if(password.isEmpty()){
                    Toast.makeText(SignupActivity.this,"Please Enter Password!",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });



        TVloginsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}