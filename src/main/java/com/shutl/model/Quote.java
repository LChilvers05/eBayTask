package com.shutl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote {

    @JsonProperty("pickup_postcode")
    String pickupPostcode;
    @JsonProperty("delivery_postcode")
    String deliveryPostcode;
    String vehicle;
    Long price;

    public Quote() {}

    /**
     * Constructor used to instantiate request object
     * @param pickupPostcode the postcode the package is picked up
     * @param deliveryPostcode the postcode the package is delivered to
     * @param vehicle
     */
    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
    }

    /**
     * Constructor used to instantiate response object
     * @param pickupPostcode the postcode the package is picked up
     * @param deliveryPostcode the postcode the package is delivered to
     * @param vehicle the description of delivery vehicle
     * @param price the final price of delivery
     */
    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle, Long price) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
        this.price = price;
    }

    //getters and setters

    public String getPickupPostcode() {
        return pickupPostcode;
    }

    public void setPickupPostcode(String pickupPostcode) {
        this.pickupPostcode = pickupPostcode;
    }

    public String getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDeliveryPostcode(String deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
