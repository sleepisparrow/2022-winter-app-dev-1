package kr.ac.cnu.computer.sgne;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class register_activity extends AppCompatActivity {

    EditText editText_name, editText_id, editText_pw, editText_pw_check;
    TextView err_msg_name, err_msg_id, err_msg_pw, err_msg_pw_check;
    CardView button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    /**
     * 로그인 시도의 시점. server에 로그인을 시도하는 함수를 실행하고, server method의 return에 따라 main_activity로 가거나 error_msg를 띄운다
     */
    private void init() {
        editText_name = findViewById(R.id.input_name);
        editText_id = findViewById(R.id.input_id);
        editText_pw = findViewById(R.id.input_pw);
        editText_pw_check = findViewById(R.id.input_pw_check);

        err_msg_name = findViewById(R.id.name_error_text);
        err_msg_id = findViewById(R.id.id_error_text);
        err_msg_pw = findViewById(R.id.pw_error_text);
        err_msg_pw_check = findViewById(R.id.pw_check_error_text);

        err_msg_name.setVisibility(View.INVISIBLE);
        err_msg_id.setVisibility(View.INVISIBLE);
        err_msg_pw.setVisibility(View.INVISIBLE);
        err_msg_pw_check.setVisibility(View.INVISIBLE);

        button_register = findViewById(R.id.register_button);
        button_register.setOnClickListener(new RegisterButtonClickListener());
    }

    /**
     * 이름이 1자 이상인가?
     */
    private boolean is_name_valid() {
        int len = editText_name.getText().toString().length();
        return len > 0;
    }

    /**
     * id가 1자 이상인가?
     * id가 db에 존재하지 않는가?
     * return: 만약에 문제가 없다면 O, 입력이 없다면 -1, 중복이면 1
     */
    private int is_id_valid() {
        String id = editText_id.getText().toString();
        int len = id.length();
        if (len == 0)
            return -1;
        for (User u : login_test_data.list) {
            User tmp = new User();
            tmp.setId(id);
            if (tmp.equals(u))
                return 1;
        }
        return 0;
    }

    /**
     * pw가 8자 이상 존재하는가
     * pw에 영문, 숫자, 특수기호가 포함되는가?
     */
    private boolean is_pw_valid() {
        String pw = editText_pw.getText().toString();

        return pw.length() > 0;
    }

    /**
     * pw와 pw_check가 일치하는가?
     */
    private boolean is_pw_double_check_right() {
        String pw = editText_pw.getText().toString();
        String pw_check = editText_pw_check.getText().toString();

        if (pw_check.length() == 0)
            return false;
        return pw.equals(pw_check);
    }

    class RegisterButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            boolean valid = true;

            err_msg_name.setVisibility(View.INVISIBLE);
            err_msg_id.setVisibility(View.INVISIBLE);
            err_msg_pw.setVisibility(View.INVISIBLE);
            err_msg_pw_check.setVisibility(View.INVISIBLE);

            if (!is_name_valid()) {
                err_msg_name.setVisibility(View.VISIBLE);
                valid = false;
            }

            if (is_id_valid() == -1) {
                err_msg_id.setText("ID가 존재하지 않습니다. 다시 입력해 주세요");
                err_msg_id.setVisibility(View.VISIBLE);
                valid = false;
            } else if (is_id_valid() == 1) {
                err_msg_id.setText("이미 중복된 ID 입니다. 다른 것으로 입력해 주세요");
                err_msg_id.setVisibility(View.VISIBLE);
                valid = false;
            }

            if (!is_pw_valid()) {
                err_msg_pw.setVisibility(View.VISIBLE);
                valid = false;
            }

            if (!is_pw_double_check_right()) {
                err_msg_pw_check.setVisibility(View.VISIBLE);
                valid = false;
            }

            if (valid) {
                SharedPreferences sharedPreferences = getSharedPreferences("login", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                login_test_data.list.add(new User(editText_id.getText().toString(),
                        editText_pw.getText().toString(),
                        editText_name.getText().toString(),
                        false, false));

                editor.putString("id", editText_id.getText().toString());
                Intent intent = new Intent(getApplicationContext(), login_activity.class);
                startActivity(intent);
            }
        }
    }
}