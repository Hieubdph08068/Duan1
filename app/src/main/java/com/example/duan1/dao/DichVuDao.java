package com.example.duan1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.database.databasehelper;
import com.example.duan1.model.DichVu;

import java.util.ArrayList;
import java.util.List;

public class DichVuDao {
    public static final String TABLE_NAME = "dichvu";
    public static final String SQL_DICH_VU = "" + "CREATE TABLE dichvu(madichvu text primary key," + "tendichvu text,mota text,gia text);";
    public static final String TAG = "DichVu";

    private SQLiteDatabase db;
    private databasehelper dbHelper;

    public DichVuDao(Context context) {
        dbHelper = new databasehelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public boolean insertDichVu(DichVu dv) {
        ContentValues values = new ContentValues();
        values.put("madichvu", dv.getMaDichVu());
        values.put("tendichvu", dv.getTenDichVu());
        values.put("mota", dv.getMoTa());
        values.put("gia", dv.getGia());
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

    public int updateDichVu(DichVu dichVu) {
        ContentValues values = new ContentValues();
        values.put("tendichvu", dichVu.getTenDichVu());
        values.put("mota", dichVu.getMoTa());
        values.put("gia", dichVu.getGia());
        int result = db.update(TABLE_NAME, values, "madichvu=?", new String[]{dichVu.getMaDichVu()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteDichVu(String madichvu) {
        int result = db.delete(TABLE_NAME, "madichvu=?", new String[]{madichvu});
        if (result == 0)
            return -1;
        return 1;
    }


    public List<DichVu> getAllDichVu() {
        List<DichVu> dsDichVu = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            DichVu dv = new DichVu();
            dv.setMaDichVu(c.getString(0));
            dv.setTenDichVu(c.getString(1));
            dv.setMoTa(c.getString(2));
            dv.setGia(c.getString(3));
            dsDichVu.add(dv);
            Log.d("//=====", dv.toString());
            c.moveToNext();
        }
        c.close();
        return dsDichVu;

    }
}
