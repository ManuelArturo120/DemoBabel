package com.demo.exception;



import com.demor.dto.DataForLogs;
import com.demo.utils.LogUtil;
import com.demo.utils.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.io.IOException;


import static com.demo.constant.Constants.AUTHENTICATION_FAILED;
import static com.demo.constant.Constants.CHANNEL_DEFAULT;

import static com.demo.constant.Constants.DASH;


import static com.demo.constant.Constants.INVALID_HEADERS;
import static com.demo.constant.Constants.INVALID_REQUEST;

import static com.demo.constant.Constants.SABRE_DISCONNECTION;
import static com.demo.constant.Constants.SABRE_UNAVAILABLE;

import static com.demo.constant.Constants.STRING_EMPTY;

import static com.demo.constant.Constants.THIRD_PARTY;
import static com.demo.constant.Constants.WHITE_SPACE;

@ControllerAdvice
public class ControllerAdvisor {



 

    @ExceptionHandler(value = { HttpMessageNotReadableException.class })
    protected ResponseEntity<Object> handleConstraintViolation(HttpMessageNotReadableException ex, HttpServletRequest httpServletRequest) throws IllegalArgumentException, IOException {
        DataForLogs dataForLogs = Util.buildDataForLogs(httpServletRequest);
        LogUtil.printLogError(INVALID_REQUEST, dataForLogs.getUrlRequest(), LogUtil.buildLogResponse(STRING_EMPTY, ex.getMessage(), STRING_EMPTY, STRING_EMPTY), LogUtil.buildLogRequest(dataForLogs));
        return getResponseEntity( HttpStatus.BAD_REQUEST.getReasonPhrase().toUpperCase().replace(WHITE_SPACE,DASH), HttpStatus.BAD_REQUEST);
    }




    @ExceptionHandler(value = { BadRequestException.class})
    protected ResponseEntity<Object> handleConstraintViolation(BadRequestException ex, HttpServletRequest httpServletRequest) throws IllegalArgumentException, IOException {
        DataForLogs dataForLogs = Util.buildDataForLogs(httpServletRequest);
        LogUtil.printLogError( INVALID_HEADERS, dataForLogs.getUrlRequest(), LogUtil.buildLogResponse(STRING_EMPTY, ex.getInvalidHeaders(), STRING_EMPTY, STRING_EMPTY), LogUtil.buildLogRequest(dataForLogs, ex.getRequest()));
        return getResponseEntity( HttpStatus.BAD_REQUEST.getReasonPhrase().toUpperCase().replace(WHITE_SPACE,DASH), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<Object> handleInternalServerError(InternalServerError ex, HttpServletRequest httpServletRequest) throws IOException {
        DataForLogs dataForLogs = Util.buildDataForLogs(httpServletRequest);
        return getResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase().toUpperCase().replace(WHITE_SPACE,DASH), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(DataBaseDisconnectionException.class)
    public ResponseEntity<Object> handleDataBaseError(DataBaseDisconnectionException ex, HttpServletRequest httpServletRequest) throws IOException {
        DataForLogs dataForLogs = Util.buildDataForLogs(httpServletRequest);
        return getResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase().toUpperCase().replace(WHITE_SPACE,DASH), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(MethodArgumentNotValidException ex, HttpServletRequest httpServletRequest) throws IOException {
        DataForLogs dataForLogs = Util.buildDataForLogs(httpServletRequest);
        LogUtil.printLogError( INVALID_REQUEST, dataForLogs.getUrlRequest(), LogUtil.buildLogResponse(STRING_EMPTY, ex.getMessage(), STRING_EMPTY, STRING_EMPTY), LogUtil.buildLogRequest(dataForLogs));
        return getResponseEntity( HttpStatus.BAD_REQUEST.getReasonPhrase().toUpperCase().replace(WHITE_SPACE,DASH), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Object> handlerMethodValidationException(HandlerMethodValidationException ex, HttpServletRequest httpServletRequest) throws IOException {
        DataForLogs dataForLogs = Util.buildDataForLogs(httpServletRequest);
        LogUtil.printLogError( INVALID_REQUEST, dataForLogs.getUrlRequest(), LogUtil.buildLogResponse(STRING_EMPTY, ex.getMessage(), STRING_EMPTY, STRING_EMPTY), LogUtil.buildLogRequest(dataForLogs));
        return getResponseEntity( HttpStatus.BAD_REQUEST.getReasonPhrase().toUpperCase().replace(WHITE_SPACE, DASH), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = { HttpMediaTypeNotSupportedException.class})
    protected ResponseEntity<Object> handleConstraintViolation(HttpMediaTypeNotSupportedException ex, HttpServletRequest httpServletRequest) throws IllegalArgumentException, IOException {
        return getObjectResponseEntity(httpServletRequest,ex.getMessage());
    }

    //For Headers flow, reservationCode, store, x-transactionId, channel, Content-Type
    @ExceptionHandler(value = { ConstraintViolationException.class })
    protected ResponseEntity<Object> handleConstraintViolationHeader(ConstraintViolationException ex, HttpServletRequest httpServletRequest) throws IllegalArgumentException, IOException {
        return getObjectResponseEntity(httpServletRequest,ex.getMessage());
    }

    @ExceptionHandler(value = { MissingRequestHeaderException.class })
    protected ResponseEntity<Object> handleConstraintViolationHeader(MissingRequestHeaderException ex, HttpServletRequest httpServletRequest) throws IllegalArgumentException, IOException {
        return getObjectResponseEntity(httpServletRequest,ex.getMessage());
    }

    private ResponseEntity<Object> getObjectResponseEntity(HttpServletRequest httpServletRequest, String message) throws IOException {
        DataForLogs dataForLogs = Util.buildDataForLogs(httpServletRequest);
        LogUtil.printLogError(INVALID_HEADERS, dataForLogs.getUrlRequest(), LogUtil.buildLogResponse(STRING_EMPTY, message, STRING_EMPTY, STRING_EMPTY), LogUtil.buildLogRequest(dataForLogs));
        return getResponseEntity(HttpStatus.BAD_REQUEST.getReasonPhrase().toUpperCase().replace(WHITE_SPACE,DASH), HttpStatus.BAD_REQUEST);
    }

    
    private ResponseEntity<Object> getResponseEntity(String reason, HttpStatus httpStatus){
        return new ResponseEntity<>(new ErrorMessage(  reason, httpStatus.value()), httpStatus);
    }
    
}
