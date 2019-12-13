package com.example.duan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.dao.DichVuDao;
import com.example.duan1.model.DichVu;

public class ThemDichVuActivity extends AppCompatActivity {
    private EditText edMaDichVu, edTenDichVu, edMoTa, edGia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thêm Dịch Vụ");
        setContentView(R.layout.activity_them_dich_vu);
        edMaDichVu = (EditText) findViewById(R.id.edmadichvu);
        edTenDichVu = (EditText) findViewById(R.id.edTenDichVu);
        edMoTa = (EditText) findViewById(R.id.edMoTa);
        edGia = (EditText) findViewById(R.id.edGia);
    }

    public void addNewDV(View view) {
        DichVuDao dichVuDao = new DichVuDao(ThemDichVuActivity.this);
        try {
            if (validateForm() > 0) {
                DichVu dichVu = new DichVu(edMaDichVu.getText().toString(), edTenDichVu.getText().toString(), edMoTa.getText().toString(), edGia.getText().toString());
                boolean isInsertTrue = dichVuDao.insertDichVu(dichVu);
                if (isInsertTrue) {
                    Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {

        }

    }

    public void showDichVu(View view) {
        Intent intent = new Intent(ThemDichVuActivity.this, QL_DichVuActivity.class);
        startActivity(intent);
    }

    public void cancleDichVu(View view) {
        Intent intent = new Intent(ThemDichVuActivity.this, QL_DichVuActivity.class);
        startActivity(intent);
    }

    public int validateForm() {
        int check = 1;
        if (edMaDichVu.getText().length() == 0 || edTenDichVu.getText().length() == 0 || edMoTa.getText().length() == 0 || edGia.getText().length() == 0) {
            Toast.makeText(this, "Không được để trống", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            check = 1;
        }
        return check;
    }
}
