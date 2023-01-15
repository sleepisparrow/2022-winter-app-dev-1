package kr.ac.cnu.computer.sgne.SearchGroup_admin_page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kr.ac.cnu.computer.sgne.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class workbookAdapterSearchGroup extends RecyclerView.Adapter<ViewHolderSearchGroup> {


    // list에는 문제집의 이름, 응시자 수 현황, 모든 응시자의 수의 정보가 담겨있다.
    private List<WorkbookSearchGroup> list;

    public workbookAdapterSearchGroup() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolderSearchGroup onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_studybook_searchgroup, parent, false);

        ViewHolderSearchGroup viewHolder = new ViewHolderSearchGroup(context, view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSearchGroup holder, int position) {
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