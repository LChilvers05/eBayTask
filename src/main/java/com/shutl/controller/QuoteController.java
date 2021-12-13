package com.shutl.controller;

import com.shutl.model.Quote;
import com.shutl.services.PriceCalculator;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "*")
public class QuoteController {

    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody Quote quote(@RequestBody Quote quote) {
        
        Long price = PriceCalculator.shared().calulatePrice(quote);
        
        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), quote.getVehicle(), price);
    }
}
