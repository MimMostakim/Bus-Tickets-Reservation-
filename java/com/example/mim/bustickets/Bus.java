package com.example.mim.bustickets;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class Bus extends AppCompatActivity implements View.OnClickListener {
    private static final String[] operator = new String[]{
            "SR","HANIF","SHYAMOLI","NABIL","GREEN-LINE","ENA","DESH-TRAVELS"


    };

    private static final String[] Bus = new String[]{"AC","NON-AC","HUNDAI","SCANIA"

    };
    private static final String[] Boarding = new String[]{
            "Kallyanpur Bus Point","Baipail Bus point","Chandra Bus Point",
            "Gabtoli Bus Point","Gabtoli Mazar Road"

    };
    private static final String[] seat = new String[]{
            "[A1]","[A2]","[A3]","[A4]","[B1]",
            "[B2]","[B3]","[B4]","[C1]","[C2]","[C3]","[C4]",
            "[D1]","[D2]","[D3]","[D4]","[E1]","[E2]","[E3]","[E4]",
            "[F1]","[F2]","[F3]","[F4]","[G1]","[G2]","[G3]","[G4]"

    };
    private Spinner spinner,spinner1,spinner2,spinner3;
   // private TextView txtview,txtview1,txtview2,txtview3;
    private TextView textView;
    private Button button;
    TimePickerDialog timePickerDialog;
    Button res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);


        //AutoCompleteTextView editText = findViewById(R.id.a1);
        //txtview = findViewById(R.id.a1);
       // txtview1  = findViewById(R.id.a2);
        //txtview2  = findViewById(R.id.a3);
        //txtview3 = findViewById(R.id.a4);
        spinner= findViewById(R.id.spn1);
        spinner1= findViewById(R.id.spn2);
        spinner2= findViewById(R.id.spn3);
        spinner3= findViewById(R.id.spn4);


        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,operator);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,Bus);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,Boarding);
        spinner2.setAdapter(adapter2);
        ArrayAdapter<String> adapter3= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,seat);
        spinner3.setAdapter(adapter3);


        textView=(TextView) findViewById(R.id.texttime);
        button=(Button) findViewById(R.id.btntime);
        res=(Button)findViewById(R.id.btnres);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent res= new Intent(Bus.this,Passenger.class);
                startActivity(res);
            }
        });


button.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        TimePicker timePicker=new TimePicker(this);
        int currentHour= timePicker.getCurrentHour();
        int currentMinute= timePicker.getCurrentMinute();

        timePickerDialog = new TimePickerDialog(Bus.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    textView.setText(hourOfDay + ":"+minute);
                    }
                },currentHour,currentMinute,true);

         timePickerDialog.show();

    }
}
