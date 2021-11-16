
package com.net.demo33.pojo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;


@Data
public class ExchangeConvertor {

    private String result;

    private String documentation;

    private String terms_of_use;

    private Integer time_last_update_unix;

    private String time_last_update_utc;

    private Integer time_next_update_unix;

    private String time_next_update_utc;

    private String base_code;

    private Map<String,Object> conversion_rates = new HashMap<>();
}