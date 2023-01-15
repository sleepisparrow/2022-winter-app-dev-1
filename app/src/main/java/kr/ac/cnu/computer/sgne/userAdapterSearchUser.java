package com.example.searchuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class userAdapterSearchUser extends RecyclerView.Adapter<ViewHolderSearchUser> {

    private List<UserSearchUser> list;

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
}

