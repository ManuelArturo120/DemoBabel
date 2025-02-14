package com.demo.constant;

public final class Constants {


    //Errors
    public static final String ERROR_INVALID_HEADERS = "This header(s) is (are) not present in application properties: ";
    public static final String INVALID_HEADERS = "INVALID_HEADERS";

    public static final String THIRD_PARTY= "";
    public static final String AUTHENTICATION_FAILED = "AUTHENTICATION_FAILED";
    public static final String SABRE_DISCONNECTION = "SABRE_DISCONNECTION";
    public static final String SABRE_UNAVAILABLE = "SABRE_UNAVAILABLE";


    //Logs
    public static final String TRANSACTION_ID = "TRANSACTION_ID";
    public static final String REQUEST = "REQUEST";
    public static final String LOCAL = "LOCAL";
    public static final String LOG_HEAD ="{} | TRANSACTION_ID: {} | PNR: {} | URL: {} | REQUEST: {} | RESPONSE: {}";
    public static final String LOG_SABRE_CREDENTIALS = "{} | TRANSACTION_ID: {} | PNR: {} | message=Sabre Session has been closed for username={} and channel={}";
    public static final String HEADER_MESSAGE_ERROR = "This header is incorrect or is it poorly formed";
    public static final String INVALID_REQUEST = "INVALID_REQUEST";

    //Characters
    public static final String DASH = "_";
    public static final String WHITE_SPACE = " ";
    public static final String AMPERSAND = "&";

    public static final boolean TRUE = true;
    public static final String STRING_EMPTY = "";
    public static final String PIPE_SEPARATOR = " | ";

    //Sabre
    public static final String EMPTY_RESPONSE = "Empty Response";

    public static final String UNDEFINED = "undefined";


    public static final String BODY_TAG_START = ">, <body = ";
    public static final String PARAMS_QRY_NA = "<params= N/A>, <query = N/A>";
    public static final String START_HEADER = "<headers = ";



    private Constants() {
    }
}
