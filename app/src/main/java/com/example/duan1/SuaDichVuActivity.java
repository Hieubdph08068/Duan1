package com.example.duan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.dao.DichVuDao;
import com.example.duan1.model.DichVu;

public class SuaDichVuActivity extends AppCompatActivity {
    private EditText edTenDichVu, edMoTa, edGia;
    private String edMaDichVu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_dich_vu);
        edTenDichVu = (EditText) findViewById(R.id.edTenDichVu);
        edMoTa = (EditText) findViewById(R.id.edMoTa);
        edGia = (EditText) findViewById(R.id.edGia);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            edMaDichVu = b.getString("MADICHVU");
            edTenDichVu.setText(b.getString("TENDICHVU"));
            edMoTa.setText(b.getString("MOTA"));
            edGia.setText(b.getString("GIA"));

        }
    }

    public void updateDichVu(View view) {
        DichVuDao dichVuDao = new DichVuDao(SuaDichVuActivity.this);

        try {
            DichVu dichVu = new DichVu(edMaDichVu, edTenDichVu.getText().toString(), edMoTa.getText().toString(), edGia.getText().toString());
            if (dichVuDao.updateDichVu(dichVu) > 0) {
                Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Sửa thất bại", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

        }
    }

    public void showDichVu(View view) {
        Intent intent = new Intent(SuaDichVuActivity.this, QL_DichVuActivity.class);
        startActivity(intent);
    }

    public void cancleDichVu(View view) {
        Intent intent = new Intent(SuaDichVuActivity.this, QL_DichVuActivity.class);
        startActivity(intent);
    }
}
