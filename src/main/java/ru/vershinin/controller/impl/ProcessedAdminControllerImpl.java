package ru.vershinin.controller.impl;

import io.camunda.zeebe.client.ZeebeClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.vershinin.config.MessageConstants;
import ru.vershinin.config.ProcessConstants;
import ru.vershinin.controller.ProcessedAdminController;

@Slf4j
@RequiredArgsConstructor
public class ProcessedAdminControllerImpl implements ProcessedAdminController {
    private final ZeebeClient client;

    @Override
    public void acceptOrder(String orderId, String userId) {
        log.info("Correlate process {} message {}",
                ProcessConstants.BPMN_PROCESS_PROCESSED_ORDER,
                MessageConstants.ACCEPT_ORDER);

        client.newPublishMessageCommand()
                .messageName(MessageConstants.ACCEPT_ORDER)
                .correlationKey(orderId + userId)
                .send()
                .join();
    }

    @Override
    public void processedOrder(String orderId, String userId, String decision) {
        log.info("Correlate process {} message {}",
                ProcessConstants.BPMN_PROCESS_PROCESSED_ORDER,
                MessageConstants.PROCESSED);

        client.newPublishMessageCommand()
                .messageName(MessageConstants.PROCESSED)
                .correlationKey(orderId + userId)
                .variables(decision)
                .send()
                .join();
    }
}
