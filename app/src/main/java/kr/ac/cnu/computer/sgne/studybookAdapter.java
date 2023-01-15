package kr.ac.cnu.computer.sgne;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class studybookAdapter extends RecyclerView.Adapter<studybookAdapter.ViewHolder> implements OnStudybookClickListener{

    ArrayList<studybook> items = new ArrayList();
    OnStudybookClickListener listener;
    int selectedPos = RecyclerView.NO_POSITION; // 클릭X --> -1

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_studybook, parent, false);

        return new ViewHolder(itemView, this);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        studybook item = items.get(position);
        holder.setItem(item);
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(studybook item){
        items.add(item);
    }
    public void setItems(ArrayList<studybook> items){
        this.items = items;
        notifyDataSetChanged();
    }
    public studybook getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, studybook item){
        items.set(position, item);
    }
    public void setOnItemClickListener(OnStudybookClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    /**
     * ViewHolder
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView studybookName;
        TextView personNum;
        TextView totalNum;

        public ViewHolder(View itemView, final OnStudybookClickListener listener){
            super(itemView);

            studybookName = itemView.findViewById(R.id.studybookName);
            personNum = itemView.findViewById(R.id.personNum);
            totalNum = itemView.findViewById(R.id.totalNum);

            /**
             * item 클릭시 이벤트 처리
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(studybook item){
            studybookName.setText(item.getStudybookName());
            personNum.setText(String.valueOf(item.getPersonNum()));
            totalNum.setText(String.valueOf(item.getTotalNum()));
        }

    }

}

