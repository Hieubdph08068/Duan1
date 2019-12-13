package com.example.duan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.dao.VatNuoiDao;
import com.example.duan1.model.VatNuoi;

public class ThemVatNuoiActivity extends AppCompatActivity {
    private EditText edMaVatNuoi;
    private EditText edTenVn;
    private EditText edLoai;
    private EditText edDacdiem;
    private EditText edCannang;
    private EditText edGia;
    VatNuoiDao vatNuoiDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thêm Vật Nuôi");
        setContentView(R.layout.activity_them_vat_nuoi);
        edMaVatNuoi = (EditText) findViewById(R.id.edmavn);
        edTenVn = (EditText) findViewById(R.id.edtenvn);
        edLoai = (EditText) findViewById(R.id.edloai);
        edDacdiem = (EditText) findViewById(R.id.eddacdiem);
        edCannang = (EditText) findViewById(R.id.edcannang);
        edGia = (EditText) findViewById(R.id.edgia);

    }

    public void show(View view) {
        Intent intent = new Intent(ThemVatNuoiActivity.this, QL_VatNuoiActivity.class);
        startActivity(intent);
    }

    public void cancle(View view) {
        Intent intent = new Intent(ThemVatNuoiActivity.this, QL_VatNuoiActivity.class);
        startActivity(intent);
    }

    public int validateForm() {
        int check = 1;
        if (edTenVn.getText().length() == 0 || edLoai.getText().length() == 0 || edDacdiem.getText().length() == 0 || edGia.getText().length() == 0 || edCannang.getText().length() == 0) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            check = 1;
        }
        return check;
    }

    public void addnewvatnuoi(View view) {
        vatNuoiDao = new VatNuoiDao(ThemVatNuoiActivity.this);
        try {
            if (validateForm() > 0) {
                VatNuoi vatNuoi = new VatNuoi(edMaVatNuoi.getText().toString(), edTenVn.getText().toString(), edLoai.getText().toString(), edDacdiem.getText().toString(), edCannang.getText().toString(), edGia.getText().toString());
                boolean isInsertTrue = vatNuoiDao.insertVatNuoi(vatNuoi);
                if (isInsertTrue) {
                    Toast.makeText(this, "Thêm vật nuôi mới thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Thêm vật nuôi mới thất bại", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {

        }

    }
}
