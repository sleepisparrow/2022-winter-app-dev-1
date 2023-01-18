package kr.ac.cnu.computer.sgne.quiz_list;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class quiz_layout extends LinearLayout {
    /*
    TextView record_num;
    TextView CA;
    TextView WA;
     */

    public quiz_layout(Context context) {
        super(context);
    }

    public quiz_layout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    /*
    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.quiz_layout, this, true);

        record_num = findViewById(R.id.record_num);
        CA = findViewById(R.id.correct_answers);
        WA = findViewById(R.id.wrong_answers);
    }

    public void setRecord(String record){
        String init_record = record_num.getText().toString() + record;
        record_num.setText(init_record);
    }

    public void setCA(int correct, int total){
        String init_CA = CA.getText().toString() + correct + "/" + total;
        CA.setText(init_CA);
    }

    public void setWA(int correct, int total){
        int wrong = total - correct;
        String init_WA = WA.getText().toString() + wrong + "/" + total;
        WA.setText(init_WA);
    }
     */
}
