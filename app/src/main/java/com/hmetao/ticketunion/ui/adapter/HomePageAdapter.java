package com.hmetao.ticketunion.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hmetao.ticketunion.R;
import com.hmetao.ticketunion.databinding.ItemLinearGoodsContentBinding;
import com.hmetao.ticketunion.model.domain.HomePageContent;

import java.util.Objects;
import java.util.zip.Inflater;

public class HomePageAdapter extends ListAdapter<HomePageContent.DataDTO, HomePageAdapter.ViewHolder> {

    public HomePageAdapter() {
        super(new DiffUtil.ItemCallback<HomePageContent.DataDTO>() {
            @Override
            public boolean areItemsTheSame(@NonNull HomePageContent.DataDTO oldItem, @NonNull HomePageContent.DataDTO newItem) {
                return Objects.equals(oldItem.getCategoryId(), newItem.getCategoryId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull HomePageContent.DataDTO oldItem, @NonNull HomePageContent.DataDTO newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linear_goods_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomePageContent.DataDTO item = getItem(position);
        View view = holder.itemView;
        ImageView iv = view.findViewById(R.id.goods_cover);
        Context context = view.getContext();
        Glide.with(context)
                .load("https:" + item.getPictUrl())
                .into(iv);
        TextView tv = view.findViewById(R.id.goods_title);
        tv.setText(item.getTitle());
        String finalPrise = item.getZkFinalPrice();
        long couponAmount = item.getCouponAmount();
        float resultPrise = Float.parseFloat(finalPrise) - couponAmount;
        TextView offPriseTv = view.findViewById(R.id.goods_off_prise);
        TextView originalPriseTv = view.findViewById(R.id.goods_original_prise);
        TextView finalPriseTv = view.findViewById(R.id.goods_after_off_prise);
        finalPriseTv.setText(String.format("%.2f",resultPrise));
        offPriseTv.setText(String.format(context.getString(R.string.text_goods_off_prise),couponAmount));
        originalPriseTv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        originalPriseTv.setText(String.format(context.getString(R.string.text_goods_original_prise),finalPrise));
        TextView sellCountTv = view.findViewById(R.id.goods_sell_count);
        sellCountTv.setText(String.format(context.getString(R.string.text_goods_sell_count),item.getVolume()));

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
