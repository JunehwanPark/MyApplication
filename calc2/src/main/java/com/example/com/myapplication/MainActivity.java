package com.example.com.myapplication;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends Activity {

        EditText edit1;
        EditText edit2;
        TextView textresult;
        Double result;
        String num1, num2;

        Button[] numButtons = new Button[10];
        Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
                R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6,
                R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
       int i;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("그리드 레이아웃 계산기");

            edit1 = (EditText)findViewById(R.id.Edit1);
            edit2 = (EditText)findViewById(R.id.Edit2);
            textresult = (TextView)findViewById(R.id.TextResult);
            findViewById(R.id.BtnAdd).setOnClickListener(Calc);
            findViewById(R.id.BtnSub).setOnClickListener(Calc);
            findViewById(R.id.BtnMul).setOnClickListener(Calc);
            findViewById(R.id.BtnDiv).setOnClickListener(Calc);


            for (i = 0; i < numBtnIDs.length; i++) {
                numButtons[i] = (Button) findViewById(numBtnIDs[i]);
            }

            for (i = 0; i < numBtnIDs.length; i++) {

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
                                    "먼저 에디트텍스트를 선택하세요",Toast.LENGTH_SHORT).show();

                        }

                    }
                });

            }

        }


        Button.OnClickListener Calc = new View.OnClickListener() {
            public void onClick(View v) {

                String tmp1 = edit1.getText().toString();
                String tmp2 = edit2.getText().toString();

                if(tmp1.equals("") || tmp2.equals("")) {
                    Toast.makeText(getApplicationContext(),"값이 입력되지 않았습니다", Toast.LENGTH_LONG).show();
                }

                else {
                    Double num1 = Double.parseDouble(tmp1);
                    Double num2 = Double.parseDouble(tmp2);

                    switch (v.getId()) {
                        case R.id.BtnAdd:
                            result = num1 + num2;
                            break;
                        case R.id.BtnSub:
                            result = num1 - num2;
                            break;
                        case R.id.BtnMul:
                            result = num1 * num2;
                            break;
                        case R.id.BtnDiv:
                            if (num1 == 0) {
                                Toast.makeText(getApplicationContext(), "0은 나눌수 없습니다.", Toast.LENGTH_SHORT).show();
                                break;
                            }
                            else if(num2 == 0) {
                                Toast.makeText(getApplicationContext(), "0으로 나눌수 없습니다.", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                result = num1 / num2;
                                break;
                            }
                    }
                    textresult.setText("계산결과: " + result.toString());
                }

            }
        };
}



