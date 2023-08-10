package ru.vershinin.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.springframework.stereotype.Component;

@Component
public class ChangeStatusWorker {

    @JobWorker(type = "status_new")
    public void statusNew(final JobClient client, final ActivatedJob job, @Variable String someResult){
        // TODO document why this method is empty
    }

    @JobWorker(type = "status_accept")
    public void statusAccept(final JobClient client, final ActivatedJob job, @Variable String someResult){
        // TODO document why this method is empty
    }

    @JobWorker(type = "status_processed")
    public void statusProcessed(final JobClient client, final ActivatedJob job, @Variable String someResult){
        // TODO document why this method is empty
    }

    @JobWorker(type = "status_rejected")
    public void statusRejected(final JobClient client, final ActivatedJob job, @Variable String someResult){
        // TODO document why this method is empty
    }

}
