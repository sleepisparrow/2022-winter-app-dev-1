package kr.ac.cnu.computer.sgne;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder>{
    ArrayList<Quiz> items = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.quiz_layout, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder, int position) {
        Quiz item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Quiz item){
        items.add(item);
    }

    public void setItems(ArrayList<Quiz> items){
        this.items = items;
    }

    public Quiz getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Quiz item){
        items.set(position,item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView record_num;
        TextView CA;
        TextView WA;

        public ViewHolder(View itemView) {
            super(itemView);

            record_num = itemView.findViewById(R.id.record_num);
            CA = itemView.findViewById(R.id.correct_answers);
            WA = itemView.findViewById(R.id.wrong_answers);
        }

        public void setItem(Quiz item){
            record_num.setText(item.getLibrary_num());
            CA.setText(item.getCorrect_answers());
            WA.setText(item.getWrong_answers());
        }
    }
}
