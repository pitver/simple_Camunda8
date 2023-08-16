package ru.vershinin.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailWorker {
    @JobWorker(type = "mail")
    public void mail(final ActivatedJob job,@Variable int type) {
        log.info("mail type: {}", type);
    }

}
