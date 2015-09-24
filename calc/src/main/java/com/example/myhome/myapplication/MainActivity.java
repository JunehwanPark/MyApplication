package com.example.myhome.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnExp;
    TextView textResult;
    String num1, num2;
    Double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnExp = (Button) findViewById(R.id.BtnExp);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else if(num2.equals("0.0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else if(num2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnExp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });
    }
}