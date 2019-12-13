package com.example.duan1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1.R;
import com.example.duan1.dao.ThongTinDao;
import com.example.duan1.model.ThongTin;

import java.util.List;

public class ThongTinAdapter extends BaseAdapter {
    List<ThongTin> arrThongTin;
    public LayoutInflater inflater;
    ThongTinDao thongTinDao;
    public Activity context;

    public ThongTinAdapter(Activity context, List<ThongTin> arrThongTin) {
        this.arrThongTin = arrThongTin;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        thongTinDao = new ThongTinDao(context);

    }

    @Override
    public int getCount() {
        return arrThongTin.size();
    }

    @Override
    public Object getItem(int position) {
        return arrThongTin.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView icon;
        TextView tvMaPhieu;
        TextView tvNgay;
        TextView tvTenVN;
        TextView tvTinhTrang;

    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.itemthongtin, null);
            viewHolder.icon = (ImageView) view.findViewById(R.id.imgIcon);
            viewHolder.tvMaPhieu = (TextView) view.findViewById(R.id.tvMaTT);
            viewHolder.tvTenVN = (TextView) view.findViewById(R.id.tvTenVN);
            viewHolder.tvNgay = (TextView) view.findViewById(R.id.tvNgay);
            viewHolder.tvTinhTrang = (TextView) view.findViewById(R.id.tvTinhTrang);


            view.setTag(viewHolder);

        } else
            viewHolder = (ViewHolder) view.getTag();
        ThongTin thongTin = (ThongTin) arrThongTin.get(position);
        viewHolder.tvMaPhieu.setText(thongTin.getMaHoaDon());
        viewHolder.tvTenVN.setText(thongTin.getTenVatNuoi());
        viewHolder.tvNgay.setText(thongTin.getNgay());
        viewHolder.tvTinhTrang.setText(thongTin.getGhiChu());
        return view;
    }
}



