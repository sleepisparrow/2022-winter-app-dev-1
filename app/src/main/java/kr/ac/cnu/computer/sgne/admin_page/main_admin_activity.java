package kr.ac.cnu.computer.sgne.admin_page;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import kr.ac.cnu.computer.sgne.R;
import kr.ac.cnu.computer.sgne.SearchGroup_admin_page.MainActivitySearchGroup;
import kr.ac.cnu.computer.sgne.SearchUser_admin_page.MainActivitySearchUser;
import kr.ac.cnu.computer.sgne.User;
import kr.ac.cnu.computer.sgne.login_test_data;

public class main_admin_activity extends AppCompatActivity {
    private User user;

    TextView group_name, name, navigation_test;
    DrawerLayout drawerLayout;
    ImageView navigation_menu_button;
    TextView waiting_button;
    EditText search_text;
    Main_admin_adapter adapter;

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        init_navigation();
        init_toolbar();
        init_search_text();
        init_recyclerView();
        init_buttons();
    }

    private void init_navigation() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigation_test = findViewById(R.id.navigation_bar_item1);
        navigation_menu_button = findViewById(R.id.navigation_menu);

        navigation_test.setOnClickListener(v -> Toast.makeText(this, "네비게이션 뷰 눌림", Toast.LENGTH_LONG).show());
        navigation_menu_button.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.END);
        });
    }

    /**
     * 가장 상단의 툴바를 세팅하는 곳
     * 인증 대기 버튼 역시 여기서 처리한다.
     */
    private void init_toolbar() {
        group_name = findViewById(R.id.group_name);
        name = findViewById(R.id.name);

        SharedPreferences sharedPreferences = getSharedPreferences("login", Activity.MODE_PRIVATE);
        String id = sharedPreferences.getString("id", null);
        User tmp = new User();
        tmp.setId(id);
        // data
        user = login_test_data.list.get(login_test_data.contains(tmp));
        group_name.setText(R.string.manager);
        name.setText(user.getName());

        List<User> listTmp = login_test_data.list;
        int unverified = 0;
        for (User u : listTmp) {
            if (!u.is_valid)
                unverified++;
        }

        // TODO: 이걸 나중에 자동 업데이트를 하기 위해서 메서드 분리하기
        waiting_button = findViewById(R.id.waiting_verify);
        waiting_button.setText("회원 가입 대기중: " + unverified + "명");
        waiting_button.setOnClickListener(v -> {
            Toast.makeText(this, "대기 페이지", Toast.LENGTH_SHORT).show();
        });
    }

    private void init_search_text() {
        search_text = findViewById(R.id.search_edit_text);
        search_text.setOnKeyListener((view, i, keyEvent) -> {
            if (i == KeyEvent.KEYCODE_ENTER)
                search();
            return false;
        });

        findViewById(R.id.search_icon).setOnClickListener(v -> {
            search();
        });
    }

    private void search() {
        String search = search_text.getText().toString();

        List<Group> new_list = new LinkedList<>();
        for (Group g : main_admin_test_data.list) {
            if (g.name.contains(search))
                new_list.add(g);
        }

        adapter.list = new_list;
        adapter.notifyDataSetChanged();
    }

    /**
     * 리사이클러뷰와 아이템뷰의 리스너들을 세팅하는 부분
     */
    private void init_recyclerView() {
        rv = findViewById(R.id.recyclerView);

        adapter = new Main_admin_adapter();

        // data
        adapter.list = main_admin_test_data.list;
        adapter.setListener(new Main_admin_adapter.OnMainAdapterClickListener() {
            @Override
            public void on_ranking_check_button_click(View itemView, int pos) {
                Group group = adapter.list.get(pos);
                Toast.makeText(main_admin_activity.this, group.name + "랭킹 확인 눌림", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void on_manage_group_button_click(View itemView, int pos) {
                Group group = adapter.list.get(pos);

                // TODO: group_id 수정
                Intent intent = new Intent(getApplicationContext(), MainActivitySearchGroup.class);
                intent.putExtra("group_id", 1);
                startActivity(intent);
            }
        });

        rv.setAdapter(adapter);

        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    /**
     * 가장 밑에 있는 버튼 3개를 관리하는 메서드
     */
    private void init_buttons() {
        findViewById(R.id.create_problems).setOnClickListener(v -> {
            Toast.makeText(this, "문제집 제작 눌림", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.manage_user).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivitySearchUser.class);
            startActivity(intent);
        });

        findViewById(R.id.add_group).setOnClickListener(v -> {
            Toast.makeText(this, "분반 추가 눌림", Toast.LENGTH_SHORT).show();
        });
    }
}