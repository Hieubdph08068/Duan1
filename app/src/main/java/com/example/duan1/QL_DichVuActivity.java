package com.example.duan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.adapter.DichVuAdapter;
import com.example.duan1.dao.DichVuDao;
import com.example.duan1.model.DichVu;

import java.util.ArrayList;
import java.util.List;

public class QL_DichVuActivity extends AppCompatActivity {
    public static List<DichVu> dsDichVu = new ArrayList<>();
    private ListView lvDichVu;
    private DichVuAdapter adapter = null;
    private DichVuDao dichVuDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Dịch Vụ");
        setContentView(R.layout.activity_ql__dich_vu);
        lvDichVu = findViewById(R.id.lvDichVu);
        dichVuDao = new DichVuDao(QL_DichVuActivity.this);
        dsDichVu = dichVuDao.getAllDichVu();
        adapter = new DichVuAdapter(this, dsDichVu);
        lvDichVu.setAdapter(adapter);
        lvDichVu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(QL_DichVuActivity.this, SuaDichVuActivity.class);
                Bundle b = new Bundle();
                b.putString("MADICHVU", dsDichVu.get(position).getMaDichVu());
                b.putString("TENDICHVU", dsDichVu.get(position).getTenDichVu());
                b.putString("MOTA", dsDichVu.get(position).getMoTa());
                b.putString("GIA", dsDichVu.get(position).getGia());
                intent.putExtras(b);
                startActivity(intent);

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adddv, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void addDichVu(MenuItem item) {
        Intent intent = new Intent(QL_DichVuActivity.this, ThemDichVuActivity.class);
        startActivity(intent);
    }
}
