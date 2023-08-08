package ru.vershinin.controller;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vershinin.config.ProcessConstants;
import ru.vershinin.dto.BidDto;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RunController {

    private final ZeebeClient client;

    @PostMapping("/start")
    public void startProcessInstance(@RequestBody BidDto bidDto) {

        log.info("Starting process `" + ProcessConstants.BPMN_PROCESS_CREATE_BID_OPERATOR);

        ProcessInstanceEvent instanceEvent = client
                .newCreateInstanceCommand()
                .bpmnProcessId(ProcessConstants.BPMN_PROCESS_CREATE_BID_OPERATOR)
                .latestVersion()
                .variables(bidDto)
                .send()
                .join();
        log.info(instanceEvent.getBpmnProcessId());
        log.info(String.valueOf(instanceEvent.getProcessInstanceKey()));
    }
   /* @PostMapping("/std")
    public void correlateMsg(@RequestBody GetVar varb){
        Map<String,String> wr=new HashMap<>();
        wr.put("send",varb.getVariable());
        client.newPublishMessageCommand()
                .messageName("messageA")
                .correlationKey(varb.getPrId())
                .variables(wr)
                .send();
    }*/

}



