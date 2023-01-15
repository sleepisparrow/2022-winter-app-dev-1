package com.example.edit_group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class edit_group_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_group_activity);
        EditText name_group = findViewById(R.id.그룹이름입력);
        EditText first_class_date = findViewById(R.id.날짜입력);
        EditText size_group = findViewById(R.id.그룹인원입력);
        EditText inform_group = findViewById(R.id.그룹정보입력);

        Intent re_intent = getIntent();
        name_group.setHint(re_intent.getExtras().getString("name"));
        first_class_date.setHint(re_intent.getExtras().getString("date"));
        size_group.setHint(re_intent.getExtras().getString("size"));
        inform_group.setHint(re_intent.getExtras().getString("inform"));

        Button edit = findViewById(R.id.수정완료);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = name_group.getText().toString();
                String date = first_class_date.getText().toString();
                String size = size_group.getText().toString();
                String inform = inform_group.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("name",name);
                intent.putExtra("date",date);
                intent.putExtra("size",size);
                intent.putExtra("inform",inform);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button cancle = findViewById(R.id.취소);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}