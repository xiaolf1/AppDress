package com.lenebf.demo.appdress.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lenebf.android.app_dress.color.NightColor;
import com.lenebf.demo.appdress.AppSetting;
import com.lenebf.demo.appdress.R;

import java.util.List;

/**
 * @author lenebf@126.com
 * @since 2020/9/10
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {

    private Context context;
    private List<ItemData> itemDataList;

    public ListAdapter(Context context, List<ItemData> itemDataList) {
        this.context = context;
        this.itemDataList = itemDataList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemData data = itemDataList.get(position);
        holder.bindData(data);
    }

    @Override
    public int getItemCount() {
        return itemDataList == null ? 0 : itemDataList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView3);
            textView = itemView.findViewById(R.id.textView2);
        }

        void bindData(ItemData data) {
            if (data == null) {
                return;
            }
            if (AppSetting.getDressColor(itemView.getContext()) == AppSetting.COLOR_NIGHT_MODE) {
                NightColor.revert(imageView);
            } else {
                imageView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
            imageView.setImageResource(data.imageId);
            textView.setText(data.text);
        }
    }
}
