package kr.ac.cnu.computer.quizcreater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class choiceAdapter extends RecyclerView.Adapter<choiceAdapter.ViewHolder>{
    static int count = 1;
    static ArrayList<multipleQuiz> items = new ArrayList();
    static int position;


    @NonNull
    @NotNull
    @Override
    public choiceAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.multiple_choice, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull choiceAdapter.ViewHolder holder, int position) {
        multipleQuiz item = items.get(position);
        holder.setItem(item);
        getPosition(position);
    }

    @Override
    public int getItemCount() {
        //문제 객체를 하나만 만들면 되니까 개수 1을 반환
        return 1;
    }

    public void addItem(multipleQuiz item){
        items.add(item);
    }

    public void getPosition(int position) { this.position = position; }

    public void nextCommand(){
        ViewHolder.saveData();
    }

    public void backCommand(multipleQuiz item){
        ViewHolder.loadData(item);
    }

    public void refreshCommand(){
        ViewHolder.initData();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        static TextView testNum;

        static EditText solution;
        static EditText script1;
        static EditText script2;
        static EditText script3;
        static EditText script4;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            testNum = itemView.findViewById(R.id.testNum);

            solution = itemView.findViewById(R.id.solution);
            script1 = itemView.findViewById(R.id.script1);
            script2 = itemView.findViewById(R.id.script2);
            script3 = itemView.findViewById(R.id.script3);
            script4 = itemView.findViewById(R.id.script4);
        }

        public void setItem(multipleQuiz item){
            testNum.setText(count+"");
            solution.setText("");
            script1.setText("");
            script2.setText("");
            script3.setText("");
            script4.setText("");
        }

        //현재 작성한 정보를 저장하는 작업을 수행
        static public void saveData(){
            multipleQuiz item = items.get(position);
            item.solution = solution.getText().toString();
            item.script1 = script1.getText().toString();
            item.script2 = script2.getText().toString();
            item.script3 = script3.getText().toString();
            item.script4 = script4.getText().toString();
        }

        static public void loadData(multipleQuiz item){
            testNum.setText(count+"");
            solution.setText(item.solution);
            script1.setText(item.script1);
            script2.setText(item.script2);
            script3.setText(item.script3);
            script4.setText(item.script4);
        }

        static public void initData(){
            testNum.setText(count+"");
            solution.setText("");
            script1.setText("");
            script2.setText("");
            script3.setText("");
            script4.setText("");
        }
    }
}


