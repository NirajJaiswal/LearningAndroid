package com.example.employeedetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;
import com.example.employeedetail.model.EmployeeDetails;

import java.util.List;

public class EmployeeAdapter  extends RecyclerView.Adapter<EmployeeHolder> {

    private List<EmployeeDetails> mList;
    private Context mContext;

    public EmployeeAdapter(List<EmployeeDetails> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.list_view_fragment,parent,false);
        return new EmployeeHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {

       holder.mProfileImageView.setImageResource(mList.get(position).getProfile());
        holder.mNameTextView.setText(mList.get(position).getName());
        holder.mDesignationTextView.setText(mList.get(position).getDesignation());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
