package com.net.demo33.service;

import com.net.demo33.pojo.Details;
import org.springframework.stereotype.Service;

@Service
public interface ExchangeService {

    Details convertFromUSD(String from,String to,int amount);

}
