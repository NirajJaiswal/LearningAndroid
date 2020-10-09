package com.example.employeedetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedetail.adapter.StartRecyclerAdapter;
import com.example.employeedetail.addfrag.AddActivity;
import com.example.employeedetail.fragcommunication.FragActivity;
import com.example.employeedetail.listner.ButtonListener;
import com.example.employeedetail.model.ButtonModel;
import com.example.employeedetail.navigation.NavigationActivity;
import com.example.employeedetail.snackbar.SnackBarActivity;
import com.example.employeedetail.spinner.CustomSpinnerActivity;
import com.example.employeedetail.spinner.SpinnerActivity;
import com.example.employeedetail.tab.TabLayoutActivity;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity  implements ButtonListener {
   private RecyclerView recyclerView;
    private Toolbar toolbar;
    private Boolean isListView;
    private  StartRecyclerAdapter startRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        isListView=true;
        initView();
        setValue();
    }
    private void setValue() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        startRecyclerAdapter=new StartRecyclerAdapter(this,loadData());
        recyclerView.setAdapter(startRecyclerAdapter);
    }

    private void initView() {
        recyclerView=findViewById(R.id.rv_button);
        toolbar = findViewById(R.id.toolbar_start);
        toolbar.setTitle("Start Screen");
        setSupportActionBar(toolbar);
    }
    private List<ButtonModel> loadData()
    {
        List<ButtonModel>list=new ArrayList<>();
        list.add(new ButtonModel(1,"Recycler View"));
        list.add(new ButtonModel(2,"Fragment"));
        list.add(new ButtonModel(3,"Add Fragment"));
        list.add(new ButtonModel(4,"Fragment Communication"));
        list.add(new ButtonModel(5,"Tab Layout"));
        list.add(new ButtonModel(6,"Spinner"));
        list.add(new ButtonModel(7,"Custom Spinner"));
        list.add(new ButtonModel(8,"Snack Bar"));
        list.add(new ButtonModel(9,"Floating Action Bar"));
        list.add(new ButtonModel(10,"Navigation Drawer"));
        list.add(new ButtonModel(11,"Cricket"));
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
                 intent=new Intent(StartActivity.this, NavigationActivity.class);
                 startActivity(intent);
                 break;
            case 3:
                intent =new Intent(StartActivity.this, AddActivity.class);
                String name="Shreya";
                intent.putExtra("key_1",name);
                startActivity(intent);
                break;
            case 4:
                intent=new Intent(StartActivity.this, FragActivity.class);
                startActivity(intent);
                break;
             case 5:
                 intent =new Intent(StartActivity.this, TabLayoutActivity.class);
                 startActivity(intent);
                 break;
            case 6:
                intent =new Intent(StartActivity.this, SpinnerActivity.class);
                startActivity(intent);
                break;
            case 7:
                intent=new Intent(StartActivity.this, CustomSpinnerActivity.class);
                startActivity(intent);
                break;
            case 8:
                intent=new Intent(StartActivity.this, SnackBarActivity.class);
                startActivity(intent);
                break;
            case 9:
                intent=new Intent(StartActivity.this, FloatingActionBarActivity.class);
                startActivity(intent);
                break;
            case 10:
                intent=new Intent(StartActivity.this,NavigationDrawerActivity.class);
                startActivity(intent);
                break;
            case 11:
                intent=new Intent(StartActivity.this,CricketActivity.class);
                startActivity(intent);
                break;
            default:

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_start, menu);
        MenuItem searchItem=menu.findItem(R.id.search_menu);
        SearchView searchView=(SearchView)searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                startRecyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if(isListView)
        {
            menu.findItem(R.id.view_type).setTitle("List View");
            isListView=false;
        }
        else
        {
            menu.findItem(R.id.view_type).setTitle("Grid View");
            isListView=true;

        }
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.view_type) {
            recyclerView.setLayoutManager(!isListView ? new LinearLayoutManager(this) : new GridLayoutManager(this, 3));
            startRecyclerAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}