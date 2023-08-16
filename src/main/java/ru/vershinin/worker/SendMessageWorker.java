package ru.vershinin.worker;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vershinin.dto.BidDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendMessageWorker {

    Random rd = new Random();

    private final ZeebeClient client;
    private final ObjectMapper objectMapper;

    @JobWorker(type = "sendMessage")
    public void send(final ActivatedJob job) {
        var variables = job.getVariablesAsMap();
        var bid = objectMapper.convertValue(variables.get("bid"), BidDto.class);
        String inn = (String) variables.get("inn");

        int maxLength = 9; // Максимальная длина случайного числа

        log.info("inn {}", inn);
        Map<String,Object> variable=new HashMap<>();
        variable.put("inn",inn);
        variable.put("bid",bid);
        client.newPublishMessageCommand()
                .messageName("returnMessage")
                .correlationKey("businessKey" + rd.nextInt((int) Math.pow(3, maxLength)))
                .variables(variable)
                .send();

    }


}
