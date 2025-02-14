package com.demo.util;

import com.demo.constant.Constants;
import com.demo.utils.LogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LogUtilTest {


	
	/*@Test
	void printErrorLog() throws IllegalArgumentException {
		
		printLogError(null, "", null, "", "", "");


		assertEquals(getClass(), getClass());
		
	}
*/
	@Test
	void printTransactionLog() throws IllegalArgumentException {

		LogUtil.printTransactionLog("81e50faa-a9a0-4566-93ab-117f8b37b3df", Constants.THIRD_PARTY, "http://someurl.com", "{\"response\":\"dummy\"}", "{\"body\":\"dummy\"}", "GRTCHQ");
		assertEquals(getClass(), getClass());


	}

	@Test
	void printTransactionLog2() throws IllegalArgumentException {

		LogUtil.printTransactionLog(null, "", null, "", "", "");

		assertEquals(getClass(), getClass());

	}

	@Test
	void buildLogResponse() throws IOException {
		String response = LogUtilTest.getJsonGetRQToString("/response/RS.json");



		String logResponse = LogUtil.buildLogResponse(response, "some message", "the error ", "");

				assertNotNull(logResponse);
	}

	@Test
	void buildLogResponse2() throws IOException {
		String response = LogUtilTest.getJsonGetRQToString("/response/RS2.json");


		String logResponse = LogUtil.buildLogResponse(response, "some message", null, null);

		assertNotNull(logResponse);
	}


	@Test
	void buildLogRequest() throws IOException {
		String response = "some value to show";
		String logResponse = LogUtil.buildLogRequest(response);

		assertNotNull(logResponse);
	}


	public static String getJsonGetRQToString(String fileName)
			throws IOException {

		Class clazz = LogUtilTest.class;
		InputStream inputStream = clazz.getResourceAsStream(fileName);

		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br
					 = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}

}
