package com.example.employeedetail;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.adapter.StartRecyclerAdapter;
import com.example.employeedetail.listner.ButtonListener;
import com.example.employeedetail.model.ButtonModel;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity  implements ButtonListener {
   private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
        setValue();
    }
    private void setValue() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StartRecyclerAdapter startRecyclerAdapter=new StartRecyclerAdapter(this,loadData());
        recyclerView.setAdapter(startRecyclerAdapter);
    }

    private void initView() {
        recyclerView=findViewById(R.id.rv_button);
    }
    private List<ButtonModel> loadData()
    {
        List<ButtonModel>list=new ArrayList<>();
        list.add(new ButtonModel(1,"Recycler View"));
        list.add(new ButtonModel(2,"Fragment"));
        list.add(new ButtonModel(3,"Add Fragment"));
        list.add(new ButtonModel(4,"Fragment Communication"));
        list.add(new ButtonModel(5,"Tab Layout"));
        return list;
    }

    @Override
    public void clickButton(int id) {
        Intent intent;
        switch (id)
        {
            case 1:
                 intent=new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case 2:
                 intent=new Intent(StartActivity.this,NavigationActivity.class);
                 startActivity(intent);
                 break;
            case 3:
                intent =new Intent(StartActivity.this,AddActivity.class);
                String name="Shreya";
                intent.putExtra("key_1",name);
                startActivity(intent);
                break;
            case 4:
                intent=new Intent(StartActivity.this, FragActivity.class);
                startActivity(intent);
                break;
             case 5:
                 intent =new Intent(StartActivity.this,TabLayoutActivity.class);
                 startActivity(intent);
            default:

        }

    }
}