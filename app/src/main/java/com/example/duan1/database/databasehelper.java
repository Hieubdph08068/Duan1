package com.example.duan1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.duan1.dao.DichVuDao;
import com.example.duan1.dao.ThongTinDao;
import com.example.duan1.dao.VatNuoiDao;

public class databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db";
    public static final int VERSION = 1;

    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VatNuoiDao.SQL_VAT_NUOI);
        db.execSQL(DichVuDao.SQL_DICH_VU);
        db.execSQL(ThongTinDao.SQL_HOA_DON);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(VatNuoiDao.SQL_VAT_NUOI);
        db.execSQL(DichVuDao.SQL_DICH_VU);
        db.execSQL(ThongTinDao.SQL_HOA_DON);

    }
}
