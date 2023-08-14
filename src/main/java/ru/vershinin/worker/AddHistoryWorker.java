package ru.vershinin.worker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.vershinin.dto.BidDto;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddHistoryWorker {
    private final ObjectMapper objectMapper;
    @JobWorker(type = "add_history")
    public void changeStatus(final JobClient client, final ActivatedJob job) {
        var variables = job.getVariablesAsMap();
        var bid = objectMapper.convertValue(variables.get("bid"), BidDto.class);
       log.info(bid.toString());
    }
}
