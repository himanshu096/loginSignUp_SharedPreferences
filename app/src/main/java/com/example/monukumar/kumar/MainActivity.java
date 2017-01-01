package com.example.monukumar.kumar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button signup,lgn;
    EditText username,password;
    SharedPreferences sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup=(Button)findViewById(R.id.button_signup);
        sf=getSharedPreferences("my_pref",0);
        lgn=(Button)findViewById(R.id.button_login);
        username=(EditText)findViewById(R.id.edittext_username);
        password=(EditText)findViewById(R.id.edittext_password);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Sign_up.class);
                EditText editText = (EditText) findViewById(R.id.edittext_username);
                startActivity(intent);
            }
        });
        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usr=username.getText().toString();
                String pw=password.getText().toString();
                Intent k=new Intent(getApplicationContext(),afterlogin.class);
                if(usr.length()<=0){
                    Toast.makeText(getApplicationContext(),"Enter Username",Toast.LENGTH_LONG).show();
                }
                else if(pw.length()<=0){
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_LONG).show();
                }
                else if(sf.contains(("Acc"+usr))==false){
                    Toast.makeText(getApplicationContext(),"Username does not exist!",Toast.LENGTH_LONG).show();
                }
                else{
                    if(sf.getString("Accpwd"+usr,null).equals(pw)){

                        k.putExtra("details","logged in as:"+usr);
                        startActivity(k);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Username or password is incorrect",Toast.LENGTH_LONG).show();
                    }
                }

        }});

    }
}
