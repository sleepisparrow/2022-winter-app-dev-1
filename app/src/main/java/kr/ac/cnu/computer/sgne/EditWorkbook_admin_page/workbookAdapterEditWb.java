package com.example.eidtworkbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class workbookAdapterEditWb extends RecyclerView.Adapter<ViewHolderEditWb> {


    // list에는 문제집의 이름, 응시자 수 현황, 모든 응시자의 수의 정보가 담겨있다.
    private List<WorkbookEditWb> list;

    public workbookAdapterEditWb() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolderEditWb onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_studybook_editwb, parent, false);

        ViewHolderEditWb viewHolder = new ViewHolderEditWb(context, view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEditWb holder, int position) {

        WorkbookEditWb workbook = list.get(position);
        ProblemEditWb problem = workbook.getProblems().get(0);

        holder.problemTitle.setText(problem.getTitle());
        holder.problemNum.setText(problem.getNumber()+"");
        holder.problemText.setText(problem.getText());
//        holder.studybookName.setText(workbook.getWorkBookName());
//        holder.personNum.setText(workbook.getPersonNum());
//        holder.totalNum.setText(workbook.getTotalNum());
    }

    public int getItemCount() {
        return list.size();
    }

    public void setListData(WorkbookEditWb workbookData) {
        list.add(workbookData);
    }
}