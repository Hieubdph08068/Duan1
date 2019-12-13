package com.example.duan1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.duan1.dao.DichVuDao;
import com.example.duan1.dao.ThongTinDao;
import com.example.duan1.model.DichVu;
import com.example.duan1.model.ThongTin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ThemThongTinActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private DichVuDao dichVuDao;
    private Spinner spnDichVu, spnTinhTrang;
    private List<DichVu> listDichVu = new ArrayList<>();
    private String arrTT[] = {"Tốt", "Khá", "Trung Bình", "Kém"};
    private String Madichvu = "", TinhTrang = "";
    private EditText edNgay;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private EditText edMaHoaDon;
    private EditText edTenVatNuoi;
    private EditText edDacDiem;
    private EditText edCanNang;
    private EditText edSodt;
    private EditText edMaDichVu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Thêm Thông Tin");
        setContentView(R.layout.activity_them_thong_tin);
        spnDichVu = (Spinner) findViewById(R.id.spnMadichVu);
        getDichVu();
        edNgay = (EditText) findViewById(R.id.edngay);
        edMaHoaDon = (EditText) findViewById(R.id.edmahoadon);
        edTenVatNuoi = (EditText) findViewById(R.id.edtenvatnuoi);
        edDacDiem = (EditText) findViewById(R.id.eddacdiem);
        edCanNang = (EditText) findViewById(R.id.edcannang);
        edSodt = (EditText) findViewById(R.id.edsodt);
        edMaDichVu = (EditText) findViewById(R.id.edmadichvu);
        spnTinhTrang = (Spinner) findViewById(R.id.spnTinhTrang);
        trangThai();
        spnTinhTrang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TinhTrang = spnTinhTrang.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spnDichVu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Madichvu = listDichVu.get(spnDichVu.getSelectedItemPosition()).getMaDichVu();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void getDichVu() {
        dichVuDao = new DichVuDao(ThemThongTinActivity.this);
        listDichVu = dichVuDao.getAllDichVu();
        ArrayAdapter<DichVu> Adapter = new ArrayAdapter<DichVu>(this, android.R.layout.simple_spinner_item, listDichVu);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDichVu.setAdapter(Adapter);
    }

    public void trangThai() {
        ArrayAdapter<String> TTadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrTT);
        TTadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTinhTrang.setAdapter(TTadapter);
    }

    public void datePicker(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "date");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);
    }

    private void setDate(final Calendar calendar) {
        edNgay.setText(sdf.format(calendar.getTime()));
    }

    public static class DatePickerFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }
    }

    public int validateForm() {
        int check = 1;
        if (edMaHoaDon.getText().length() == 0 || edTenVatNuoi.getText().length() == 0 || edNgay.getText().length() == 0 || edDacDiem.getText().length() == 0 || edCanNang.getText().length() == 0 || edSodt.getText().length() == 0 || edMaDichVu.getText().length() == 0) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            check = 1;
        }
        return check;
    }

    public void addnewHoaDon(View view) {
        ThongTinDao hoaDonDao = new ThongTinDao(ThemThongTinActivity.this);
        try {
//            if (validateForm() > 0) {
            ThongTin hoaDon = new ThongTin(edMaHoaDon.getText().toString(), edNgay.getText().toString(), edTenVatNuoi.getText().toString(), edCanNang.getText().toString(), edDacDiem.getText().toString(), edSodt.getText().toString(), Madichvu, TinhTrang);
            boolean isInsertTrue = hoaDonDao.insertHoaDon(hoaDon);
            if (isInsertTrue) {
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_LONG).show();
            }
//            }
        } catch (Exception e) {
            Toast.makeText(this, "lỗi", Toast.LENGTH_LONG).show();

        }

    }

}
