package ru.vershinin.worker;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.vershinin.dto.BidDto;

@Slf4j
@Component
public class AddEntryToDBWorker {

    @JobWorker(type = "add_bid")
    public void addEntry(@VariablesAsType BidDto bidDto) {
        log.info("AddEntryToDBWorker: {}", bidDto.toString());
    }
}
