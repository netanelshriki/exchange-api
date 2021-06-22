package com.net.demo33.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.net.demo33.details.Details;
import com.net.demo33.json.ExchangeConvertor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;


@RestController
@RequestMapping("money/")
@RequiredArgsConstructor
public class ExchangeController {

    private final DecimalFormat df;
    private final RestTemplate restTemplate;
    private final String URL = "https://v6.exchangerate-api.com/v6/6845abc2363b7dc5ff117844/latest/USD";

    @Cacheable("exchange_cache")
    @GetMapping("convert")
    @ResponseStatus(HttpStatus.OK)
    public Details convert(@RequestParam String from, @RequestParam String to, @RequestParam int amount) {

        ExchangeConvertor exchangeConvertor = restTemplate.getForObject(URL, ExchangeConvertor.class);
        double TO = (double) exchangeConvertor.getConversion_rates().get(to);

        return new Details(from.toString(), to.toString(), amount, df.format(TO * amount));

    }

    //@Scheduled(fixedDelay = 1000*60*60*24) --> for cleaning cache each 24 hors
    @CacheEvict(allEntries = true, cacheNames = {"exchange_cache"})
    @Scheduled(fixedDelay = 10000)
    public void cacheEvict() {
    }

}
