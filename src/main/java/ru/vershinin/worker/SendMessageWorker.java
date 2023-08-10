package ru.vershinin.worker;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendMessageWorker {

    @Qualifier("zeebe")
    @Autowired
    private ZeebeClient client;

    @JobWorker(type = "sendMessage")
    public void send(final ActivatedJob job, @Variable int response) {

        log.info("inn {}", response);
        client.newPublishMessageCommand()
                .messageName("returnMessage")
                .correlationKey("businessKey")
                .send();

    }


}
