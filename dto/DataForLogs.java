package com.aeromexico.am.ab.ancillary.offer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import static com.aeromexico.am.ab.ancillary.offer.constant.Constants.UNDEFINED;

@Getter
@Setter
public class DataForLogs {

    private String xTransactionId = UNDEFINED;
    private String pnr = UNDEFINED;
    private String channel = UNDEFINED;
    private String urlRequest = UNDEFINED;
    private String bodyRequest = UNDEFINED;
    private String store = UNDEFINED;
    private Map<String, String> mapHeader;
}