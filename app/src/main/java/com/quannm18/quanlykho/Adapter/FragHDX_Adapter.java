package com.quannm18.quanlykho.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.quannm18.quanlykho.Interface.ApiInterface;
import com.quannm18.quanlykho.Model.HoaDonNhap;
import com.quannm18.quanlykho.Model.HoaDonXuat;
import com.quannm18.quanlykho.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragHDX_Adapter extends RecyclerView.Adapter<FragHDX_Adapter.FragHDXHolder> {
    private Context context;
    List<HoaDonXuat> listHDX;
    HoaDonXuat hoaDonXuat;

    public FragHDX_Adapter(Context context, List<HoaDonXuat> listHDX) {
        this.context = context;
        this.listHDX = listHDX;
    }

    public void setDataHDX(List<HoaDonXuat> listHDX) {
        this.listHDX = listHDX;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FragHDX_Adapter.FragHDXHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_bill_outlet, parent, false);
        return new FragHDXHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragHDX_Adapter.FragHDXHolder holder, int position) {
        hoaDonXuat = listHDX.get(position);
        holder.hdx_txt_maHDX.setText(hoaDonXuat.getMaHDX());
        holder.hdx_txt_ngayNhap.setText(hoaDonXuat.getNgayNhap());
        holder.hdx_txt_ngayXuat.setText(hoaDonXuat.getNgayXuat());
        holder.hdx_txt_thanhtien.setText(hoaDonXuat.getThanhTien() + "");
        holder.hdx_txt_trangthai.setText(hoaDonXuat.getTrangThai());
        holder.hdx_txt_descriptions.setText(hoaDonXuat.getMoTa());
        holder.cv_hdx_CT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view1 = LayoutInflater.from(context).inflate(R.layout.custom_bill_outlet_chitiet, null);
                builder.setView(view1);
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                String maHDX = holder.hdx_txt_maHDX.getText().toString();
                String ngayNhap = holder.hdx_txt_ngayNhap.getText().toString();
                String ngayXuat = holder.hdx_txt_ngayXuat.getText().toString();
                int thanhTien = Integer.parseInt(holder.hdx_txt_thanhtien.getText().toString());
                String trangThai = holder.hdx_txt_trangthai.getText().toString();
                String moTa = holder.hdx_txt_descriptions.getText().toString();


                TextView hdx_tv_maHDX_CT = view1.findViewById(R.id.hdx_tv_maHDX_CT);
                TextView hdx_tv_ngayNhap_CT = view1.findViewById(R.id.hdx_tv_ngayNhap_CT);
                TextView hdx_tv_ngayXuat_CT = view1.findViewById(R.id.hdx_tv_ngayXuat_CT);
                TextView hdx_tv_product_CT = view1.findViewById(R.id.hdx_tv_product_CT);
                TextView hdx_tv_trangthai_CT = view1.findViewById(R.id.hdx_tv_trangthai_CT);
                TextView hdx_tv_Descriptions_CT = view1.findViewById(R.id.hdx_tv_Descriptions_CT);


                AppCompatButton hdx_btn_close_CT = view1.findViewById(R.id.hdx_btn_close_CT);

                hdx_tv_maHDX_CT.setText(maHDX);
                hdx_tv_ngayNhap_CT.setText(ngayNhap);
                hdx_tv_ngayXuat_CT.setText(ngayXuat);
                hdx_tv_product_CT.setText(thanhTien + "");
                hdx_tv_trangthai_CT.setText(trangThai);
                hdx_tv_Descriptions_CT.setText(moTa);


                hdx_btn_close_CT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


            }

        });
        holder.cv_hdx_CT.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view1) {
                listHDX.clear();
//                listHDX.
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return listHDX.size();
    }

    public class FragHDXHolder extends RecyclerView.ViewHolder {
        TextView hdx_tv_maHDX_CT, hdx_txt_maHDX, hdx_txt_ngayNhap, hdx_txt_ngayXuat, hdx_txt_thanhtien,
                hdx_txt_trangthai, hdx_txt_descriptions;
        CardView cv_hdx_CT;

        public FragHDXHolder(@NonNull View itemView) {
            super(itemView);
            hdx_tv_maHDX_CT = itemView.findViewById(R.id.hdx_tv_maHDX_CT);
            hdx_txt_maHDX = itemView.findViewById(R.id.hdx_txt_maHDX);
            hdx_txt_ngayNhap = itemView.findViewById(R.id.hdx_txt_ngayNhap);
            hdx_txt_ngayXuat = itemView.findViewById(R.id.hdx_txt_ngayXuat);
            hdx_txt_thanhtien = itemView.findViewById(R.id.hdx_txt_thanhtien);
            hdx_txt_trangthai = itemView.findViewById(R.id.hdx_txt_trangthai);
            hdx_txt_descriptions = itemView.findViewById(R.id.hdx_txt_descriptions);
            cv_hdx_CT = itemView.findViewById(R.id.cv_hdx_CT);


        }
    }

    private List<HoaDonXuat> deleteHDX(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                List<HoaDonXuat> hdxList = new ArrayList<>();
                ApiInterface.ApiInterface.deleteHDX(hoaDonXuat.getId()).enqueue(new Callback<List<HoaDonXuat>>() {
                    @Override
                    public void onResponse(Call<List<HoaDonXuat>> call, Response<List<HoaDonXuat>> response) {
                        List<HoaDonXuat> list = response.body();
                        for (HoaDonXuat hoaDonXuat : list) {
                            hdxList.add(hoaDonXuat);
                            notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onFailure(Call<List<HoaDonXuat>> call, Throwable t) {

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }

        });
        return listHDX;
    }
}
