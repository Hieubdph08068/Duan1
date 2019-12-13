package com.example.duan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.dao.VatNuoiDao;
import com.example.duan1.model.VatNuoi;

public class SuaVatNuoiActivity extends AppCompatActivity {
    private String MaVn;
    private EditText edTenVn;
    private EditText edLoai;
    private EditText edDacdiem;
    private EditText edCannang;
    private EditText edGia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_vat_nuoi);
        setTitle("Sửa thông tin vật nuôi");
        edTenVn = (EditText) findViewById(R.id.edtenvn);
        edLoai = (EditText) findViewById(R.id.edloai);
        edDacdiem = (EditText) findViewById(R.id.eddacdiem);
        edCannang = (EditText) findViewById(R.id.edcannang);
        edGia = (EditText) findViewById(R.id.edgia);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            MaVn = b.getString("MAVATNUOI");
            edTenVn.setText(b.getString("TENVATNUOI"));
            edLoai.setText(b.getString("LOAI"));
            edDacdiem.setText(b.getString("DACDIEM"));
            edCannang.setText(b.getString("CANNANG"));
            edGia.setText(b.getString("GIA"));
        }
    }

    public void updateVatNuoi(View view) {
        VatNuoiDao vatNuoiDao = new VatNuoiDao(SuaVatNuoiActivity.this);

        try {
            VatNuoi vatNuoi = new VatNuoi(MaVn, edTenVn.getText().toString(), edLoai.getText().toString(), edDacdiem.getText().toString(), edCannang.getText().toString(), edGia.getText().toString());
            if (vatNuoiDao.updatevn(vatNuoi) > 0) {
                Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Sửa thất bại", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

        }
    }

    public void show(View view) {
        Intent intent = new Intent(SuaVatNuoiActivity.this, QL_VatNuoiActivity.class);
        startActivity(intent);
    }

    public void cancle(View view) {
        Intent intent = new Intent(SuaVatNuoiActivity.this, QL_VatNuoiActivity.class);
        startActivity(intent);
    }

}
