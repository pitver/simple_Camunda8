package ru.vershinin.worker;


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
import ru.vershinin.enums.StatusBid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChangeStatusWorker {

    private final ObjectMapper objectMapper;

    @JobWorker(type = "change_status")
    public void changeStatus(final JobClient client, final ActivatedJob job) {

        var variables = job.getVariablesAsMap();
        var bid = objectMapper.convertValue(variables.get("bid"), BidDto.class);
        String status = (String) variables.get("status");

        Arrays.stream(StatusBid.values())
                .filter(st -> st.getName().equals(status))
                .findFirst()
                .ifPresent(bid::setStatusBid);

        Map<String,Object> variable=new HashMap<>();
        variable.put("bid",bid);
        variable.put("action",bid.getFlag());
        client.newCompleteCommand(job.getKey())
                .variables(variable)
                .send()
                .exceptionally(throwable -> {
                    throw new RuntimeException("Could not complete job " + job, throwable);
                });
        log.info(bid.getStatusBid().getName());

    }
}
