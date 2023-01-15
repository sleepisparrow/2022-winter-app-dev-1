package com.example.searchgroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class workbookAdapterSearchGroup extends RecyclerView.Adapter<ViewHolder> {


    // list에는 문제집의 이름, 응시자 수 현황, 모든 응시자의 수의 정보가 담겨있다.
    private List<WorkbookSearchGroup> list;

    public workbookAdapterSearchGroup() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_studybook_searchgroup, parent, false);

        ViewHolder viewHolder = new ViewHolder(context, view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorkbookSearchGroup workbook = list.get(position);

        holder.studybookName.setText(workbook.getWorkBookName());
        holder.personNum.setText(workbook.getPersonNum());
        holder.totalNum.setText(workbook.getTotalNum());
    }

    public int getItemCount() {
        return list.size();
    }

    public void setListData(WorkbookSearchGroup workbookData) {
        list.add(workbookData);
    }
}