package com.example.mim.bustickets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {
    Button bk;
    Button ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        bk=(Button)findViewById(R.id.btnbk);
        ca=(Button)findViewById(R.id.btncash);

        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bk=new Intent(Payment.this,Bkash.class);
                startActivity(bk);

            }
        });

        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ca = new Intent(Payment.this,Cash.class);
                startActivity(ca);
            }
        });
    }
}
