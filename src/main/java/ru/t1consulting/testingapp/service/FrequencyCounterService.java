package ru.t1consulting.testingapp.service;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;


@Validated
public interface FrequencyCounterService {

    String countFrequencies(@NotNull @NotEmpty String str);

}
