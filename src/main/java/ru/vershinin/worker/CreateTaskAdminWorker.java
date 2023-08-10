package ru.vershinin.worker;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.vershinin.config.ProcessConstants;

import static ru.vershinin.config.ProcessConstants.BPMN_PROCESS_PROCESSED_ORDER;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateTaskAdminWorker {

    private final ZeebeClient client;

    @JobWorker(type = "create_order_admin")
    public void createOrder(final JobClient jobClient){
        log.info("Start process {}", BPMN_PROCESS_PROCESSED_ORDER);
        client.newCreateInstanceCommand()
              .bpmnProcessId(BPMN_PROCESS_PROCESSED_ORDER)
              .latestVersion()
              .send()
              .join();
    }
}
