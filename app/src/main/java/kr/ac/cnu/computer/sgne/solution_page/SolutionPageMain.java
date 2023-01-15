package kr.ac.cnu.computer.sgne.solution_page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import kr.ac.cnu.computer.sgne.R;

public class SolutionPageMain extends AppCompatActivity {
    ScrollView scrollView;
    ScrollView scrollView2;
    Button nextButton;
    Button previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solution_page);

        scrollView = findViewById(R.id.scrollView);
        scrollView2 = findViewById(R.id.scrollView2);
        nextButton = findViewById(R.id.nextButton);
        previousButton = findViewById(R.id.previousButton);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sub1, scrollView, true);

        LayoutInflater inflater2 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater2.inflate(R.layout.sub2, scrollView2, true);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "다음 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "이전 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}