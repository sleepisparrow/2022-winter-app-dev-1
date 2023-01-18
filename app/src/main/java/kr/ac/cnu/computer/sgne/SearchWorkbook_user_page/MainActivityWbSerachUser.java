package kr.ac.cnu.computer.sgne.SearchWorkbook_user_page;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kr.ac.cnu.computer.sgne.R;

public class MainActivityWbSerachUser extends AppCompatActivity {
    RecyclerView apReView, unReView;
    workbookAdapterWbSearchUser apAdapter, unAdapter;

    Button searchBtn;
    EditText searchText;

    RecyclerView[] recyclerViews;
    workbookAdapterWbSearchUser[] adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wbsearchuser);

        searchText = findViewById(R.id.search_name);
        searchBtn = findViewById(R.id.search_btn);


        apReView = (RecyclerView) findViewById(R.id.recycler_view_apply);
        unReView = (RecyclerView) findViewById(R.id.recycler_view_unapply);

        apAdapter = new workbookAdapterWbSearchUser();
        unAdapter = new workbookAdapterWbSearchUser();

        int a = 1;
        for (int i = 0; i < 100; i++) {
            a += (((i + 1) % 26 == 0) ? 1 : 0);
            WorkbookWbSearchUser w = new WorkbookWbSearchUser("" + (char) (a % 26 + 64) + (char) (i % 26 + 65), (i + 1) + " " + (char) ((i + 1) % 26 + 64) + (char) ((i + 3) % 26 + 65), "" + ((int) Math.random() * 100 + 1), ((int) (Math.random() * 100)) + "",
                    (((int) (Math.random() * 10)) >= 3 ? "" : (int) (Math.random() * 10) + ""));

            if (w.getDate().equals("")) {
                w.setScore("-- --");
                w.setDate("(미응시)");
                unAdapter.setListData(w);
            } else{
                w.setDate("2023-" + (1 + i % 12) + "-" + (1 + i % 30));
                apAdapter.setListData(w);

            }
        }

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        apReView.setLayoutManager(linearLayoutManager1);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        unReView.setLayoutManager(linearLayoutManager2);

        apReView.setAdapter(apAdapter);
        unReView.setAdapter(unAdapter);

        recyclerViews = new RecyclerView[] {apReView, unReView};
        adapters = new workbookAdapterWbSearchUser[] {apAdapter, unAdapter};
    }

    public void search(View view) {
        String str = searchText.getText().toString().trim();
        searchText.setText("");

        for (int i=0; i<2; i++){
            RecyclerView recyclerView =  recyclerViews[i];
            workbookAdapterWbSearchUser adapter = adapters[i];
            workbookAdapterWbSearchUser newAdapter = new workbookAdapterWbSearchUser();

            int totalUserNum = adapter.getItemCount();

            for (int j = 0; j < totalUserNum; j++) {
                WorkbookWbSearchUser workbook = adapter.getListData(j);
                String workBookName = workbook.getWorkBookName();
                if (workBookName.contains(str)) {
                    newAdapter.setListData(workbook);
                }
            }

            Toast.makeText(getApplicationContext(), "검색 버튼 클릭", Toast.LENGTH_SHORT).show();

            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getApplicationContext());
            linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager1);

            recyclerView.setAdapter(newAdapter);
        }

    }

}

class ViewHolderWbSearchUser extends RecyclerView.ViewHolder {

    public CardView cardView;
    public TextView score, workbookName, lastDate;


    public ViewHolderWbSearchUser(Context context, View itemView) {
        super(itemView);

        cardView = itemView.findViewById(R.id.TestCardView);
        score = itemView.findViewById(R.id.score);
        workbookName = itemView.findViewById(R.id.workbookName);
        lastDate = itemView.findViewById(R.id.lastDate);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 이 자리엔 클릭한 문제집을 화면에 띄우는 코드 작성 필요


                // 아래에 토스트 메시지를 띄우는 코드는 제대로 된 작동을 하는지 테스트를 위한 코드임.
                Toast.makeText(context, workbookName.getText().toString() + " 문제집 클릭", Toast.LENGTH_LONG).show();
            }
        });

    }
}