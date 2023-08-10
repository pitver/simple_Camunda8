package ru.vershinin;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "classpath*:/bpmn/*.*")
public class SimpleCamunda8Application {

    public static void main(String[] args) {
        SpringApplication.run(SimpleCamunda8Application.class, args);
    }

}
