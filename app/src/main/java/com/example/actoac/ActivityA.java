package com.example.actoac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityA extends AppCompatActivity {

    private EditText edtitle, eddes;
    private Button mbtsend;

    public static final String TITLE ="TITLE";
    public static final String DESCRIPTION ="DESCRIPTION";
    public static final String BUNDLE="BUNDLE";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        getWigget();
        setEvent();
    }

    @Override
    protected void onResume() {
        Log.e("AAA", "onReSumeA");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e("AAA", "onPauseA");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("AAA", "onStopA");
        super.onStop();
    }

    public void getWigget()
    {
        edtitle = (EditText) findViewById(R.id.edtTitle_input);
        eddes = (EditText) findViewById(R.id.edtDes_input);
        mbtsend = (Button) findViewById(R.id.button_send);
    }

    public void setEvent()
    {
        mbtsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtitle.getText().toString();
                String Des = eddes.getText().toString();
                byBundle(title, Des);
            }
        });
    }

    //Chuyển bằng extra
    public void byExtras(String title, String Des)
    {
        Intent intent = new Intent(ActivityA.this, ActivityB.class); //Kêu gọi hành động truyển từ activity này sang Activity kia
        //Chuyển dữ liệu qua  mảng intent bằng extra
        intent.putExtra(TITLE, title);
        intent.putExtra(DESCRIPTION, Des);
        startActivity(intent); //Bắt đầu chuyển dữ liệu
    }

    //Chuyển bằng Bundle
    public void byBundle(String title, String Des)
    {
        Intent intent = new Intent(ActivityA.this, ActivityB.class); //Kêu gọi hành động truyển từ activity này sang Activity kia
        Bundle bundle = new Bundle(); //Tạo một mảng bundle chứa tất cả dữ liệu
        //Chuyển dữ liệu qua bundle
        bundle.putString(TITLE, title);
        bundle.putString(DESCRIPTION, Des);
        intent.putExtra(BUNDLE, bundle);
        startActivity(intent);
    }
}