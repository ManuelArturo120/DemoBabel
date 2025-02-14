package com.demo.configuration;


import com.demo.dto.request.EmployerRequest;
import com.demo.utils.Util;
import com.demor.dto.CustomerDTO;

import com.demor.dto.LogStructure;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import static com.demo.constant.Constants.THIRD_PARTY;

@Aspect
@Component
@Slf4j
@EnableAsync
public class LoggingConfiguration {

    /* 
    
    @Async
    @AfterReturning(
            pointcut = "execution(*com.demo.dto.response.EmployeeResponse(..))",
            returning = "result"
    )
   public void logSabreTransaction(JoinPoint joinPoint, EmployerRequest result) {
        Object[] params = joinPoint.getArgs();
        CustomerDTO validCustomerDTO = (CustomerDTO) params[3];

        String response = result.toString();
   log.info(StringUtils.normalizeSpace(LogStructure.builder()
                .request(null)
                .response(response)
                .build()
                .getTransactionLog())
        );
    }

    }*/
	  /*    @Async
    @AfterThrowing(
    	    pointcut = "execution(*com.demo.dto.response.EmployeeResponse(..))",
            throwing = "ex"
    )
    public void logSabreException(JoinPoint joinPoint, Exception ex) {
        Object[] params = joinPoint.getArgs();
        CustomerDTO validCustomerDTO = (CustomerDTO) params[3];

       // String request = Util.toStringRQ((EmployeeResponse) params[0]);

   log.error(StringUtils.normalizeSpace(LogStructure.builder()
                .exceptionMessage(ex.getMessage())
                .build()
                .getExceptionLog())
        )
    };*/
}
