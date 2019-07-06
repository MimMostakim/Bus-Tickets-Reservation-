package com.example.mim.bustickets;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BookTickets extends AppCompatActivity implements View.OnClickListener{
    private static final String[] district = new String[]{
            "Dhaka","chittagong","Rangpur","Rajshahi","Bogra","Khulna","Barisal"

    };
    int progress;
    private Button button;
    private TextView textView;
    private DatePickerDialog datePickerDialog;
    ProgressBar prg;
    Button bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tickets);

        AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompleteTextView editText1 = findViewById(R.id.actv1);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,district);
        editText.setAdapter(adapter);


        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,district);
        editText1.setAdapter(adapter1);


        textView = (TextView)findViewById(R.id.txtview);
        button = (Button)findViewById(R.id.btnd);
        prg = (ProgressBar)findViewById(R.id.pro);
        bus = (Button) findViewById(R.id.btnp);
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bus = new Intent(BookTickets.this,Bus.class);
                startActivity(bus);
            }
        });

        button.setOnClickListener(this);
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();

            }
        });
        thread.start();
    }
    public  void doWork(){
        for (progress=10;progress<=100;progress=progress+10)
        try {
            Thread.sleep(1000);
            prg.setProgress(progress);
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }

    @Override
    public void onClick(View v) {


        DatePicker datePicker=new DatePicker(this);
        int currentDay= datePicker.getDayOfMonth();
        int currentMonth =(datePicker.getDayOfMonth())+1;
        int currentYear= datePicker.getYear();


        datePickerDialog = new DatePickerDialog(this,

                new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        textView.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },currentYear,currentMonth,currentDay);

        datePickerDialog.show();




    }


}
