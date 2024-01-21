package ru.t1consulting.testingapp.service;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class FrequencyCounterServiceImplTest {

    @Autowired
    private FrequencyCounterService frequencyCounterService;

    @Test
    void countFrequenciesSucceed() {
        String str = "abbcccccdddeeee";
        String expected = "\"c\":5, \"e\":4, \"d\":3, \"b\":2, \"a\":1";

        String result = frequencyCounterService.countFrequencies(str);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void countFrequenciesThrowsWhenStrIsNull() {
        assertThrows(ConstraintViolationException.class, () -> frequencyCounterService.countFrequencies(null));
    }

    @Test
    void countFrequenciesThrowsWhenStrIsEmpty() {
        assertThrows(ConstraintViolationException.class, () -> frequencyCounterService.countFrequencies(""));
    }
}