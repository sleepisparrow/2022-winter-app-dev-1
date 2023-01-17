package kr.ac.cnu.computer.sgne.quiz_list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.ac.cnu.computer.sgne.R;
import kr.ac.cnu.computer.sgne.page_User.exam_activity;

public class TestScrollMain extends AppCompatActivity {

    /*나중에 db에서 사용자 정보랑 퀴즈 정보 불러오는 것 구현해야 함*/
    ArrayList<Quiz> list = new ArrayList();
    String userName;
    String testName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_app);
        TextView userName = findViewById(R.id.userName);
        TextView testName = findViewById(R.id.testName);
        Button startButton = findViewById(R.id.startButton);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        QuizAdapter adapter = new QuizAdapter();

        for(Quiz item : list){
            adapter.addItem(item);
        }


        for(int i=0; i<10; i++){
            adapter.addItem(new Quiz(10, 6, 1));
        }
        /*

        <확인용 - 새로운 퀴즈객체를 만들어서 어뎁터에 전달>
        for(int i=0; i<10; i++){
            adapter.addItem(new Quiz(10, 6, 1));
        }

         */

        recyclerView.setAdapter(adapter);

        /*
        데이터베이스에서 testName과 userName을 불러와서 setText 해주는 부분 구현 필요
        */

        startButton.setOnClickListener(v -> {
            // TODO: problem set 수정
            Intent intent = new Intent(getApplicationContext(), exam_activity.class);
            intent.putExtra("problem_set", 1);
            startActivity(intent);
        });
    }
}