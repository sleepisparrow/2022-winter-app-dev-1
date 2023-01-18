package kr.ac.cnu.computer.sgne.SearchUser_admin_page;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kr.ac.cnu.computer.sgne.R;
import kr.ac.cnu.computer.sgne.page_Admin.management_user_activity;

public class MainActivitySearchUser extends AppCompatActivity {
    RecyclerView recyclerView;
    userAdapterSearchUser adapter;
    EditText searchText;
    Button searchBtn, btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_searchuser);

        recyclerView = (RecyclerView) findViewById(R.id.user_recyclerview);

        adapter = new userAdapterSearchUser();
        int a = 1;
        for (int i = 0; i < 100; i++) {
            a += (((i+1) % 26 == 0) ? 1 : 0);

            UserSearchUser user = new UserSearchUser("이름 " + (char) (a % 26 + 64) + (char) (i % 26 + 65), "" + (char) ((i+1) % 26 + 64) + (char) ((i+3) % 26 + 65), "Group " + (i + 1), "2023-" + (1 + i % 12) + "-" + (1 + i % 30));
            adapter.setListData(user);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter.setOnClickListener((view, pos) -> {
            // TODO: 수정하기
            UserSearchUser data = adapter.getListData(pos);

            Intent intent = new Intent(getApplicationContext(), management_user_activity.class);
            intent.putExtra("data", 1);
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);


        /*------------------------------------------------------------------------------------------------------------------*/

        searchBtn = findViewById(R.id.search_btn);
        btnDialog = findViewById(R.id.btnDialog);
        searchText = findViewById(R.id.search_name);

        /*------------------------------------------------------------------------------------------------------------------*/



        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = searchText.getText().toString().trim();
                searchText.setText("");

                int totalUserNum = adapter.getItemCount();
                userAdapterSearchUser newAdapter = new userAdapterSearchUser();

                // 필터를 통해 검색 결과 내놓기
                String filter = btnDialog.getText().toString();
                Toast.makeText(getApplicationContext(), filter, Toast.LENGTH_SHORT).show();

                for (int i = 0; i < totalUserNum; i++) {
                    UserSearchUser user = adapter.getListData(i);
                    String name = user.getName();
                    String ID = user.getId();
                    String group = user.getGroup();
                    String date = user.getFirstClass();

                    if (filter.equals("▼사용자명") && name.contains(str)) {
                        newAdapter.setListData(user);
                    } else if (filter.equals("▼아이디") && ID.contains(str)) {
                        newAdapter.setListData(user);
                    } else if (filter.equals("▼분반") && group.contains(str)) {
                        newAdapter.setListData(user);
                    } else if (filter.equals("▼시간") && date.contains(str)){
                        newAdapter.setListData(user);
                    }
                }

                Toast.makeText(getApplicationContext(), "검색 버튼 클릭", Toast.LENGTH_SHORT).show();

                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager1);

                recyclerView.setAdapter(newAdapter);
            }
        });
        btnDialog.setOnClickListener(v -> {

            final String[] items = new String[]{"사용자명", "아이디", "분반", "시간"};
            final int[] selectedIndex = {0};

            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivitySearchUser.this);
            dialog.setTitle("필터를 선택하세요.")
                    .setSingleChoiceItems(items,
                            0,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    selectedIndex[0] = which;
                                    btnDialog.setText("▼"+items[selectedIndex[0]]);
                                }
                            })
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivitySearchUser.this, items[selectedIndex[0]], Toast.LENGTH_SHORT).show();
                        }
                    }).create().show();
        });
    }

}
