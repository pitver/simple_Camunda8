package ru.vershinin.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/{orderId}/user/{userId}")
public interface ProcessedAdminController {

    @GetMapping("/accept")
    void acceptOrder(@PathVariable String orderId, @PathVariable String userId);

    @GetMapping("/decision/{decision}/processed")
    void processedOrder(@PathVariable String orderId, @PathVariable String userId, @PathVariable String decision);
}
