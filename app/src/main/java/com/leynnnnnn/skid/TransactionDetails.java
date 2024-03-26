package com.leynnnnnn.skid;

import java.io.Serializable;

public class TransactionDetails implements Serializable {
    private String item;
    private String itemInfo;
    private String additionalInfo;
    private String pickUpLocation;
    private String dropOffLocation;
    private String vehicleType;
    private double rate;

    public TransactionDetails(String item, String itemInfo, String additionalInfo, String pickUpLocation, String dropOffLocation, String vehicleType, double rate) {
        this.item = item;
        this.itemInfo = itemInfo;
        this.additionalInfo = additionalInfo;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.vehicleType = vehicleType;
        this.rate = rate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
