package ru.vershinin.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestWorker {

    @JobWorker(type = "test123")
    public void send(final ActivatedJob job, @Variable int response) {

        log.info("inn {}", response);


    }@JobWorker(type = "mail")
    public void sendMail() {

        log.info("send mail");


    }

}
