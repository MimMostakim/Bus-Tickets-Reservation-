package com.example.mim.bustickets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cash extends AppCompatActivity {
    Button thank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);
        thank = (Button)findViewById(R.id.btncon);

        thank .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thank=new Intent(Cash.this, Thank.class);
                thank.putExtra("cash"," Thank You " +
                        "Your Delivery Order is Confirmed");
                startActivity(thank);
            }
        });
    }
}
