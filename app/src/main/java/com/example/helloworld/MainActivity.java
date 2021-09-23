package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helloworld.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Ver 1.0
//    private TextView tvCount;
//    private FloatingActionButton btnAdd;
//    private FloatingActionButton btnSubtract;
    //Ver 1.0

    private MyViewModel model;

    //Ver 1.0
//    private ListView lvCount;
    //Ver 1.0
    private ArrayList<Integer> arrayList;
    private ArrayAdapter<Integer> arrayAdapter;

    /*Auto binding component in xml*/
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ver 1.0
        //        setContentView(R.layout.activity_main);
        //Ver 1.0

        //ADD By thanhbtde140273 Ver 1.1
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);
        //ADD By thanhbtde140273 Ver 1.1

        model = new ViewModelProvider(this).get(MyViewModel.class);

        //Ver 1.0
//        tvCount = findViewById(R.id.tv_count);
//        btnAdd = findViewById(R.id.btn_add);
//        btnSubtract = findViewById(R.id.btn_subtract);
//
//        lvCount = findViewById(R.id.lv_count);
        //Ver 1.0

        arrayList = model.getListInt();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        binding.lvCount.setAdapter(arrayAdapter);

        model.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.tvCount.setText("" + integer);
                model.addToList(integer);
                arrayList = model.getListInt();
                arrayAdapter.notifyDataSetChanged();
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.increaseNumber();
            }
        });

        binding.btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.decreaseNumber();
            }
        });

        binding.lvCount.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                model.removeFromList(position);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

        binding.lvCount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("number", model.getListInt().get(position).toString());
                startActivity(intent);
            }
        });
    }

}