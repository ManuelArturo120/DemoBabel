package com.demor.dto;

import static com.demo.constant.Constants.PIPE_SEPARATOR;
import lombok.Builder;

@Builder
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

	public static String builder() {
		// TODO Auto-generated method stub
		return null;
	}
}
