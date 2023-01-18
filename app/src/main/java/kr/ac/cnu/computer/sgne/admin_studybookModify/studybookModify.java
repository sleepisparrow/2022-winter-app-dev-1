package kr.ac.cnu.computer.sgne.admin_studybookModify;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.ac.cnu.computer.sgne.R;

public class studybookModify extends AppCompatActivity {

    Button multipleChoiceForm;
    Button essayForm;
    Button backButton;
    Button nextButton;
    private int multipleChoiceFormTestNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studybook_modify);

        multipleChoiceForm = findViewById(R.id.multipleChoiceForm);
        essayForm = findViewById(R.id.essayForm);
        backButton = findViewById(R.id.backButton);
        nextButton = findViewById(R.id.nextButton);

        FragmentManager fm1_1 = getSupportFragmentManager(); // 객관식 - 문제, 해설
        FragmentManager fm1_2 = getSupportFragmentManager(); // 객관식 - 선지

        /**
         * 받아온 정보가 true이면 객관식, false이면 O/X라고 가정
         * btn.performClick() 메서드 사용 예정
         */
        Boolean bool = true;
        if(bool) multipleChoiceForm.performClick();
        else { essayForm.performClick(); }
        multipleChoiceForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(multipleChoiceFormTestNum % 2 == 0){
                    multipleChoiceFormTestNum ++;
                    multipleChoiceForm.setBackgroundResource(R.drawable.rectangular_round_green);

                    FragmentTransaction ft1_1 = fm1_1.beginTransaction();
                    ft1_1.add(R.id.frame1_1, new studybookModifyFrag1_1(), "1000");
                    ft1_1.commit();

                    FragmentTransaction ft1_2 = fm1_2.beginTransaction();
                    ft1_2.add(R.id.frame1_2, new studybookModifyFrag1_2(), "1001");
                    ft1_2.commit();
                }
                else{
                    multipleChoiceFormTestNum ++;
                    multipleChoiceForm.setBackgroundResource(R.drawable.rectangular_round_white_outline_green);

                    FragmentTransaction ft1_1 = fm1_1.beginTransaction();
                    Fragment fragment1_1 = fm1_1.findFragmentByTag("1000");
                    if(fragment1_1 != null) {
                        ft1_1.remove(fragment1_1);
                        ft1_1.commit();
                    }

                    FragmentTransaction ft1_2 = fm1_2.beginTransaction();
                    Fragment fragment1_2 = fm1_2.findFragmentByTag("1001");
                    if(fragment1_2 != null) {
                        ft1_2.remove(fragment1_2);
                        ft1_2.commit();
                    }
                }
            }
        });
    }


    public void multipleChoiceFormClicked(View view){

    }
    public void essayFormClicked(View view){

    }
    public void backButtonClicked(View view){

    }
    public void nextButtonClicked(View view){

    }
}