package kr.ac.cnu.computer.sgne.admin_groupadd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kr.ac.cnu.computer.sgne.R;

public class GroupAddActivity extends AppCompatActivity {
    EditText groupName;
    EditText firstLecture;
    EditText groupMember;
    EditText groupInfo;
    Button groupAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_add);

        RecyclerView rv_1 = findViewById(R.id.rv_1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_1.setLayoutManager(layoutManager);
        groupAdapter adapter = new groupAdapter();

        // test data로 테스트... 원래는 db에서 가져와야함
        adapter.addItem(new group("22.11.26 주간간호", 40, 50, "22.11.26"));
        adapter.addItem(new group("23.01.02 야간간호", 33, 46, "22.01.02"));
        adapter.addItem(new group("23.01.01 주간요양", 37, 44, "23.01.01"));

        rv_1.setAdapter(adapter);

        groupAdd = findViewById(R.id.groupAdd);
        groupAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                groupName = findViewById(R.id.groupName);
                firstLecture = findViewById(R.id.firstLecture);
                groupMember = findViewById(R.id.groupMember);
                groupInfo = findViewById(R.id.groupInfo);

                String group_name = groupName.getText().toString();
                String first_lecture = firstLecture.getText().toString();
                int group_member = Integer.parseInt(groupMember.getText().toString());
                String group_info = groupInfo.getText().toString();

                adapter.addItem(new group(group_name, 0, group_member, first_lecture));

                rv_1.setAdapter(adapter);
            }
        });

    }
}
