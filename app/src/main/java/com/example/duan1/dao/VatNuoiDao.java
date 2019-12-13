package com.example.duan1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.database.databasehelper;
import com.example.duan1.model.VatNuoi;

import java.util.ArrayList;
import java.util.List;

public class VatNuoiDao {
    public static final String TABLE_NAME = "VATNUOI";
    public static final String SQL_VAT_NUOI = "" + "CREATE TABLE VATNUOI(MAVATNUOI TEXT PRIMARY KEY," + "TEN TEXT, LOAI TEXT, DACDIEM TEXT, CANNANG INT, GIA INT);";
    public static final String TAG = "VATNUOI";

    private SQLiteDatabase db;
    private databasehelper dbhelper;

    public VatNuoiDao(Context context) {
        dbhelper = new databasehelper(context);
        db = dbhelper.getWritableDatabase();
    }

    public boolean insertVatNuoi(VatNuoi vn) {
        ContentValues values = new ContentValues();
        values.put("mavatnuoi", vn.getMavatnuoi());
        values.put("ten", vn.getTenvatnuoi());
        values.put("loai", vn.getLoai());
        values.put("dacdiem", vn.getDacdiem());
        values.put("cannang", vn.getCannang());
        values.put("gia", vn.getGia());
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

    public int updatevn(VatNuoi vatNuoi) {
        ContentValues values = new ContentValues();
        values.put("ten", vatNuoi.getMavatnuoi());
        values.put("loai", vatNuoi.getTenvatnuoi());
        values.put("dacdiem", vatNuoi.getDacdiem());
        values.put("cannang", vatNuoi.getCannang());
        values.put("gia", vatNuoi.getGia());
        int result = db.update(TABLE_NAME, values, "mavatnuoi=?", new String[]{vatNuoi.getMavatnuoi()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteVatnuoi(String mavatnuoi) {
        int result = db.delete(TABLE_NAME, "mavatnuoi=?", new String[]{mavatnuoi});
        if (result == 0)
            return -1;
        return 1;
    }

    public List<VatNuoi> getAllVatNuoi() {
        List<VatNuoi> dsVatnuoi = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            VatNuoi vn = new VatNuoi();
            vn.setMavatnuoi(c.getString(0));
            vn.setTenvatnuoi(c.getString(1));
            vn.setLoai(c.getString(2));
            vn.setDacdiem(c.getString(3));
            vn.setCannang(c.getString(4));
            vn.setGia(c.getString(5));
            dsVatnuoi.add(vn);
            Log.d("//=====", vn.toString());
            c.moveToNext();
        }
        c.close();
        return dsVatnuoi;

    }

}
