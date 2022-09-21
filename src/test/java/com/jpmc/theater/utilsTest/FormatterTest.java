package com.jpmc.theater.utilsTest;

import com.jpmc.theater.utils.Formatter;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {
    @Test
    void checkFormatterWorks() {
        Duration duration = Duration.ofMinutes(90);
        Duration durationSec = Duration.ofMinutes(180);

        assertEquals("(1 hour 30 minutes)", Formatter.humanReadableFormat(duration));
        assertEquals("(3 hours 0 minutes)", Formatter.humanReadableFormat(durationSec));
    }
}
