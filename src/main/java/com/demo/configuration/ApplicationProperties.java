package com.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {

    public static String arrayHeadersChannel;
    public static String arrayHeadersFlow;
    public static String arrayHeadersStore;

    @Value("${array.headers.channel}")
    public void setArrayHeadersChannel(String environmentKey) {
        ApplicationProperties.arrayHeadersChannel = environmentKey;
    }

    @Value("${array.headers.flow}")
    public void setArrayHeadersFlow(String environmentKey) {
        ApplicationProperties.arrayHeadersFlow = environmentKey;
    }

    @Value("${array.headers.store}")
    public void setArrayHeadersStore(String environmentKey) {
        ApplicationProperties.arrayHeadersStore = environmentKey;
    }
}
