package com.shutl.model;

/**
 * Singleton class to calculate a new price based on the vehicle used for delivery
 */
public class PriceCalculator {

    public enum VehicleType {
        bicycle, motorbike, parcel_car,
        small_van, large_van
    }

    private static PriceCalculator sharedInstance = null;

    private PriceCalculator() {}

    public static PriceCalculator shared() {
        if (sharedInstance == null) sharedInstance = new PriceCalculator();
        return sharedInstance;
    }

    /**
     * 
     * @param price the original base price before calculation
     * @param vehicle description of delivery vehicle
     * @return the new price of delivery
     */
    public Long calulatePrice(Long price, String vehicle) {
        VehicleType type = VehicleType.valueOf(vehicle);
        
        float markup;
        switch (type) {
            case bicycle:
                markup = 0.1f;
                break;
            case motorbike:
                markup = 0.15f;
                break;
            case parcel_car:
                markup = 0.2f;
                break;
            case small_van:
                markup = 0.3f;
                break;
            case large_van:
                markup = 0.4f;
                break;
            default:
                markup = 0.0f;
                break;
        }

        return (long) (Math.round(price * (1f + markup)));
    }
}