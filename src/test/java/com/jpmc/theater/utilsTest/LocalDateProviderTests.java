package com.jpmc.theater.utilsTest;

import com.jpmc.theater.utils.LocalDateProvider;
import org.junit.jupiter.api.Test;

public class LocalDateProviderTests {
    @Test
    void makeSureCurrentTime() {
        System.out.println("current time is - " + LocalDateProvider.singleton().currentDate());
    }
}
