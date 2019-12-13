package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgVatNuoi,imgDichVu,imgThongTin,imgThongKe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Quản Lý Vật Nuôi");
        imgVatNuoi=findViewById(R.id.imgVatNuoi);
        imgDichVu=findViewById(R.id.imgDichVu);
        imgThongTin=findViewById(R.id.imgThongTin);
        imgThongKe=findViewById(R.id.imgThongKe);

        imgVatNuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, QL_VatNuoiActivity.class);
                startActivity(intent);
            }
        });
        imgDichVu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,QL_DichVuActivity.class);
                startActivity(intent);
            }
        });
        imgThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, QL_ThongTinActivity.class);
                startActivity(intent);
            }
        });

    }
}
