package com.shutl.controller;

import com.shutl.model.Quote;
import com.shutl.services.PriceCalculator;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class QuoteController {

    //TODO: put business logic into a service

    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody Quote quote(@RequestBody Quote quote) {
        Long price = Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36))/100000000);

        price = PriceCalculator.shared().calulatePrice(price, quote.getVehicle());
        
        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), quote.getVehicle(), price);
    }
}
