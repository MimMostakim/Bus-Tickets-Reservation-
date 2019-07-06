package com.example.mim.bustickets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Passenger extends AppCompatActivity {

    EditText editText;
    EditText editText1;
    EditText editText2;
    Button con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);

        editText= (EditText)findViewById(R.id.edt);
        editText1 = (EditText) findViewById(R.id.edit1);
        editText2 = (EditText) findViewById(R.id.edit2);
        con = (Button) findViewById(R.id.btnc);

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent con = new Intent(Passenger.this,Payment.class);
                startActivity(con);

            }
        });
    }
}
