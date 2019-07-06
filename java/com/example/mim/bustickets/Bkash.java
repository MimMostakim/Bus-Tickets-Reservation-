package com.example.mim.bustickets;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bkash extends AppCompatActivity {
    EditText edtnumber,edtamount,edtconfirm;
    Button btns,btnconfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkash);

        edtnumber=(EditText)findViewById(R.id.edtnu);
        edtamount=(EditText)findViewById(R.id.edtam);
        edtconfirm=(EditText) findViewById(R.id.edtcon);

        btns = (Button) findViewById(R.id.btnsent);
        btnconfig = (Button) findViewById(R.id.btnco);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number= edtnumber.getText().toString();
                String txt=edtamount.getText().toString();

                try {
                    SmsManager sms=SmsManager.getDefault();
                    sms.sendTextMessage(number,null,number,null,null);
                    Toast.makeText(getApplicationContext(),"sent code",Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnconfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnconfig = new Intent(Bkash.this,Download.class);
                btnconfig.putExtra("reserve","Your Tickets is Confirm");
                startActivity(btnconfig);
            }
        });


    }
}