package com.shutl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shutl.Application;
import com.shutl.model.Quote;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class) //@SpringApplicationConfiguration
public class QuoteControllerFunctionalTest {

    @Autowired private WebApplicationContext webApplicationContext;

    ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
    }

    //TODO: Write tests to check that maths for all vehicle types works

    @Test
    public void testBasicService() throws Exception {
        // Quote quoteData = new Quote("SW1A1AA", "EC2A3LT");
        // MvcResult result = this.mockMvc.perform(post("/quote")
        //         .contentType("application/json")
        //         .content(objectMapper.writeValueAsString(quoteData)))
        //     .andExpect(status().isOk())
        //     .andReturn();

        // Quote quote = objectMapper.readValue(result.getResponse().getContentAsString(), Quote.class);
        // assertEquals(quote.getPickupPostcode(), "SW1A1AA");
        // assertEquals(quote.getDeliveryPostcode(), "EC2A3LT");
        // assertEquals(quote.getPrice(), Long.valueOf(316));
    }

    @Test
    public void testVariablePricingByDistance() throws Exception {
        // Quote quoteData = new Quote("SW1A1AA", "EC2A3LT");
        // MvcResult result = this.mockMvc.perform(post("/quote")
        //         .contentType("application/json")
        //         .content(objectMapper.writeValueAsString(quoteData)))
        //     .andExpect(status().isOk())
        //     .andReturn();

        // Quote quote = objectMapper.readValue(result.getResponse().getContentAsString(), Quote.class);
        // assertEquals(quote.getPickupPostcode(), "SW1A1AA");
        // assertEquals(quote.getDeliveryPostcode(), "EC2A3LT");
        // assertEquals(quote.getPrice(), Long.valueOf(316));

        // quoteData = new Quote("AL15WD", "EC2A3LT");
        // result = this.mockMvc.perform(post("/quote")
        //         .contentType("application/json")
        //         .content(objectMapper.writeValueAsString(quoteData)))
        //     .andExpect(status().isOk())
        //     .andReturn();

        // quote = objectMapper.readValue(result.getResponse().getContentAsString(), Quote.class);
        // assertEquals(quote.getPickupPostcode(), "AL15WD");
        // assertEquals(quote.getDeliveryPostcode(), "EC2A3LT");
        // assertEquals(quote.getPrice(), Long.valueOf(305));
    }
}
