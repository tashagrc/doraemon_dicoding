package com.example.doraemon_dicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailAlatActivity extends AppCompatActivity {

    public static final String ITEM_EXTRA = "item_extra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_alat);

        ImageView imgAlat = findViewById(R.id.imageDetail);
        TextView tvAlatTitle = findViewById(R.id.titleDetail);
        TextView tvAlatDesc = findViewById(R.id.descDetail);

        Alat alat = getIntent().getParcelableExtra(ITEM_EXTRA);
        if(alat != null) {
            Glide.with(this).load(alat.getImage()).into(imgAlat);
            tvAlatTitle.setText(alat.getTitle());
            tvAlatDesc.setText(alat.getDesc());
        }

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(alat.getTitle() + " Detail");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}