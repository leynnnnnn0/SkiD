package com.leynnnnnn.skid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.ViewHolder> {
    public Context context;
    private  HomePageGridItem[] items;
    private final HomePageInterface homePageInterface;
    public HomePageAdapter( Context context, HomePageGridItem[] items, HomePageInterface homePageInterface) {
        this.context = context;
        this.items = items;
        this.homePageInterface = homePageInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent, false);
        return new ViewHolder(view, homePageInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(items[position].getImage());
        holder.itemType.setText(items[position].getType());
        holder.itemWeight.setText(items[position].getWeight());


    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemType, itemWeight;
        public ViewHolder(@NonNull View itemView, HomePageInterface homePageInterface ) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemType= itemView.findViewById(R.id.itemType);
            itemWeight = itemView.findViewById(R.id.itemWeight);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (homePageInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            homePageInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
