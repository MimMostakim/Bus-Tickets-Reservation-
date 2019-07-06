package com.example.mim.bustickets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Thank extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank);
        textView =findViewById(R.id.txtc);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null)
        {
            String value= bundle.getString("cash");
            textView.setText(value);
        }
    }
}
