package com.shutl.services;

import com.shutl.model.Quote;
import com.shutl.model.MarkupService;

/**
 * Singleton class to calculate a new price based on the vehicle used for
 * delivery
 */
public class PriceCalculator {

    private MarkupService markupService;

    private static PriceCalculator sharedInstance = null;

    private PriceCalculator() {
        markupService = new MarkupService();
    }

    public static PriceCalculator shared() {
        if (sharedInstance == null) {
            sharedInstance = new PriceCalculator();
        }
        return sharedInstance;
    }

    /**
     * 
     * @param price   the original base price before calculation
     * @param vehicle description of delivery vehicle
     * @return the final price of the delivery
     */
    public Long calulatePrice(Quote quote) {
        
        Long price = Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36))/100000000);
        String vehicleStr = quote.getVehicle();
        float markup = markupService.getMarkup(vehicleStr);

        return (long) (Math.round(price * (1f + markup)));
    }
}