package com.example.employeedetail.employee_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.employeedetail.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetMedicine extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            return inflater.inflate(R.layout.bottom_sheet_layput, container, false);
    }
}