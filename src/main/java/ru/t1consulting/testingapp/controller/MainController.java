package ru.t1consulting.testingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.t1consulting.testingapp.service.FrequencyCounterService;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class MainController {

    private final FrequencyCounterService frequencyCounterService;

    @GetMapping("/freqs")
    public String getFrequencies(@RequestBody String str) {
        return frequencyCounterService.countFrequencies(str);
    }

}
