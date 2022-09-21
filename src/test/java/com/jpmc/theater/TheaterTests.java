package com.jpmc.theater;

import com.jpmc.theater.utils.LocalDateProvider;
import org.junit.jupiter.api.Test;

import static com.jpmc.theater.TestData.TEST_SCHEDULE;

public class TheaterTests {
    @Test
    void getTheaterScheduleAndPrint() {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.getTheaterSchedule(TEST_SCHEDULE, true);
    }
}
