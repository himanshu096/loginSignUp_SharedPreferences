package com.example.monukumar.kumar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {
    SharedPreferences sf;
Button sgnup,login;
    EditText usrname,pswrd;
    String uname,passw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final SharedPreferences sf=getSharedPreferences("my_pref",0);
        final Editor ed=sf.edit();
        usrname=(EditText)findViewById(R.id.username);
        pswrd=(EditText)findViewById(R.id.pass);
        sgnup=(Button)findViewById(R.id.btn_signup);
        login=(Button)findViewById(R.id.btn_login);

        final Intent i = new Intent(getApplicationContext(),MainActivity.class);
        sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname=usrname.getText().toString();
                passw=pswrd.getText().toString();
                if(sf.contains("Acc"+uname))
                {
                    Toast.makeText(getApplicationContext(),"Username already exists",Toast.LENGTH_LONG).show();
                }
                else if((uname.length()<=0)||(passw.length()<=0)){
                    Toast.makeText(getApplicationContext(),"fill details",Toast.LENGTH_LONG).show();
                }
                else
                {


                      ed.putString(("Acc" + uname), uname);
                      ed.putString(("Accpwd" + uname), passw);
                      ed.commit();
                      Toast.makeText(getApplicationContext(), "Sign Up Successful", Toast.LENGTH_LONG).show();
                      startActivity(i);

                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

    }
}
