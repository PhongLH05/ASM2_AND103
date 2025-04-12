package com.ph30891.asm_ph30891_gd2.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ph30891.asm_ph30891_gd2.R;
import com.ph30891.asm_ph30891_gd2.adapter.ItemImageAdapter;
import com.ph30891.asm_ph30891_gd2.databinding.ActivityDetailsBinding;
import com.ph30891.asm_ph30891_gd2.model.Fruit;

public class DetailsActivity extends AppCompatActivity {
    com.ph30891.asm_ph30891_gd2.databinding.ActivityDetailsBinding binding;
    Fruit fruit;
    private ItemImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);

        setContentView(binding.getRoot());

        showData();

        binding.btnBack.setOnClickListener(view -> finish());

    }

    private void showData() {
        Intent intent = getIntent();
        fruit = (Fruit) intent.getSerializableExtra("fruit");

        binding.tvName.setText("Name: " + fruit.getName());
        binding.tvPrice.setText("Price: " + fruit.getPrice());
        binding.tvDescription.setText("Description: " + fruit.getDescription());
        binding.tvQuantity.setText("Quantity: " + fruit.getQuantity());
        binding.tvStatus.setText("Status: "+fruit.getStatus());


        adapter = new ItemImageAdapter(this, fruit.getImages());
        binding.rcvImg.setAdapter(adapter);
    }
}
