package com.leynnnnnn.skid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.ViewHolder> {
    Context context;
    VehicleInfo[] vehicles;
    private final VehicleSelectionInterface vehicleSelectionInterface;

    public VehiclesAdapter(Context context, VehicleInfo[] vehicles, VehicleSelectionInterface vehicleSelectionInterface) {
        this.context = context;
        this.vehicles = vehicles;
        this.vehicleSelectionInterface = vehicleSelectionInterface;
    }
    @NonNull
    @Override
    public VehiclesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vehicle_card_layout, parent, false);
        return new ViewHolder(view, vehicleSelectionInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiclesAdapter.ViewHolder holder, int position) {
        holder.vehicleImage.setImageResource(vehicles[position].getImage());
        holder.vehicleRate.setText(String.valueOf("$" + vehicles[position].getRate()));
        holder.vehicleType.setText(vehicles[position].getVehicleType());
        holder.vehicleSpeed.setText(String.valueOf(vehicles[position].getDeliveryTime() + " minutes to deliver"));
    }

    @Override
    public int getItemCount() {
        return vehicles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView vehicleImage;
        TextView vehicleType, vehicleSpeed, vehicleRate;

        public ViewHolder(@NonNull View itemView, VehicleSelectionInterface vehicleSelectionInterface) {
            super(itemView);
            this.vehicleImage = itemView.findViewById(R.id.vehicleImage);
            this.vehicleType = itemView.findViewById(R.id.vehicleType);
            this.vehicleSpeed = itemView.findViewById(R.id.vehicleSpeed);
            this.vehicleRate = itemView.findViewById(R.id.vehiclePrice);

            itemView.setOnClickListener(v -> {
                if (vehicleSelectionInterface != null) {
                    int pos = getAdapterPosition();

                    if(pos != RecyclerView.NO_POSITION) {
                        vehicleSelectionInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
