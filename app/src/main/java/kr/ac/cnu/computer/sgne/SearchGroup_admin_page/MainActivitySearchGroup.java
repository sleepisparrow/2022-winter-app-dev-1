package kr.ac.cnu.computer.sgne.SearchGroup_admin_page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kr.ac.cnu.computer.sgne.R;
import kr.ac.cnu.computer.sgne.admin_groupranking.GrouprankingActivity;

public class MainActivitySearchGroup extends AppCompatActivity {

    Button search_btn, check_rank_btn, student_management_btn, delete_group_btn, edit_group_btn;
    EditText search_text;
    TextView group_info, student_num_info, group_detail_info, first_date, signup_btn;
    RecyclerView recyclerView;

    workbookAdapterSearchGroup adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_searchgroup);

        // 버튼들
        search_btn = findViewById(R.id.serch_btn);
        check_rank_btn = findViewById(R.id.button);
        student_management_btn = findViewById(R.id.student_management);
        delete_group_btn = findViewById(R.id.delete_group);
        edit_group_btn = findViewById(R.id.edit_group);

        // 검색창
        search_text = findViewById(R.id.search_name);

        // 그룹의 기본 정보들
        group_info = findViewById(R.id.group_info);
        student_num_info = findViewById(R.id.student_num_Info);
        group_detail_info = findViewById(R.id.group_detail_info);
        first_date = findViewById(R.id.first_date);

        /*
            이 자리에서 기본 정보들 수정할 것
         */
        check_rank_btn.setOnClickListener(v -> {
            // TODO: group_id 수정
            Intent intent = new Intent(getApplicationContext(), GrouprankingActivity.class);
            intent.putExtra("group_id", 1);
            startActivity(intent);
        });

        // 회원가입 대기중 버튼
        signup_btn = findViewById(R.id.user_group3);

        // 리사이클러 뷰
        recyclerView = (RecyclerView) findViewById(R.id.workbook_recyclerview);

        adapter = new workbookAdapterSearchGroup();
        for (int i=0; i<100; i++) {
            WorkbookSearchGroup workbook = new WorkbookSearchGroup("컴활 "+(i+1)+"급", "10", "30");
            adapter.setListData(workbook);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

    }

    /* 검색 버튼 눌렀을 때 실행할 method */
    public void Search(View view){
        String str = search_text.getText().toString().trim();
        if (!str.equals("")) {
            /*
                1. DB에서 문제집 데이터 가져와서
                2. 아래 리사이클러 뷰에 띄우도록 코드 짜기
             */
        }
        search_text.setText("");
    }

    public void Ranking(View view){
        String group_name = group_info.getText().toString();
        /*
            1. DB에 기록된 모든 분반 정보를 가져온다.
            2. 분반을 특정 기준으로 분반을 정렬시킨다.
            3. 정렬된 분반중에서 찾고자 하는 분반을 순서대로 찾는다.
            4. 찾으면 그 순서를 rank로 안내한다.
         */
    }

    public void StudentManagement(View view){
        /*
           //Todo 학생 관리 액티비티로 연결시켜주는 코드 작성
         */
    }

    public void DeletGroup(View view) {
        /*
           //Todo 그룹을 DB에서 삭제하는 코드 작성
         */
    }

    public void EditGroup(View view) {
        /*
           //Todo 그룹을 편집하는 액티비티로 연결시켜주는 코드 작성
         */
    }

    public void Singup(View view) {

        /*
           //Todo 회원가입 수락 액티비티로 연결시켜주는 코드 작성
         */
    }
}

class ViewHolderSearchGroup extends RecyclerView.ViewHolder {

    public TextView studybookName, personNum, totalNum;
    public Button editWorkBook;


    public ViewHolderSearchGroup(Context context, View itemView) {
        super(itemView);

        studybookName = itemView.findViewById(R.id.studybookName);
        personNum = itemView.findViewById(R.id.personNum);
        totalNum = itemView.findViewById(R.id.totalNum);
        editWorkBook = itemView.findViewById(R.id.eidtWorkbook);
        editWorkBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 이 자리엔 클릭한 문제집을 화면에 띄우는 코드 작성 필요


                // 아래에 토스트 메시지를 띄우는 코드는 제대로 된 작동을 하는지 테스트를 위한 코드임.
                Toast.makeText(context, studybookName.getText().toString() + " 문제집 클릭", Toast.LENGTH_SHORT).show();
            }
        });
    }
}