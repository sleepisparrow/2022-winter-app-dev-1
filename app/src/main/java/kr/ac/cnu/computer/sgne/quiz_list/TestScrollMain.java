package kr.ac.cnu.computer.sgne.quiz_list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import kr.ac.cnu.computer.sgne.R;
import kr.ac.cnu.computer.sgne.page_User.exam_activity;

public class TestScrollMain extends AppCompatActivity {

    /*나중에 db에서 사용자 정보랑 퀴즈 정보 불러오는 것 구현해야 함*/
    ArrayList<Quiz> list = new ArrayList();
    String uName;
    String quizName;
    int totalQuizNum = 10;
    int scoredQuizNum = 5;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_app);
        Button startButton = findViewById(R.id.startButton);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        QuizAdapter adapter = new QuizAdapter();

        //DB에서 문제 이름과 총 문제의 수를 가져옴
        databaseReference.child("workbook").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Together_group_list group = snapshot.getValue(Together_group_list.class);

                quizName = group.getQuizName();
                totalQuizNum = group.getTotalQuizNum();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Nothing
            }
        });

        //DB에서 맞은 문제 수를 가져옴
        databaseReference.child("workbook").child("workbook_user").child("scoredQuizNum").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                scoredQuizNum = (int) snapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        for(int i=1; i<=3; i++){
            adapter.addItem(new Quiz(totalQuizNum, scoredQuizNum, i));
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