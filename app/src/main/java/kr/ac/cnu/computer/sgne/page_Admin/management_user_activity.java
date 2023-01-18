package kr.ac.cnu.computer.sgne.page_Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import kr.ac.cnu.computer.sgne.R;

public class management_user_activity extends AppCompatActivity {

    Intent re_intenet;
    TextView input_Id;
    TextView input_Pw;
    TextView input_name;
    String[] items = {"ㅋㅋㅋ","ㅎㅎㅎ",";;;"};
    String[] items2 = {"False","True"};
    Intent send_intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_user_activity);
        input_Id = findViewById(R.id.input_ID);
        input_Pw = findViewById(R.id.input_PW);
        input_name = findViewById(R.id.input_name);

        re_intenet = getIntent();
        input_Id.setText(re_intenet.getExtras().getString("Id"));
        input_Pw.setText(re_intenet.getExtras().getString("Pw"));
        input_name.setText(re_intenet.getExtras().getString("name"));

        Button edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,send_intent);
                finish();
            }
        });

        Button cancle = findViewById(R.id.cancle);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Spinner spinner_group = findViewById(R.id.spinner_group);
        ArrayAdapter groupAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,items);
        groupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_group.setAdapter(groupAdapter);

        spinner_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String group = items[position];
                send_intent.putExtra("group",group);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinner_right = findViewById(R.id.spinner_right);
        ArrayAdapter rightAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,items2);
        rightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_right.setAdapter(rightAdapter);

        spinner_right.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String right = items2[position];
                send_intent.putExtra("right",right);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}