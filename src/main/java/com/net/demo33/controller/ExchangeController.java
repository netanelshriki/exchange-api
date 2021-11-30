package com.net.demo33.controller;

import com.net.demo33.pojo.Details;
import com.net.demo33.pojo.ExchangeConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;



@RestController
@RequestMapping("money/")
@RequiredArgsConstructor
public class ExchangeController {

    private final DecimalFormat df;
    private final RestTemplate restTemplate;
    @Value("${exchange.url}")
    private String URL;

    @Cacheable(value = "exchange_cache")
    @GetMapping("convert")
    @ResponseStatus(HttpStatus.OK)
    public Details convert(@RequestParam String from, @RequestParam String to, @RequestParam int amount) {

        ExchangeConvertor exchangeConvertor = restTemplate.getForObject(URL, ExchangeConvertor.class);

        double TO = (double) exchangeConvertor.getConversion_rates().get(to);

        return new Details(from, to, amount, df.format(TO * amount));
    }


    //@Scheduled(fixedDelay = 1000*60*60*24) --> for cleaning cache each 24 hors
    //@CacheEvict(allEntries = true, cacheNames = {"exchange_cache"})
//    @Scheduled(fixedDelay = 10000)
//    public void cacheEvict() {
//    }




}
