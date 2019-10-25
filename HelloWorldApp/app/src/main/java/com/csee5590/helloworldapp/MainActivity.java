package com.csee5590.helloworldapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends Activity  {
    Button b1,b2,b3;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.loginButton);
        b3=(Button) findViewById(R.id.register);
        ed1 = (EditText)findViewById(R.id.name);
        ed2 = (EditText)findViewById(R.id.password);

        tx1 = (TextView)findViewById(R.id.tV2);
        //tx1.setVisibility(View.GONE);


    }


    public void loginFlow(View v){
        if(ed1.getText().toString().equals("admin") &&
                ed2.getText().toString().equals("admin")) {
            Intent redirect = new Intent( MainActivity.this, home.class);
            startActivity(redirect);
        }else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

            tx1.setVisibility(View.VISIBLE);

            tx1.setBackgroundColor(Color.RED);
            counter--;
            tx1.setText(Integer.toString(counter));
            tx1.setText("Invalid");
            if (counter == 0) {
                b1.setEnabled(false);
            }
        }

    }
    public void registerflow(View v){
        Intent redirect =new Intent(MainActivity.this,Register.class);
        startActivity(redirect);
    }


}
