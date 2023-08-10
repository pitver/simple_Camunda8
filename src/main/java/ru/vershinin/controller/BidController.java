package ru.vershinin.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vershinin.dto.BidDto;

@RestController
public interface BidController {

    @PostMapping("/start")
    void startProcessInstance(@RequestBody BidDto bidDto);

}
