package com.example.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView text1, text2;
    Switch switchAgree;
    RadioGroup rGroup1;
    RadioButton radioArray[] = new RadioButton[3];
    Button btnQuit;
    Button btnFirst;
    ImageView imgPet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        switchAgree = (Switch) findViewById(R.id.switchAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        radioArray[0] = (RadioButton) findViewById(R.id.Rdo43);
        radioArray[1] = (RadioButton) findViewById(R.id.Rdo44);
        radioArray[2] = (RadioButton) findViewById(R.id.Rdo50);

        btnQuit = (Button) findViewById(R.id.BtnQuit);
        btnFirst = (Button) findViewById(R.id.BtnFirst);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchAgree.isChecked()) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    btnFirst.setVisibility(android.view.View.VISIBLE);
                    btnQuit.setVisibility(android.view.View.VISIBLE);
                    imgPet.setVisibility(android.view.View.VISIBLE);
                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    btnFirst.setVisibility(android.view.View.INVISIBLE);
                    btnQuit.setVisibility(android.view.View.INVISIBLE);
                    imgPet.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        final int draw[] = { R.drawable.a43, R.drawable.a44,
                R.drawable.a50};

        for (int i = 0; i < radioArray.length; i++) {
            final int index;
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    imgPet.setImageResource(draw[index]);
                }
            });
        }

        btnQuit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });

        btnFirst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                text2.setVisibility(android.view.View.INVISIBLE);
                rGroup1.setVisibility(android.view.View.INVISIBLE);
                btnFirst.setVisibility(android.view.View.INVISIBLE);
                btnQuit.setVisibility(android.view.View.INVISIBLE);
                imgPet.setVisibility(android.view.View.INVISIBLE);

                rGroup1.clearCheck();
                switchAgree.setChecked(false);
            }

        });
    }
}