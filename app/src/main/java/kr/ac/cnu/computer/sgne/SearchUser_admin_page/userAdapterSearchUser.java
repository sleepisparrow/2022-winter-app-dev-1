package kr.ac.cnu.computer.sgne.SearchUser_admin_page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import kr.ac.cnu.computer.sgne.R;

public class userAdapterSearchUser extends RecyclerView.Adapter<userAdapterSearchUser.ViewHolderSearchUser> {

    private List<UserSearchUser> list;
    public CheckUserInfoClickListener listener;

    public void setOnClickListener(CheckUserInfoClickListener listener) {
        this.listener = listener;
    }

    public userAdapterSearchUser() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolderSearchUser onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_user_searchuser, parent, false);

        ViewHolderSearchUser viewHolder = new ViewHolderSearchUser(context, view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSearchUser holder, int position) {

        UserSearchUser user = list.get(position);

        holder.userName.setText(user.getName());
        holder.userGroup.setText(user.getGroup());
        holder.userID.setText(user.getId());
        holder.firstClass.setText(user.getFirstClass());
    }

    public int getItemCount() {
        return list.size();
    }

    public void setListData(UserSearchUser userData) {
        list.add(userData);
    }
    public UserSearchUser getListData(int index) {
        return list.get(index);
    }



    class ViewHolderSearchUser extends RecyclerView.ViewHolder {

        public TextView userName, userGroup, firstClass, userID;
        public Button checkUserInfo;

        public ViewHolderSearchUser(Context context, View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.userName);
            userGroup = itemView.findViewById(R.id.userGroup);
            firstClass = itemView.findViewById(R.id.firstClass);
            userID = itemView.findViewById(R.id.userID);

            checkUserInfo = itemView.findViewById(R.id.checkUserInfo);
            checkUserInfo.setOnClickListener(view -> {
                listener.onClick(view, getAdapterPosition());
                Toast.makeText(context, userName.getText().toString() + " 클릭", Toast.LENGTH_SHORT).show();
            });

        }
    }
}

