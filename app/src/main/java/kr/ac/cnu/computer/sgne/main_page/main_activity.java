package kr.ac.cnu.computer.sgne.main_page;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kr.ac.cnu.computer.sgne.R;
import kr.ac.cnu.computer.sgne.User;
import kr.ac.cnu.computer.sgne.login_test_data;
import kr.ac.cnu.computer.sgne.quiz_list.TestScrollMain;

public class main_activity extends AppCompatActivity {

    private User user;

    TextView group_name, name, navigation_test;
    ImageView navigation_menu_button;
    DrawerLayout drawerLayout;

    RecyclerView untested, tested;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_navigation();
        init_toolbar();
        init_recycler_view();
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

    private void init_toolbar() {
        group_name = findViewById(R.id.group_name);
        name = findViewById(R.id.name);

        SharedPreferences sharedPreferences = getSharedPreferences("login", Activity.MODE_PRIVATE);
        String id = sharedPreferences.getString("id", null);
        User tmp = new User();
        tmp.setId(id);
        // data
        user = login_test_data.list.get(login_test_data.contains(tmp));
        group_name.setText(user.getGroup().name);
        name.setText(user.getName());
    }

    private void init_recycler_view() {
        untested = findViewById(R.id.unTested_recyclerView);
        tested = findViewById(R.id.tested_recyclerView);

        main_activity_adapter untested_adapter = new main_activity_adapter();
        main_activity_adapter tested_adapter = new main_activity_adapter();

        //data
        untested_adapter.setList(main_test_data.unTested);
        untested_adapter.setItemListener((view, pos) -> {
            problem_set problemSet = untested_adapter.list.get(pos);
            
            // TODO: id 수정하기
            Intent intent = new Intent(getApplicationContext(), TestScrollMain.class);
            intent.putExtra("problem_set_id", 1);
            startActivity(intent);
        });
        tested_adapter.setList(main_test_data.tested);
        tested_adapter.setItemListener((view, pos) -> {
            problem_set problemSet = tested_adapter.list.get(pos);

            // TODO: id 수정하기
            Intent intent = new Intent(getApplicationContext(), TestScrollMain.class);
            intent.putExtra("problem_set_id", 1);
            startActivity(intent);
        });

        untested_adapter.notifyDataSetChanged();
        tested_adapter.notifyDataSetChanged();

        untested.setAdapter(untested_adapter);
        tested.setAdapter(tested_adapter);

        untested.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        tested.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
