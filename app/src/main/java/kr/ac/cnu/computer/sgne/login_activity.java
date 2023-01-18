package kr.ac.cnu.computer.sgne;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import kr.ac.cnu.computer.sgne.admin_page.main_admin_activity;
import kr.ac.cnu.computer.sgne.main_page.main_activity;

public class login_activity extends AppCompatActivity {
    EditText editText_id, editText_pw;
    CardView login_button;
    TextView wrong_input_err_msg;
    Boolean_Wrapper is_id_inserted = new Boolean_Wrapper(false), is_pw_inserted = new Boolean_Wrapper(false);
    Boolean is_login_disabled = true;

    SharedPreferences sharedPreferences;

    private String id, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        getLoginData();
        disableLoginButton();
        setTextChangeListener();
    }

    /**
     * 로그인 시도의 시점. server에 로그인을 시도하는 함수를 실행하고, server method의 return에 따라 main_activity로 가거나 error_msg를 띄운다
     */
    private void login() {
        wrong_input_err_msg.setVisibility(View.INVISIBLE);
        User tmp = new User();
        tmp.setId(id);
        int loc = login_test_data.contains(tmp);
        if (loc == -1) {
            finishWrongLogin();
            return;
        }
        tmp = login_test_data.list.get(loc);
        if (!tmp.is_valid) {
            finishInvalidUserLogin();
            return;
        }

        saveUserData(tmp);

        if (!pw.equals(tmp.getPw())) {
            finishWrongLogin();
            return;
        }
        if (tmp.is_admin)
            finishAdminUserLogin();
        else
            finishValidUserLogin();
    }

    /**
     * 인증된 유저가 로그인을 할 떄 전 처리과정
     */
    private void saveUserData(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("id", user.getId());
        editor.putString("password", user.getPw());
        editor.putString("name", user.getName());
        // TODO: 이름은 추후 토큰으로 바뀌어야 함.
        editor.apply();
    }

    private void finishAdminUserLogin() {
        Intent intent = new Intent(this, main_admin_activity.class);
        startActivity(intent);
    }

    private void finishValidUserLogin() {
        Intent intent = new Intent(this, main_activity.class);
        startActivity(intent);
    }

    private void finishInvalidUserLogin() {
        wrong_input_err_msg.setText("아직 계정이 관리자에 의해 인증되지 않았습니다. \n자세한 내용은 관리자에게 문의하세요");
        wrong_input_err_msg.setVisibility(View.VISIBLE);
    }

    private void finishWrongLogin() {
        wrong_input_err_msg.setText("아이디 혹은 패스워드의 입력이 잘못되었습니다.");
        wrong_input_err_msg.setVisibility(View.VISIBLE);
    }

    /**
     * 이전에 로그인 한 기록이나 회원가입을 통해 얻은 로그인 관련 데이터들을 editText에 지정하고
     * 로그인이 가능할 시 로그인을 시도함
     */
    private void getLoginData() {
        sharedPreferences = getSharedPreferences("login", Activity.MODE_PRIVATE);
        id = sharedPreferences.getString("id", null);
        pw = sharedPreferences.getString("password", null);

//        if (id != null && pw != null)
//           login();
    }

    /**
     * id, pw editText가 다 차야 로그인을 누를 수 있게 설정해주는 함수
     */
    private void setTextChangeListener() {
        editText_id.addTextChangedListener(new LoginTextWatcher(is_id_inserted));
        editText_pw.addTextChangedListener(new LoginTextWatcher(is_pw_inserted));
    }

    /**
     * layout에 있는 필요한 것들을 매핑시킴
     */
    private void init() {
        editText_id = findViewById(R.id.input_id);
        editText_pw = findViewById(R.id.input_pw);

        login_button = findViewById(R.id.login_button);
        findViewById(R.id.register_button).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), register_activity.class);
            startActivity(intent);
        });

        wrong_input_err_msg = findViewById(R.id.wrong_input_text);
    }

    private void enableLoginButton() {
        login_button.setOnClickListener(v -> {
            id = String.valueOf(editText_id.getText());
            pw = String.valueOf(editText_pw.getText());
            login();
        });
    }

    private void disableLoginButton() {
        login_button.setOnClickListener(v -> {
            Toast.makeText(this, "아이디 혹은 비밀번호를 입력하지 않으셨습니다.", Toast.LENGTH_LONG).show();
        });
    }
    /**
     * id, pw editText가 사용하는 TextWatcher.
     * 둘 다 차있을 경우 활성화, 비활성화도 이 친구가 한다.
     */
    class LoginTextWatcher implements TextWatcher {
        Boolean_Wrapper target;

        LoginTextWatcher(Boolean_Wrapper target) {
            this.target = target;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            if (count > 0)
                target.setTrue();
            else
                target.setFalse();

            if (is_id_inserted.getBool() && is_pw_inserted.getBool() && is_login_disabled) {
                enableLoginButton();
                is_login_disabled = false;
            }
            else if (!(is_id_inserted.getBool() && is_pw_inserted.getBool()) && !is_login_disabled){
                disableLoginButton();
                is_login_disabled = true;
            }
        }

        @Override
        public void afterTextChanged(Editable editable) { }
    }
}

class Boolean_Wrapper {
    private boolean aBoolean;
    Boolean_Wrapper() { }

    Boolean_Wrapper(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public void reverseBool() {
        aBoolean = !aBoolean;
    }

    public void setTrue() {
        aBoolean = true;
    }

    public void setFalse() {
        aBoolean = false;
    }

    public boolean getBool() {
        return aBoolean;
    }
}