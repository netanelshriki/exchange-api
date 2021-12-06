package com.net.demo33.service;

import com.net.demo33.pojo.Details;
import com.net.demo33.pojo.ExchangeConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final RestTemplate restTemplate;

    private final DecimalFormat df;

    @Value("${exchange.url}")
    private String URL;

    @Override
    public Details convertFromUSD(String from,String to,int amount) {

        ExchangeConvertor exchangeConvertor = restTemplate.getForObject(URL, ExchangeConvertor.class);

        double TO = (double) exchangeConvertor.getConversion_rates().get(to);

        return new Details(from, to, amount, df.format(TO * amount));
    }
}
