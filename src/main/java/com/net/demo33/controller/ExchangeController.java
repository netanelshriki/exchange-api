package com.net.demo33.controller;

import com.net.demo33.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("money/")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;


    @Cacheable(value = "exchange_cache")
    @GetMapping("convert")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> convert(@RequestParam String from, @RequestParam String to, @RequestParam int amount) {

        return ResponseEntity
                .ok()
                .body(exchangeService.convertFromUSD(from, to, amount));
    }


    //    @Scheduled(fixedDelay = 1000*60*60*24) --> for cleaning cache each 24 hour
    //    @CacheEvict(allEntries = true, cacheNames = {"exchange_cache"})
    //    @Scheduled(fixedDelay = 10000)
    //    public void cacheEvict() {
    //    }


}
