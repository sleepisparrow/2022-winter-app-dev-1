package kr.ac.cnu.computer.sgne;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class groupAdapter extends RecyclerView.Adapter<groupAdapter.ViewHolder> {
    ArrayList<group> items = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_group, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        group item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(group item){
        items.add(item);
    }
    public void setItems(ArrayList<group> items){
        this.items = items;
    }
    public group getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, group item){
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView groupName;
        TextView personNum;
        TextView totalNum;
        TextView firstLecture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            groupName = itemView.findViewById(R.id.groupName);
            personNum = itemView.findViewById(R.id.personNum);
            totalNum = itemView.findViewById(R.id.totalNum);
            firstLecture = itemView.findViewById(R.id.firstLecture);
        }

        public void setItem(group item){
            groupName.setText(item.getGroupName());
            personNum.setText(String.valueOf(item.getPersonNum()));
            totalNum.setText(String.valueOf(item.getTotalNum()));
            firstLecture.setText(item.getFirstLecture());
        }
    }

}
