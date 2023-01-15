package kr.ac.cnu.computer.sgne;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class tfAdapter extends RecyclerView.Adapter<tfAdapter.ViewHolder> {
    static int count = 1;
    static int position;
    static ArrayList<tfQuiz> items = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.essay_question, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        tfQuiz item = items.get(position);
        holder.setItem(item);
        getPosition(position);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void addItem(tfQuiz item){
        items.add(item);
    }

    public void getPosition(int position){
        tfAdapter.position = position;
    }

    public void nextCommand(){
        ViewHolder.saveData();
    }

    public void backCommand(tfQuiz item){
        ViewHolder.loadData(item);
    }

    public void refreshCommand(){
        ViewHolder.initData();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        static EditText tfName;
        static EditText tfSolution;
        static Button pro_button;
        static Button con_button;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tfName = itemView.findViewById(R.id.tfName);
            tfSolution = itemView.findViewById(R.id.tfSolution);
            pro_button = itemView.findViewById(R.id.yes_button);
            con_button = itemView.findViewById(R.id.no_button);
        }

        static public void setItem(tfQuiz item){
            tfName.setText("");
            tfSolution.setText("");
        }

        static public void saveData(){
            tfQuiz item = items.get(position);
            item.tfName = tfName.getText().toString();
            item.tfSolution = tfSolution.getText().toString();
        }

        static public void loadData(tfQuiz item){
            tfName.setText(item.tfName);
            tfSolution.setText(item.tfSolution);
        }

        static public void initData(){
            tfName.setText("");
            tfSolution.setText("");
        }
    }
}
