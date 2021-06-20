
package com.net.demo33.json;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.stereotype.Component;



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