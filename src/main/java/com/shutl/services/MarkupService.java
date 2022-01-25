package com.shutl.services;

public class MarkupService {

    private enum VehicleType {
        bicycle, motorbike, parcel_car,
        small_van, large_van
    }

    public MarkupService() {}

    public float getMarkup(String type) {
        VehicleType vehicleType = VehicleType.valueOf(type);

        float markup = 0.0f;
        
        
        switch (vehicleType) {
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
                break;
        }
        return markup;
    }
}
