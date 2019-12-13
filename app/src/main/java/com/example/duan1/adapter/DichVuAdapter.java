package com.example.duan1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1.R;
import com.example.duan1.dao.DichVuDao;
import com.example.duan1.model.DichVu;

import java.util.List;

public class DichVuAdapter extends BaseAdapter {
    private List<DichVu> arrDichVu;
    public LayoutInflater inflater;
    public Activity context;
    private DichVuDao dichVuDao;

    public DichVuAdapter(Activity context, List<DichVu> arrDichVu) {
        this.context = context;
        this.arrDichVu = arrDichVu;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dichVuDao = new DichVuDao(context);
    }

    @Override
    public int getCount() {
        return arrDichVu.size();
    }

    @Override
    public Object getItem(int position) {
        return arrDichVu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView imgicon;
        TextView tvMaDV;
        TextView tvTenDV;
        TextView tvMota;
        TextView tvGia;
        ImageView imgDelete;

    }


    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.itemdichvu, null);
            viewHolder.imgicon = (ImageView) view.findViewById(R.id.imgicon);
            viewHolder.tvMaDV = (TextView) view.findViewById(R.id.txtmadv);
            viewHolder.tvTenDV = (TextView) view.findViewById(R.id.txttendv);
            viewHolder.tvMota = (TextView) view.findViewById(R.id.txtmota);
            viewHolder.tvGia = (TextView) view.findViewById(R.id.txtgia);
            viewHolder.imgDelete = (ImageView) view.findViewById(R.id.imgdelete);
            viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dichVuDao.deleteDichVu(arrDichVu.get(position).getMaDichVu());
                    arrDichVu.remove(position);
                    notifyDataSetChanged();
                }
            });
            view.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) view.getTag();
        DichVu dichVu = (DichVu) arrDichVu.get(position);
        viewHolder.imgicon.setImageResource(R.drawable.dichvu);
        viewHolder.tvMaDV.setText(dichVu.getMaDichVu());
        viewHolder.tvTenDV.setText(dichVu.getTenDichVu());
        viewHolder.tvMota.setText(dichVu.getMoTa());
        viewHolder.tvGia.setText(dichVu.getGia());
        return view;
    }
}

