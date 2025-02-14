package com.demo.utils;


import com.demo.configuration.ApplicationProperties;
import com.demo.dto.request.EmployerRequest;
import com.demo.exception.BadRequestException;
import com.demor.dto.CustomerDTO;
import com.demor.dto.DataForLogs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.commons.lang3.StringUtils;


import javax.xml.namespace.QName;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.demo.constant.Constants.CHANNEL;
import static com.demo.constant.Constants.ERROR_INVALID_HEADERS;
import static com.demo.constant.Constants.FLOW;
import static com.demo.constant.Constants.PNR;
import static com.demo.constant.Constants.STORE;
import static com.demo.constant.Constants.X_TRANSACTION_ID;

public class Util {

    private static List<String> propertiesNotFound = null;

  

    public static DataForLogs buildDataForLogs(HttpServletRequest httpServletRequest) throws IOException {

        DataForLogs dataForLogs = new DataForLogs();
        dataForLogs.setUrlRequest(httpServletRequest.getRequestURL().toString());
         dataForLogs.setBodyRequest(new String(httpServletRequest.getInputStream().readAllBytes(), StandardCharsets.UTF_8).replace("\n", "").replace("\t", "").replace("\r", ""));

        Map<String, String> mapHeader = new HashMap<>();

        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                String value = httpServletRequest.getHeader(key);

                mapHeader.put(key, value);
            }
        }

        dataForLogs.setMapHeader(mapHeader);

        return dataForLogs;
    }

    public static DataForLogs buildDataForLogs(CustomerDTO validCustomerDTO) throws IOException {

        DataForLogs dataForLogs = new DataForLogs();

            return dataForLogs;
    }
    public static DataForLogs toStringRQ(CustomerDTO validCustomerDTO) throws IOException {

        DataForLogs dataForLogs = new DataForLogs();

             return dataForLogs;
    }



   
    private static String validateHeader(String headerName, String header, List<String> headersAvailables) {

        headersAvailables = headersAvailables.stream().map(String::toLowerCase).toList();

        if (!headersAvailables.contains(header.toLowerCase())) {
            propertiesNotFound.add(headerName);
            return null;
        }

        return header;
    }




  
}
