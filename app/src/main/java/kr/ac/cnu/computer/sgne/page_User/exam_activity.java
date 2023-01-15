package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class exam_activity extends AppCompatActivity {

    String[] exams = {"지금 시각은?",
                        "이번주 회의시간은?",
                        "내가 잠들 수있는 시간은?"};
    String[][] Example = {{"1","2","3","4","5"},
                            {"1","2","3","4","5"},
                            {"8","7","6","4","5"}};
    int count = 0;
    TextView textView,problem;
    Button next_problem,previous_problem,submission;
    CheckBox box1,box2,box3,box4,box5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_activity);
        textView = findViewById(R.id.textView);
        problem = findViewById(R.id.problem);
        next_problem = findViewById(R.id.next_problem);
        previous_problem = findViewById(R.id.previous_problem);
        submission = findViewById(R.id.submission);
        box1 = (CheckBox)findViewById(R.id.checkBox1);
        box2 = (CheckBox)findViewById(R.id.checkBox2);
        box3 = (CheckBox)findViewById(R.id.checkBox3);
        box4 = (CheckBox)findViewById(R.id.checkBox4);
        box5 = (CheckBox)findViewById(R.id.checkBox5);

        textView.setText("문제. "+(count+1));
        problem.setText(exams[count]);
        box1.setText(Example[count][0]);
        box2.setText(Example[count][1]);
        box3.setText(Example[count][2]);
        box4.setText(Example[count][3]);
        box5.setText(Example[count][4]);

        next_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<exams.length){
                    box1.setChecked(false);
                    box2.setChecked(false);
                    box3.setChecked(false);
                    box4.setChecked(false);
                    box5.setChecked(false);

                    count++;
                    textView.setText("문제. "+(count+1));
                    problem.setText(exams[count]);
                    box1.setText(Example[count][0]);
                    box2.setText(Example[count][1]);
                    box3.setText(Example[count][2]);
                    box4.setText(Example[count][3]);
                    box5.setText(Example[count][4]);
                }
            }
        });

        previous_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>0){
                    box1.setChecked(false);
                    box2.setChecked(false);
                    box3.setChecked(false);
                    box4.setChecked(false);
                    box5.setChecked(false);
                    count--;
                    textView.setText("문제. "+(count+1));
                    problem.setText(exams[count]);
                    box1.setText(Example[count][0]);
                    box2.setText(Example[count][1]);
                    box3.setText(Example[count][2]);
                    box4.setText(Example[count][3]);
                    box5.setText(Example[count][4]);
                }
            }
        });

        submission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}