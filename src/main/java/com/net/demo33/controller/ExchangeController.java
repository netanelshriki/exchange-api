package com.net.demo33.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.net.demo33.details.Details;
import com.net.demo33.json.ExchangeConvertor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;


@RestController
@RequestMapping("money/")
@RequiredArgsConstructor
public class ExchangeController {

    private static DecimalFormat df = new DecimalFormat("0.00");
    private final RestTemplate restTemplate;
    private static final String URL = "https://v6.exchangerate-api.com/v6/414db79b430e4bd3915c42c0/latest/USD";


    @GetMapping("convert")
    @ResponseStatus(HttpStatus.OK)
    public Details convert(@RequestParam String from, @RequestParam String to, @RequestParam int amount) throws JsonProcessingException {

        ExchangeConvertor exchangeConvertor = restTemplate.getForObject(URL, ExchangeConvertor.class);
        double TO = (double) exchangeConvertor.getConversion_rates().get(to);

        return new Details(from.toString(), to.toString(), amount, df.format(TO * amount));

    }

}
