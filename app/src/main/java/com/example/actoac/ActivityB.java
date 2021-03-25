package com.example.actoac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    private TextView tvtitle, tvdes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("AAA", "onCreateB");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        getWidget();
        //setDataByExTra();
        setDataByBundle();
    }

    @Override
    protected void onStart() {
        Log.e("AAA", "onStartB");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e("AAA", "onResumeB");
        super.onResume();
    }

    public void getWidget()
    {
        tvtitle = (TextView) findViewById(R.id.text_rstitle);
        tvdes = (TextView) findViewById(R.id.text_rsDes);
    }

    public void setDataByExTra()
    {
        Intent intent = getIntent();
        String title = intent.getStringExtra(ActivityA.TITLE);
        String Des = intent.getStringExtra(ActivityA.DESCRIPTION);

        tvtitle.setText(title);
        tvdes.setText(Des);
    }

    public void setDataByBundle()
    {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(ActivityA.BUNDLE);
        String title = bundle.getString(ActivityA.TITLE);
        String Des = bundle.getString(ActivityA.DESCRIPTION);
        tvtitle.setText(title);
        tvdes.setText(Des);
    }
}