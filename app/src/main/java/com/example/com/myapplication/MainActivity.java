package com.example.com.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int index;
    index = i;

    numButtons[index].setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            if (edit1.isFocused()) {
                num1 = edit1.getText().toString()
                        + numButtons[index].getText().toString();
                edit1.setText(num1);
            } else if (edit2.isFocused()) {
                num2 = edit2.getText().toString()
                        + numButtons[index].getText().toString();
                edit2.setText(num2);
            } else {
                Toast.makeText(getApplicationContext(),
                        "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
