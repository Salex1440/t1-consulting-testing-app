package ru.t1consulting.testingapp.service;

import javax.validation.constraints.NotNull;

public interface FrequencyCounterService {

    String countFrequencies(@NotNull String str);

}
