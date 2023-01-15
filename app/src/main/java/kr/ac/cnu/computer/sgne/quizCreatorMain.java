package kr.ac.cnu.computer.sgne;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class quizCreatorMain extends AppCompatActivity {
    Button createButton;
    EditText testName;
    EditText publishedGroup;
    Button multipleChoiceForm;
    Button essayForm;
    RecyclerView recyclerView;
    Button nextButton;
    Button backButton;
    Button doneButton;
    boolean selection = false;
    boolean tfSelection = false;
    choiceAdapter adapter;
    tfAdapter adapter2;

    ArrayList<multipleQuiz> list1 = new ArrayList<>();
    ArrayList<tfQuiz> list2 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_creator);

        createButton = findViewById(R.id.createButton);
        testName = findViewById(R.id.testName);
        publishedGroup = findViewById(R.id.publishedGroup);
        multipleChoiceForm = findViewById(R.id.multipleChoiceForm);
        essayForm = findViewById(R.id.essayForm);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        doneButton = findViewById(R.id.doneButton);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        //객관식 버튼을 눌렀을 때
        multipleChoiceForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //객관식 버튼 클릭시 객관식 문제 제작지가 recyclerView에 표시됨
                //기존에 작업중이었을 경우 그 작업을 소거하고 새로고침

                /*
                기존의 작업을 삭제할 것인지 물어보는 다이얼로그 띄우기
                 */
                adapter = new choiceAdapter();
                adapter.addItem(new multipleQuiz());
                recyclerView.setAdapter(adapter);
                selection = true;
                tfSelection = false;
            }
        });

        //tf 버튼을 눌렀을 때
        essayForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter2 = new tfAdapter();
                adapter2.addItem(new tfQuiz());
                recyclerView.setAdapter(adapter2);
                tfSelection = true;
                selection = false;
            }
        });


        //next 버튼을 눌렀을 때
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //객관식
                if(selection){
                    choiceAdapter.count++;
                    adapter.nextCommand();
                    try{
                        multipleQuiz item = choiceAdapter.items.get(choiceAdapter.position+1);
                        adapter.backCommand(item);
                    }catch (Exception e){
                        adapter.addItem(new multipleQuiz());
                        adapter.refreshCommand();
                    }
                    choiceAdapter.position++;
                }

                //tf
                if(tfSelection){
                    tfAdapter.count++;
                    adapter2.nextCommand();
                    try{
                        tfQuiz item = tfAdapter.items.get(tfAdapter.position+1);
                        adapter2.backCommand(item);
                    }catch (Exception e){
                        adapter2.addItem(new tfQuiz());
                        adapter2.refreshCommand();
                    }
                    tfAdapter.position++;
                }
            }
        });


        //back 버튼을 눌렀을 때
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //객관식
                if(selection){
                    if(choiceAdapter.count>=2){
                        choiceAdapter.count--;
                        choiceAdapter.position--;
                        multipleQuiz item = choiceAdapter.items.get(choiceAdapter.position);
                        adapter.backCommand(item);
                    }
                }

                //tf
                if(tfSelection){
                    if(tfAdapter.count>=2){
                        tfAdapter.count--;
                        tfAdapter.position--;
                        tfQuiz item = tfAdapter.items.get(tfAdapter.position);
                        adapter2.backCommand(item);
                    }
                }
            }
        });

        //제작 완료 버튼을 눌렀을 때
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다른 페이지로 이동하는 것을 추가해야 함
                list1 = choiceAdapter.items;
                list2 = tfAdapter.items;
                Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}