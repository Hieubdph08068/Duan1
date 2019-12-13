package com.example.duan1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.database.databasehelper;
import com.example.duan1.model.ThongTin;

import java.util.ArrayList;
import java.util.List;

public class ThongTinDao {
    public final static String TABLE_NAME = "ThongTin";
    public final static String SQL_HOA_DON = "" + "CREATE TABLE ThongTin(mahoadon text PRIMARY KEY," + "tenvatnuoi text,ngay date,dacdiem text, cannang text, sodt text, madichvu text, ghichu text)";
    public static final String TAG = "ThongTin";

    private SQLiteDatabase db;
    private databasehelper dbHelper;


    public ThongTinDao(Context context) {
        dbHelper = new databasehelper(context);
        db = dbHelper.getWritableDatabase();
    }


    public boolean insertHoaDon(ThongTin hd) {
        ContentValues values = new ContentValues();
        values.put("mahoadon", hd.getMaHoaDon());
        values.put("tenvatnuoi", hd.getTenVatNuoi());
        values.put("ngay", hd.getNgay());
        values.put("dacdiem", hd.getDacDiem());
        values.put("cannang", hd.getCanNang());
        values.put("sodt", hd.getSoDienThoai());
        values.put("madichvu", hd.getMaDichVu());
        values.put("ghichu", hd.getGhiChu());
        long result = db.insert(TABLE_NAME, null, values);
        try {
            if (result == -1) {
                return false;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
            return false;
        }
        return true;
    }

    public List<ThongTin> getAllThongTin() {
        List<ThongTin> dsThongTin = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            ThongTin tt = new ThongTin();
            tt.setMaHoaDon(c.getString(0));
            tt.setTenVatNuoi(c.getString(1));
            tt.setNgay(c.getString(2));
            tt.setDacDiem(c.getString(3));
            tt.setCanNang(c.getString(4));
            tt.setSoDienThoai(c.getString(5));
            tt.setMaDichVu(c.getString(6));
            tt.setGhiChu(c.getString(7));
            dsThongTin.add(tt);
            Log.d("//=====", tt.toString());
            c.moveToNext();
        }
        c.close();
        return dsThongTin;

    }

    public int deleteThongTin(String mahoadon) {
        int result = db.delete(TABLE_NAME, "mahoadon=?", new String[]{mahoadon});
        if (result == 0)
            return -1;
        return 1;
    }

}
