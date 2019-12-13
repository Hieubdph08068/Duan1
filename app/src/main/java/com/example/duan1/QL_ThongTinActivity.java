package com.example.duan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.adapter.ThongTinAdapter;
import com.example.duan1.dao.ThongTinDao;
import com.example.duan1.model.ThongTin;

import java.util.ArrayList;
import java.util.List;

public class QL_ThongTinActivity extends AppCompatActivity {
    public static List<ThongTin> dsThongTin = new ArrayList<>();
    private ListView lvThongTin;
    private ThongTinAdapter adapter;
    private ThongTinDao thongTinDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thông Tin");
        setContentView(R.layout.activity_ql__thong_tin);
        lvThongTin = findViewById(R.id.lvThongTin);
        thongTinDao = new ThongTinDao(QL_ThongTinActivity.this);
        dsThongTin = thongTinDao.getAllThongTin();
        adapter = new ThongTinAdapter(this, dsThongTin);
        lvThongTin.setAdapter(adapter);
        lvThongTin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(QL_ThongTinActivity.this, ThongTinActivity.class);
                Bundle b = new Bundle();
                b.putString("MATHONGTIN", dsThongTin.get(position).getMaHoaDon());
                b.putString("NGAY", dsThongTin.get(position).getNgay());
                b.putString("TENVATNUOI", dsThongTin.get(position).getTenVatNuoi());
                b.putString("CANNANG", dsThongTin.get(position).getCanNang());
                b.putString("DACDIEM", dsThongTin.get(position).getDacDiem());
                b.putString("SDT", dsThongTin.get(position).getSoDienThoai());
                b.putString("MADICHVU", dsThongTin.get(position).getMaDichVu());
                b.putString("GHICHU", dsThongTin.get(position).getGhiChu());
                intent.putExtras(b);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addhd, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void add(MenuItem item) {
        Intent intent = new Intent(QL_ThongTinActivity.this, ThemThongTinActivity.class);
        startActivity(intent);
    }
}
