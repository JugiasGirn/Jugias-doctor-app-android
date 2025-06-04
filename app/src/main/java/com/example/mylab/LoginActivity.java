package com.example.mylab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView Tvloginpage;
    EditText Etemail,Etpass;
    Button Btlogin;
    SharedPreferences sharedpreferences;
    public static final String FILE_NAME = "mypref_File";// mypref_File--- name of the file
    public static final String EMAIL = "nameKey";
    public static final String PASSWORD1 = "emailKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Tvloginpage = findViewById(R.id.Tvloginpage);
        Etemail = findViewById(R.id.Etemail);
        Etpass = findViewById(R.id.Etpass);
        Btlogin = findViewById(R.id.Btlogin);

        sharedpreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        if(sharedpreferences.contains(EMAIL) && sharedpreferences.contains(PASSWORD1)){
            Intent intent1 = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent1);
        } else {

            Tvloginpage.setOnClickListener(view -> {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            });

            Btlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = Etemail.getText().toString().trim();
                    String password = Etpass.getText().toString();

                    if (email.isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Please Enter Email ID!", Toast.LENGTH_SHORT).show();
                    } else if (!isValidEmail(email)) {
                        Toast.makeText(LoginActivity.this, "Invalid Email Address!", Toast.LENGTH_SHORT).show();
                    } else if (containsWhitespace(email)) {
                        Toast.makeText(LoginActivity.this, "Email should not contain spaces!", Toast.LENGTH_SHORT).show();
                    } else if (password.isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Please Enter Password!", Toast.LENGTH_SHORT).show();
                    } else {
                        sharedpreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        //putString---to edit the file in key value pairs
                        editor.putString(EMAIL, email);
                        editor.putString(PASSWORD1, password);
                        // to commit the changes to the shared preferences file.
                        editor.apply();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }

    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private boolean containsWhitespace(String str) {
        return str.contains(" ");
    }
}
