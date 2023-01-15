package com.example.workbookserch_user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class workbookAdapterWBSearchUser extends RecyclerView.Adapter<ViewHolder> {
    private List<WorkbookWBSearchUser> list;

    public workbookAdapterWBSearchUser() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_studybook, parent, false);

        ViewHolder viewHolder = new ViewHolder(context, view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorkbookWBSearchUser workbook = list.get(position);

        holder.lastDate.setText(workbook.getDate());
        holder.score.setText(workbook.getScore()+"");
        holder.workbookName.setText(workbook.getWorkBookName());

    }

    public int getItemCount() {
        return list.size();
    }

    public void setListData(WorkbookWBSearchUser workbook) {
        list.add(workbook);
    }

    public WorkbookWBSearchUser getListData(int index) {
        return list.get(index);
    }
}