package ru.t1consulting.testingapp.service;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyCounterServiceImpl implements FrequencyCounterService {

    @Override
    public String countFrequencies(@NotNull String str) {
        if (str.isEmpty()) return str;
        Map<Character, Long> map = countLetters(str);
        return sortByValueAndJoin(map);
    }

    private Map<Character, Long> countLetters(String str) {
        return str.chars()
            .mapToObj(ch -> (char) ch)
            .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
    }

    private String sortByValueAndJoin(Map<Character, Long> map) {
        return map.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .map(e -> "\"" + e.getKey() + "\":" + e.getValue())
            .collect(Collectors.joining(", "));
    }
}
