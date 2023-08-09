package ru.vershinin.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.vershinin.dto.BidDto;

@Slf4j
@Component

public class AddHistoryWorker {
    @JobWorker(type = "add_history")
    public void changeStatus(final JobClient client, final ActivatedJob job, @VariablesAsType BidDto bidDto) {
        log.info(bidDto.toString());
    }
}
