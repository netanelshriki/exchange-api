package com.net.demo33.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Details {

    @JsonProperty("fromCurrency")
    private String from;


    @JsonProperty("toCurrency")
    private String to;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("result")
    private String result;


}
