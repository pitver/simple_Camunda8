package ru.vershinin.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/util/")
public class GetInnController {

    @GetMapping("/getInn")
    public int getInn(){
        int maxLength = 9; // Максимальная длина случайного числа

        Random random = new Random();
        return random.nextInt((int) Math.pow(10, maxLength));
    }
}