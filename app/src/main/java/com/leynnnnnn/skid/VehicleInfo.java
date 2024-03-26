package com.leynnnnnn.skid;

public class VehicleInfo {
    private int image;
    private String vehicleType;
    private int deliveryTime;
    private double rate;

    public VehicleInfo(int image, String vehicleType, int deliveryTime, double rate) {
        this.image = image;
        this.vehicleType = vehicleType;
        this.deliveryTime = deliveryTime;
        this.rate = rate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
