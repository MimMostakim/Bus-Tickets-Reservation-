package com.example.mim.bustickets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Download extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        textView = findViewById(R.id.txtid);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null)
        {
           String value= bundle.getString("reserve");
           textView.setText(value);
        }
    }
}
