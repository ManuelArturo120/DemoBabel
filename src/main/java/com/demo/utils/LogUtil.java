package com.demo.utils;



import com.demor.dto.DataForLogs;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.ObjectUtils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import static com.demo.constant.Constants.BODY_TAG_START;
import static com.demo.constant.Constants.LOG_HEAD;
import static com.demo.constant.Constants.LOG_SABRE_CREDENTIALS;
import static com.demo.constant.Constants.PARAMS_QRY_NA;
import static com.demo.constant.Constants.PNR;
import static com.demo.constant.Constants.REQUEST;
import static com.demo.constant.Constants.START_HEADER;
import static com.demo.constant.Constants.THIRD_PARTY;
import static com.demo.constant.Constants.TRANSACTION_ID;
import static com.demo.constant.Constants.UNDEFINED;

@Component
public class LogUtil {

    private static final Logger log = LoggerFactory.getLogger(LogUtil.class);

    private LogUtil() {
        //To do nothing
    }

    public static void printLogError(String logType, String url, String response, String body
                                     ) throws IllegalArgumentException {

        MDC.put(REQUEST, ObjectUtils.isEmpty(body) ? UNDEFINED : body);
      
        log.error(LOG_HEAD, StringUtils.isNotEmpty(logType) ? StringEscapeUtils.escapeJava(logType) : UNDEFINED,
                StringUtils.isEmpty(MDC.get(TRANSACTION_ID)) ? UNDEFINED
                        : StringEscapeUtils.escapeJava(MDC.get(TRANSACTION_ID)),
                StringUtils.isEmpty(MDC.get(PNR)) ? UNDEFINED
                        : StringEscapeUtils.escapeJava(MDC.get(PNR)),
                StringUtils.isEmpty(url) ? UNDEFINED : StringEscapeUtils.escapeJava(url),
                StringUtils.isEmpty(MDC.get(REQUEST)) ? UNDEFINED : StringEscapeUtils.escapeJava(MDC.get(REQUEST)),
                StringUtils.isEmpty(response) ? UNDEFINED : StringEscapeUtils.escapeJava(response));
    }

    public static void printTransactionLog(String transactionId, String logType, String url, String response, String body,
                                           String reservationCode) throws IllegalArgumentException {

        MDC.put(TRANSACTION_ID, transactionId);
        MDC.put(REQUEST, ObjectUtils.isEmpty(body) ? UNDEFINED : body);
        MDC.put(PNR, reservationCode);
        log.info(LOG_HEAD, StringUtils.isNotEmpty(logType) ? StringEscapeUtils.escapeJava(logType) : UNDEFINED,
                StringUtils.isEmpty(MDC.get(TRANSACTION_ID)) ? UNDEFINED
                        : StringEscapeUtils.escapeJava(MDC.get(TRANSACTION_ID)),
                StringUtils.isEmpty(MDC.get(PNR)) ? UNDEFINED
                        : StringEscapeUtils.escapeJava(MDC.get(PNR)),
                StringUtils.isEmpty(url) ? UNDEFINED : StringEscapeUtils.escapeJava(url),
                StringUtils.isEmpty(MDC.get(REQUEST)) ? UNDEFINED : StringEscapeUtils.escapeJava(MDC.get(REQUEST)),
                StringUtils.isEmpty(response) ? UNDEFINED : StringEscapeUtils.escapeJava(response));
    }

   

    public static String buildLogRequest(DataForLogs dataForLogs) {
        return START_HEADER.concat(dataForLogs.getMapHeader().toString()).concat(BODY_TAG_START).concat(StringUtils.isEmpty(dataForLogs.getBodyRequest())? UNDEFINED: dataForLogs.getBodyRequest() ).concat(">,")
                .concat(PARAMS_QRY_NA);
    }

    public static String buildLogRequest(String body) {
        return START_HEADER.concat(UNDEFINED).concat(BODY_TAG_START).concat(StringUtils.isEmpty(body)? UNDEFINED: body ).concat(">,")
                .concat(PARAMS_QRY_NA);
    }

    public static String buildLogRequest(DataForLogs dataForLogs, String body) {
        return START_HEADER.concat(dataForLogs.getMapHeader().toString()).concat(BODY_TAG_START).concat(StringUtils.isEmpty(body)? UNDEFINED: body).concat(">,")
                .concat(PARAMS_QRY_NA);
    }

    public static String buildLogResponse(String response, String message, String error, String trace) {
        return "<response = ".concat(StringUtils.isEmpty(response) ? UNDEFINED: response).concat(">, <message = ").concat(StringUtils.isEmpty(message) ? UNDEFINED: message).concat(">,")
                .concat("<error = ".concat(StringUtils.isEmpty(error) ? UNDEFINED: error).concat(">, <trace = ").concat(StringUtils.isEmpty(trace) ? UNDEFINED: trace).concat(">"));
    }

}
