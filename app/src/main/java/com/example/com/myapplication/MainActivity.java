package com.example.com.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("버튼예제1");
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn1:

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/911")));
            case R.id.btn2:
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse());
        }

    }
}

