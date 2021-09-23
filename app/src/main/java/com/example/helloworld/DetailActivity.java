package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

//    private TextView tvDetail;
//    private EditText etText;

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

//        tvDetail = findViewById(R.id.tv_detail);
//        etText = findViewById(R.id.et_binding);

        Intent receiveIntent = getIntent();

        if (receiveIntent != null) {
            String data = receiveIntent.getStringExtra("number");
            binding.tvDetail.setText(data);
            binding.etBinding.setText(data);
        }

        binding.etBinding.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.setNumInp(binding.etBinding.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}