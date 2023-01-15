package kr.ac.cnu.computer.sgne;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rankingAdapter extends RecyclerView.Adapter<rankingAdapter.ViewHolder>{
    ArrayList<ranking> items = new ArrayList();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_ranking, parent, false);

        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ranking item = items.get(position);
        holder.setItem(item);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(ranking item){
        items.add(item);
    }
    public void setItems(ArrayList<ranking> items){
        this.items = items;
    }
    public ranking getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, ranking item){
        items.set(position, item);
    }

    //===========================================================
    // 각각의 아이템은 뷰로 만들어지며, 각각의 아이템을 위한 뷰는 뷰홀더에 담아두게 됨.
    // 이 뷰홀더 역할을 하는 클래스를 rankingAdapter클래스 안에 넣어둔다고 생각하자.
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView rankingNum;
        TextView studentName;
        TextView studentScore;

        public ViewHolder(View itemView) {
            super(itemView);

            rankingNum = itemView.findViewById(R.id.rankingNum);
            studentName = itemView.findViewById(R.id.studentName);
            studentScore = itemView.findViewById(R.id.studentScore);
        }

        public void setItem(ranking item){
            studentName.setText(item.getStudentName());
            rankingNum.setText(String.valueOf(item.getRankingNum()));
            studentScore.setText(String.valueOf(item.getStudentScore()));
        }
    }

}
