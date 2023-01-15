package kr.ac.cnu.computer.sgne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class GrouprankingActivity extends AppCompatActivity {

    int personNum; // <-- 통신으로 시험 볼때마다 하나씩 추가
    int totalNum; // <-- 어드민 db에서 빼오기
    String userName;
    TextView selectStudybookName;
    RecyclerView rv_1;
    RecyclerView rv_2;
    static int temp_1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupranking);

        selectStudybookName = findViewById(R.id.selectedStudybook);

        rv_1 = findViewById(R.id.rv_1);
        ArrayList<studybook> studybook_list = new ArrayList<>();

        LinearLayoutManager layoutManager1 =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_1.setLayoutManager(layoutManager1);
        studybookAdapter adapter1 = new studybookAdapter();

        // personNum과 totalNum은 임의로 test data생성
        studybook_list.add(new studybook("2020 간호조무사 제1회 모의고사", 48, 50));
        studybook_list.add(new studybook("2020 간호조무사 제2회 모의고사", 50, 50));
        studybook_list.add(new studybook("2020 간호조무사 제3회 모의고사", 49, 50));
        studybook_list.add(new studybook("2021 간호조무사 제1회 모의고사", 44, 50));
        studybook_list.add(new studybook("2021 간호조무사 제2회 모의고사", 42, 50));
        studybook_list.add(new studybook("2021 간호조무사 제3회 모의고사", 41, 50));
        studybook_list.add(new studybook("2022 간호조무사 제1회 모의고사", 39, 50));
        studybook_list.add(new studybook("2022 간호조무사 제2회 모의고사", 36, 50));
        studybook_list.add(new studybook("2022 간호조무사 제3회 모의고사", 31, 50));
        studybook_list.add(new studybook("2023 간호조무사 제1회 모의고사", 20, 50));
        studybook_list.add(new studybook("2023 간호조무사 제2회 모의고사", 19, 50));
        studybook_list.add(new studybook("2023 간호조무사 제3회 모의고사", 13, 50));

        adapter1.setItems(studybook_list);

        rv_1.setAdapter(adapter1);

        /**
         * 검색 기능
         */
        EditText studybookSearch = findViewById(R.id.studybookSearch);
        ArrayList<studybook> search_list = new ArrayList<>();

        studybookSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                String searchText = studybookSearch.getText().toString();
                search_list.clear();

                if(searchText.equals("")){
                    adapter1.setItems(studybook_list);
                }
                else {
                    // 검색 단어를 포함하는지 확인
                    for (int i = 0; i < studybook_list.size(); i++) {
                        if (studybook_list.get(i).studybookName.toLowerCase().contains(searchText.toLowerCase())) {
                            search_list.add(studybook_list.get(i));
                        }
                    }
                    adapter1.setItems(search_list);
                }
            }
        });

        rv_2 = findViewById(R.id.rv_2);

        LinearLayoutManager layoutManager2 =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_2.setLayoutManager(layoutManager2);
        rankingAdapter adapter2 = new rankingAdapter();

        ArrayList<ranking> ranking_list = new ArrayList<>();
        // Db에서 selectedStudybookName으로 조회하고, 모든 학생들의 점수를 ranking_list에 담기.

        ranking_list.add(new ranking("2021 간호조무사 제1회 모의고사", "이수호", 100));
        ranking_list.add(new ranking("2021 간호조무사 제1회 모의고사", "성원준", 20));
        ranking_list.add(new ranking("2021 간호조무사 제1회 모의고사", "배연우", 11));
        ranking_list.add(new ranking("2021 간호조무사 제1회 모의고사", "김민재", 9));
        ranking_list.add(new ranking("2021 간호조무사 제1회 모의고사", "박종현", 10));
        ranking_list.add(new ranking("2021 간호조무사 제1회 모의고사", "김사랑", 7));
        ranking_list.add(new ranking("2021 간호조무사 제1회 모의고사", "곽동현", 10));
        ranking_list.add(new ranking("2021 간호조무사 제1회 모의고사", "정재혁", 0));
        ranking_list.add(new ranking("2022 간호조무사 제2회 모의고사", "이선행", 3));
        ranking_list.add(new ranking("2022 간호조무사 제2회 모의고사", "박용준", 2));
        ranking_list.add(new ranking("2022 간호조무사 제2회 모의고사", "임찬혁", 9));
        ranking_list.add(new ranking("2022 간호조무사 제2회 모의고사", "강승엽", 4));
        Collections.sort(ranking_list);

        // ranking_list가 DB라고 가정하자.

        for(int i=0; i<ranking_list.size(); i++){
            ranking_list.get(i).setRankingNum(i+1);
        }
        adapter2.setItems(ranking_list);

        rv_2.setAdapter(adapter2);
        /**
         * 리사이클러뷰(rv_1)에서 아이템 단일 선택을 위해 아래 코드 추가
         */
        ArrayList<Integer> beforePosition = new ArrayList<>();
        ArrayList<View> beforeView = new ArrayList<>();
        adapter1.setOnItemClickListener(new OnStudybookClickListener() {
            @Override
            public void onItemClick(studybookAdapter.ViewHolder holder, View view, int position) {
                if(temp_1 == 0) {
                    beforePosition.add(position);
                    beforeView.add(view);
                    studybook item = adapter1.getItem(position);
                    selectStudybookName.setText(item.getStudybookName());
                    view.setBackgroundResource(R.drawable.rectangular_round_lightbrown_outline_lightgreen);
                    temp_1 ++;
                } else {
                    if(beforePosition.get(0) == position){
                        selectStudybookName.setText(" ");
                        view.setBackgroundResource(R.drawable.rectangular_round_lightbrown);
                        temp_1 --;
                        beforeView.clear();
                        beforePosition.clear();
                    }
                    else {
                        studybook item = adapter1.getItem(position);
                        selectStudybookName.setText(item.getStudybookName());
                        beforeView.get(0).setBackgroundResource(R.drawable.rectangular_round_lightbrown);
                        view.setBackgroundResource(R.drawable.rectangular_round_lightbrown_outline_lightgreen);
                        beforeView.clear();
                        beforeView.add(view);
                        beforePosition.clear();
                        beforePosition.add(position);
                    }
                }
            }
        });

    }
}