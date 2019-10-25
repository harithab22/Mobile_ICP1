package com.csee5590.helloworldapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Button s,b;
    EditText s1,s2,s3,s4,s5;

    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        s = (Button)findViewById(R.id.register);
        s1 = (EditText)findViewById(R.id.FirstName);
        s2 = (EditText)findViewById(R.id.password);
        s3 = (EditText)findViewById(R.id.Email);
        s4 = (EditText)findViewById(R.id.Mobilenumber);
        s5 = (EditText)findViewById(R.id.PostalAddress);
        b= (Button)findViewById(R.id.submitbutton);

        tx = (TextView)findViewById(R.id.Registerheader);

        b.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v) {
                    checkDataEntered();
                }
            }

        );
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
        }
    boolean isEmail(EditText text) {
        CharSequence Email = text.getText().toString();
        return (!TextUtils.isEmpty(Email) && Patterns.EMAIL_ADDRESS.matcher(Email).matches());
    }
    void checkDataEntered() {
        if (isEmpty(s1)) {
            //s1.setError("First name is required!");
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(s2)) {
            //s2.setError("Password is required!");
            Toast t = Toast.makeText(this, "You must enter Password to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        //if (isEmpty(lastName)) {
            //lastName.setError("Last name is required!");
        //}

        if (isEmail(s3) == false) {
            s3.setError("Enter valid email!");
        }

    }
}
