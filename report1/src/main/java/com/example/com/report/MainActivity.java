package com.example.com.report;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends Activity {
    //변수 설정
    TextView dateText;
    Button btnSave;
    EditText editText;
    int cYear, cMonth, cDay;
    String fileName, filePath;
    DatePickerDialog datePickerDialog;
    File diaryFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("다이어리 어플리케이션");

        //변수에 ID값 대입
        dateText = (TextView) findViewById(R.id.textDate);
        editText = (EditText) findViewById(R.id.editText);
        btnSave = (Button) findViewById(R.id.btnSave);

        //현재 연월일 값 변수에 대입
        Calendar calendar = Calendar.getInstance();
        cYear = calendar.get(Calendar.YEAR);
        cMonth = calendar.get(Calendar.MONTH) + 1;
        cDay = calendar.get(Calendar.DAY_OF_MONTH);

        // 파일이름 설정
        fileName = cYear + "년_" + cMonth + "월_" + cDay + "일.txt";

        // 파일위치 설정
        diaryFile = getExternalFilesDir("mydiary");
        filePath = diaryFile.getAbsolutePath();
        editText.setText(readDiary());

        //TextView에 날짜 설정, 터치리스너 구현
        dateText.setText(Integer.toString(cYear) + "년 " + Integer.toString(cMonth) + "월 " + Integer.toString(cDay) + "일");
        dateText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            //터치를 하면 DatePickerDialog로 날짜 변경
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int day) {
                            cYear = year;
                            cMonth = month + 1;
                            cDay = day;
                            // DatePickerDialog로 날짜 변경할걸 TextView에 입력
                            dateText.setText(Integer.toString(cYear) + "년 " + Integer.toString(cMonth) + "월 " + Integer.toString(cDay) + "일");
                            fileName = cYear + "년_" + cMonth + "월_" + cDay + "일.txt";
                            //editText에 내용 설정
                            editText.setText(readDiary());
                        }
                    },
                            cYear, cMonth - 1, cDay);
                    datePickerDialog.show();
                }
                return false;
            }
        });
        //버튼 클릭리스너 저장 기능
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 파일 저장 경로 및 이름 설정
                File file = new File(filePath + "/" + fileName);
                try {
                    FileOutputStream fos = new FileOutputStream(file, true);
                    String diaryContext = editText.getText().toString();
                    fos.write(diaryContext.getBytes());
                    fos.close();
                } catch (IOException e) {

                }
                // 저장되었다는 메시지창 출력
                Toast.makeText(getApplicationContext(), fileName + " 이 저장됨", Toast.LENGTH_SHORT).show();
            }
        });
    }
    // 메뉴 옵션 설정
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // 옵션 내용 구현
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        final float textSize = 44;
        //다시 불러오기 옵션 설정
        if (id == R.id.reRead) {
            editText.setText(readDiary());
            return true;
        }
        //삭제 옵션 설정
        else if(id == R.id.delete) {
            //dailog 구현
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            // 삭제 여부 묻는 dialog
            dlg.setTitle(dateText.getText() + "\n 일기를 삭제하시겠습니까?");
            // 확인 버튼 눌렀을시 내용 삭제
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   File file = new File(filePath + "/" + fileName);
                    file.delete();
                    editText.setText(readDiary());
                    // 삭제 되었다는 메시지창 출력
                    Toast.makeText(getApplicationContext(), fileName + " 이 삭제됨", Toast.LENGTH_SHORT).show();
                }
            });
            // 취소 버튼
            dlg.setNegativeButton("취소",null);
            dlg.show();

        }
        //일기 내용 글씨 크기 설정
        else if(id == R.id.big) {
            editText.setTextSize(textSize * 2);

        }
        else if(id == R.id.small) {
            editText.setTextSize(textSize * 2 / 4);
        }
        else if(id == R.id.mid) {
            editText.setTextSize(textSize);
        }

        return super.onOptionsItemSelected(item);
    }

//  readDidary() 파일을 읽고 넘겨주는 함수
   String readDiary() {
        String diaryContext = null;
        FileInputStream fis;
        File file = new File(filePath + "/" + fileName);
        try {
            fis = new FileInputStream(file);
            byte[] txt = new byte[400];
            fis.read(txt);
            fis.close();
            diaryContext = (new String(txt)).trim();
        } catch (IOException e) {
        }
        return diaryContext;
    }
}

