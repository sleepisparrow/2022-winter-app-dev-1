package kr.ac.cnu.computer.sgne.EditWorkbook_admin_page;

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
public class MainActivityEditWb extends AppCompatActivity {
    String[] tmp = new String[] {"수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.\n예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.",
            "재원이는 한 도시의 시장이 되었다. 이 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다. 하지만 재원이는 다리가 없어서 시민들이 강을 건너는데 큰 불편을 겪고 있음을 알고 다리를 짓기로 결심하였다. 강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 한다. 재원이는 강 주변을 면밀히 조사해 본 결과 강의 서쪽에는 N개의 사이트가 있고 동쪽에는 M개의 사이트가 있다는 것을 알았다.\n재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다. (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.) 재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다. 다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.",
            "LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.\n예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.",
            "세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다. 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다. 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.",
            "N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.",
            "첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.",
            "첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.",
            "입력은 하나 또는 그 이상의 테스트 케이스로 이루어져 있다. 테스트 케이스의 개수는 100,000개를 넘지 않는다.",
            "각 테스트 케이스에 대해서, n = a + b 형태로 출력한다. 이때, a와 b는 홀수 소수이다. 숫자와 연산자는 공백 하나로 구분되어져 있다. 만약, n을 만들 수 있는 방법이 여러 가지라면, b-a가 가장 큰 것을 출력한다. 또, 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에는 \"Goldbach's conjecture is wrong.\"을 출력한다.",
            "입력이 주어진다. 입력은 최대 100줄로 이루어져 있고, 알파벳 소문자, 대문자, 공백, 숫자로만 이루어져 있다. 각 줄은 100글자를 넘지 않으며, 빈 줄은 주어지지 않는다. 또, 각 줄은 공백으로 시작하지 않고, 공백으로 끝나지 않는다.",
            "효빈이의 비밀 박스에는 조약돌이 N개 들어있다. 조약돌의 색상은 1부터 M까지 중의 하나이다.\n비밀 박스에서 조약돌을 랜덤하게 K개 뽑았을 때, 뽑은 조약돌이 모두 같은 색일 확률을 구하는 프로그램을 작성하시오. ",
            "민수는 같은 반 친구들과 369게임을 하고 있다. 369게임은 여러 명이 원형으로 둘러 앉아 시작 위치의 사람이 1을 외치며 시작된다. 이후 시계방향으로 돌아가며 2, 3, 4와 같이 1씩 증가된 수가 자기 수가 된다. 순서대로 돌아오는 자기 수에 3, 6, 혹은 9가 포함되어 있지 않다면 그 수를 말해야 하며, 3, 6, 혹은 9가 포함되어 있으면 그 개수만큼 박수를 쳐야 한다. 이 규칙을 지키지 못하면 게임이 종료된다.",
            "민수는 369게임이 N까지 규칙을 지키며 진행된다면 그때까지의 들은 박수의 횟수 가 총 몇 번인지 궁금했다. 예를 들어 N = 14라면, 3, 6, 9, 13에서 각각 한 번의 박 수를 치게 되므로 총 4회의 박수를 듣게 될 것이다. N = 36이라면 3, 6, 9, 13, 16. 19. 23. 26. 29. 30. 31. 32. 33. 34. 35, 36에서 박수를 치게 되는데 33, 36에서는 각 각 두 번 박수를 쳐야 하므로 총 18회가 된다. 1 이상의 정수 N에 대하여 369게임을 N까지 규칙을 지키며 진행된다면 그때까지 듣게 되는 박수의 총 횟수를 계산하여 출력하는 프로그램을 작성하시오."};
    String[] tmp2 = new String[] {"LIS", "다리 이어주기", "LCS", "행렬 덧셈", "행렬 덧셈 입력 설명", "Problem", "Example", "예시1", "아아아아", "컴퓨터활용능력시험 모의고사 1회 글자길이는 어느정도가 최대?"};

    RecyclerView recyclerView;
    workbookAdapterEditWb adapter;
    Button completion, cancel;
    EditText workbookName, openGroup, capacityNum;
    CardView tabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_editwb);

        completion = findViewById(R.id.completion);
        cancel = findViewById(R.id.cancel);
        workbookName = findViewById(R.id.workbookName);
        openGroup = findViewById(R.id.openGroup);
        capacityNum = findViewById(R.id.capacityNum);

        tabBar = findViewById(R.id.tabBarCardView);
        tabBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"탭바 메뉴 여는 액티비티 넣을 예정",Toast.LENGTH_SHORT).show();
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.workbook_recyclerview);
        adapter = new workbookAdapterEditWb();


        for (int i=0; i<tmp.length; i++) {
            WorkbookEditWb workbook = new WorkbookEditWb("컴활 "+(i+1)+"급", "10", "30");
            workbook.addProblem(new ProblemEditWb(tmp2[i % tmp2.length], tmp[i], i+1));
            adapter.setListData(workbook);
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
    }

    public void CompletionClick(View view) {
        /*
            문제집의 이름을 수정한다.
         */

        Toast.makeText(getApplicationContext(), "문제집 이름을 \"" + workbookName.getText().toString() +"\"으로 변경합니다.\n"+
                "공개 분반을 \"" + openGroup.getText().toString() +"\"으로 변경합니다.\n"+
                "응시 정원을 \"" + capacityNum.getText().toString() +"\"으로 변경합니다.", Toast.LENGTH_SHORT).show();
    }

    public void CancelClick(View view){
        adapter = new workbookAdapterEditWb();
        recyclerView.setAdapter(adapter);

        workbookName.setText("");
        openGroup.setText("");
        capacityNum.setText("");

        /*
            이전 액티비티로 돌아가도록 함.
         */
        Toast.makeText(getApplicationContext(), "이전 화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
    }
}

class ViewHolderEditWb extends RecyclerView.ViewHolder {

    public TextView problemNum, problemText, problemTitle;
    public CardView cardView;

    public ViewHolderEditWb(Context context, View itemView) {
        super(itemView);

        problemNum = itemView.findViewById(R.id.problemNum); // 문항 번호
        problemTitle = itemView.findViewById(R.id.problemTitle); // 문제 title
        problemText = itemView.findViewById(R.id.problemText); // 문제 지문

        cardView = itemView.findViewById(R.id.workbookCardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 문제집 수정2 로 액티비티를 올린다.


                // 아래에 토스트 메시지를 띄우는 코드는 제대로 된 작동을 하는지 테스트를 위한 코드임.
                Toast.makeText(context, problemNum.getText().toString() + "번 문제 클릭", Toast.LENGTH_SHORT).show();
            }
        });
    }
}