package com.aeromexico.am.ab.ancillary.offer.dto;

import static com.aeromexico.am.ab.ancillary.offer.constant.Constants.PIPE_SEPARATOR;
import lombok.Builder;

@Builder
public class LogStructure {
    private String logType;
    private String transactionId;
    private String pnr;
    private String url;
    private Object request;
    private Object response;
    private String exceptionMessage;

    public String getTransactionLog() {
        return getLog(false);
    }

    public String getExceptionLog() {
        return getLog(true);
    }

    public String getLog(boolean isException){
        StringBuilder log = new StringBuilder();
        log.append(this.logType);
        log.append(PIPE_SEPARATOR);
        log.append("TRANSACTION_ID: ");
        log.append(this.transactionId);
        log.append(PIPE_SEPARATOR);
        log.append("PNR: ");
        log.append(this.pnr);
        log.append(PIPE_SEPARATOR);
        log.append("URL: ");
        log.append(this.url);
        log.append(PIPE_SEPARATOR);
        log.append("REQUEST: ");
        log.append(this.request);
        log.append(PIPE_SEPARATOR);
        log.append("RESPONSE: ");
        log.append(this.response);
        if(isException){
            log.append(PIPE_SEPARATOR);
            log.append("message: ");
            log.append(this.exceptionMessage);
        }
        return log.toString();
    }
}
