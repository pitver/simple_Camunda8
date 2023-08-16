package ru.vershinin.controller;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vershinin.config.ProcessConstants;
import ru.vershinin.dto.BidDto;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RunController {



    private final ZeebeClient client;


    @PostMapping("/start")
    public ResponseEntity<String> startProcessInstance(@RequestBody BidDto bidDto) {

        log.info("Starting process `" + ProcessConstants.BPMN_PROCESS_CREATE_BID_OPERATOR);

        Map<String, Object> variable = new HashMap<>();
        variable.put("bid", bidDto);

        ProcessInstanceEvent instanceEvent = client
                .newCreateInstanceCommand()
                .bpmnProcessId(ProcessConstants.BPMN_PROCESS_CREATE_BID_OPERATOR)
                .latestVersion()
                .variables(variable)
                .send()
                .join();
        log.info(instanceEvent.getBpmnProcessId());
        var result = String.valueOf(instanceEvent.getProcessInstanceKey());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Started process instance " + result);
    }

    @GetMapping("/accept/{inn}")
    public void correlateMsgAccept(@PathVariable String inn) {

        client.newPublishMessageCommand()
                .messageName("accept")
                .correlationKey(inn)
                .send().join();
    }

    @GetMapping("/processed/{inn}")
    public void correlateMsgProcessed(@PathVariable String inn) {
        Map<String, Integer> wr = new HashMap<>();
        wr.put("decision",0);

        client.newPublishMessageCommand()
                .messageName("processed")
                .correlationKey(inn)
                .variables(wr)
                .send().join();
    }

 }




