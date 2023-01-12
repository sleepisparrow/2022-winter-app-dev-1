package kr.ac.cnu.computer.sgne.admin_page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kr.ac.cnu.computer.sgne.R;

public class Main_admin_adapter extends RecyclerView.Adapter<Main_admin_adapter.Main_admin_viewHolder> {

    public List<Group> list = new ArrayList<>();

    public interface OnMainAdapterClickListener {
        void on_ranking_check_button_click(View itemView, int pos);
        void on_manage_group_button_click(View itemView, int pos);
    }

    private OnMainAdapterClickListener listener = null;

    public void setListener(OnMainAdapterClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Main_admin_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_main_recycle, parent, false);
        return new Main_admin_viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Main_admin_viewHolder holder, int position) {
        Group g = list.get(position);
        holder.class_name.setText(g.name);
        holder.class_count.setText(g.student_count + "/50");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Main_admin_viewHolder extends RecyclerView.ViewHolder {
        View ranking_check_button, manage_group_button;
        TextView class_name, class_count;

        public Main_admin_viewHolder(@NonNull View itemView) {
            super(itemView);

            ranking_check_button = itemView.findViewById(R.id.ranking_check_button);
            manage_group_button = itemView.findViewById(R.id.manage_group_button);

            class_name = itemView.findViewById(R.id.class_name);
            class_count = itemView.findViewById(R.id.class_count);

            ranking_check_button.setOnClickListener(v -> {
                listener.on_ranking_check_button_click(itemView, getAdapterPosition());
            });

            manage_group_button.setOnClickListener(v -> {
                listener.on_manage_group_button_click(itemView, getAdapterPosition());
            });
        }
    }
}
