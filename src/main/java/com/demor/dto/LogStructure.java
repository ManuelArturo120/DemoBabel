package com.demor.dto;

import static com.demo.constant.Constants.PIPE_SEPARATOR;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class LogStructure {

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
