package kr.ac.cnu.computer.sgne.main_page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kr.ac.cnu.computer.sgne.R;

public class main_activity_adapter extends RecyclerView.Adapter<main_activity_adapter.main_page_view_holder> {
    public List<problem_set> list = new ArrayList<>();

    public void setList(List<problem_set> list) {
        this.list = list;
    }

    public void add(problem_set p) {
        list.add(p);
    }

    public interface OnItemClickListener {
        public void onClick(View view, int pos);
    }

    private OnItemClickListener itemListener = null;

    public void setItemListener(OnItemClickListener listener) {
        this.itemListener = listener;
    }

    @NonNull
    @Override
    public main_page_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler, parent, false);
        return new main_page_view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull main_page_view_holder holder, int position) {
        problem_set p = list.get(position);
        holder.problem_set_name.setText(p.test_name);
        String score = "점수: " + (p.correct / p.problems) + " / 100";
        holder.problem_set_score.setText(score);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class main_page_view_holder extends RecyclerView.ViewHolder {
        TextView problem_set_name, problem_set_score;


        LinearLayout layout;
        public main_page_view_holder(@NonNull View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.problem_set_layout);
            problem_set_name = itemView.findViewById(R.id.problem_set_name);
            problem_set_score = itemView.findViewById(R.id.problem_set_score);

            layout.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                itemListener.onClick(itemView, pos);
            });
        }
    }
}
