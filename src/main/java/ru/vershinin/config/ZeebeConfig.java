package ru.vershinin.config;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration
public class ZeebeConfig {

   // @Bean
   // @Primary
    public ZeebeClient zeebeClient() {
        // Указать адрес и порт брокера Zeebe
        String brokerAddress = "localhost:26500";

        // Создать и вернуть экземпляр ZeebeClient
        return ZeebeClient.newClientBuilder()
                .gatewayAddress(brokerAddress)
                .build();
    }
}
