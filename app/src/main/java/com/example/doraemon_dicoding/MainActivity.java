package com.example.doraemon_dicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvAlat;
    private ArrayList<Alat> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Alat Doraemon");

        rvAlat = findViewById(R.id.rv_alat);
        rvAlat.setHasFixedSize(true);

        list.addAll(AlatData.getListData());
        showRecyclerList();

    }

    private void showRecyclerList() {
        rvAlat.setLayoutManager(new LinearLayoutManager(this));
        ListAlatAdapter listAlatAdapter = new ListAlatAdapter(list);
        rvAlat.setAdapter(listAlatAdapter);

        // bisa ke detail
        listAlatAdapter.setOnItemClickCallback(new OnItemClickCallback() {
            @Override
            public void onItemClicked(Alat alat) {
                Intent intent = new Intent(MainActivity.this, DetailAlatActivity.class);
                intent.putExtra(DetailAlatActivity.ITEM_EXTRA, alat);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.homeItem) {

        }
        else if(item.getItemId() == R.id.aboutItem) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}