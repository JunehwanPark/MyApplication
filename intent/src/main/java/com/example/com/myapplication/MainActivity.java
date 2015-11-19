package com.example.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rdoGroup);
        RadioButton btnAdd = (RadioButton) findViewById(R.id.rdoAdd);
        RadioButton btnSub = (RadioButton) findViewById(R.id.rdoSub);
        RadioButton btnMul = (RadioButton) findViewById(R.id.rdoMul);
        RadioButton btnDiv = (RadioButton) findViewById(R.id.rdoDiv);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);

                String tmp1 = edtNum1.getText().toString();
                String tmp2 = edtNum2.getText().toString();

                int operator;

                if (tmp1.equals("") || tmp2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값이 입력되지 않았습니다", Toast.LENGTH_SHORT).show();
                }

                else {

                    switch (radioGroup.getCheckedRadioButtonId()) {
                        case R.id.rdoAdd:
                            operator = 1;
                            break;
                        case R.id.rdoSub:
                            operator = 2;
                            break;
                        case R.id.rdoMul:
                            operator = 3;
                            break;
                        case R.id.rdoDiv:
                            operator = 4;
                            break;
                        default:
                            operator = 0;
                            Toast.makeText(getApplicationContext(), "연산자를 선택하세요", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                    intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                    intent.putExtra("Operator", operator);
                    startActivityForResult(intent, 0);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            int result = data.getIntExtra("Result", 0);
            Toast.makeText(getApplicationContext(), "결과 :" + result, Toast.LENGTH_SHORT).show();
        }
    }

}