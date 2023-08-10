package ru.vershinin.controller.impl;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.vershinin.config.ProcessConstants;
import ru.vershinin.controller.BidController;
import ru.vershinin.dto.BidDto;

@Slf4j
@RequiredArgsConstructor
public class BidControllerImp implements BidController {

    private final ZeebeClient client;

    @Override
    public void startProcessInstance(BidDto bidDto) {
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



