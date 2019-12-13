package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThongTinActivity extends AppCompatActivity {
    private TextView tvMaPhieu;
    private TextView tvNgay;
    private TextView tvTenVATNUOI;
    private TextView tvCanNang;
    private TextView tvDacDiem;
    private TextView tvSDT;
    private TextView tvMadichvu;
    private TextView tvTrangThai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        Intent intent = getIntent();
        tvMaPhieu=(TextView)findViewById(R.id.tvmahoadon);
        tvNgay=(TextView)findViewById(R.id.tvngay);
        tvTenVATNUOI=(TextView)findViewById(R.id.tvtenvatnuoi);
        tvCanNang=(TextView)findViewById(R.id.tvcannang);
        tvDacDiem=(TextView)findViewById(R.id.tvdacdiem);
        tvSDT=(TextView)findViewById(R.id.tvsodt);
        tvMadichvu=(TextView)findViewById(R.id.tvMadichVu);
        tvTrangThai=(TextView)findViewById(R.id.tvTinhTrang);
        Bundle b = intent.getExtras();
        if (b != null) {
            tvMaPhieu.setText(b.getString("MATHONGTIN"));
            tvNgay.setText(b.getString("NGAY"));
            tvTenVATNUOI.setText(b.getString("TENVATNUOI"));
            tvCanNang.setText(b.getString("CANNANG"));
            tvDacDiem.setText(b.getString("DACDIEM"));
            tvSDT.setText(b.getString("SDT"));
            tvMadichvu.setText(b.getString("MADICHVU"));
            tvTrangThai.setText(b.getString("TRANGTHAI"));
        }
    }
}
