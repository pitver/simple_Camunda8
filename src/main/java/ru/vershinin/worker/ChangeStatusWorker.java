package ru.vershinin.worker;


import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.vershinin.dto.BidDto;
import ru.vershinin.enums.StatusBid;

import java.util.Arrays;

@Slf4j
@Component
public class ChangeStatusWorker {

    @JobWorker(type = "change_status")
    public void changeStatus(final JobClient client, final ActivatedJob job, @VariablesAsType BidDto bidDto, @Variable String status){
        log.info(bidDto.toString());

        Arrays.stream(StatusBid.values())
                .filter(st -> st.getName().equals(status))
                .findFirst()
                .ifPresent(bidDto::setStatusBid);

        client.newCompleteCommand(job.getKey())
                .variables("{\"bidDto\": \"" + bidDto + "\", \"{\"action\": \"" + bidDto.getFlag() + "\"}")
                .send()
                .exceptionally( throwable -> { throw new RuntimeException("Could not complete job " + job, throwable); });
        log.info(bidDto.getStatusBid().getName());

    }
}
