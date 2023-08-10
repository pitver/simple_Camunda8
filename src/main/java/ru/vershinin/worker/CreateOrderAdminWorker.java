package ru.vershinin.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderAdminWorker {

    @JobWorker(type = "create_order_admin")
    public void createOrderAdmin(final JobClient client, final ActivatedJob job, @Variable String someResult){
        // TODO document why this method is empty
    }


}
