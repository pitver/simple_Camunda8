package ru.vershinin.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.springframework.stereotype.Component;

@Component
public class AddEntryToDBWorker {

    @JobWorker(type = "add_bid")
    public void addEntry(final JobClient client, final ActivatedJob job, @Variable String someResult){
        // TODO document why this method is empty
    }
}
