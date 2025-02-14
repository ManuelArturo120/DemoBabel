package com.demor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import static com.demo.constant.Constants.UNDEFINED;

@Getter
@Setter
public class DataForLogs {

    
    private String urlRequest = UNDEFINED;
    private String bodyRequest = UNDEFINED;
    private Map<String, String> mapHeader;
}