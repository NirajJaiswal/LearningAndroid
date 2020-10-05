package com.example.employeedetail.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.R;

public class EmployeeHolder extends RecyclerView.ViewHolder {
    public TextView mNameTextView;
    public TextView mDesignationTextView;
    public ImageView mProfileImageView;


    public EmployeeHolder(@NonNull View itemView) {
        super(itemView);
        mNameTextView=itemView.findViewById(R.id.tv_employee_name);
        mDesignationTextView=itemView.findViewById(R.id.tv_employee_post);
        mProfileImageView=itemView.findViewById(R.id.iv_employee);
    }
}