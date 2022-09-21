package com.jpmc.theater.utilsTest;

import com.jpmc.theater.Showing;
import com.jpmc.theater.TestData;
import com.jpmc.theater.Theater;
import com.jpmc.theater.utils.LocalDateProvider;
import com.jpmc.theater.utils.SchedulePrintOut;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SchedulePrintOutTest {
    Theater theater = new Theater(LocalDateProvider.singleton());
    List<Showing> schedule = theater.getTheaterSchedule(TestData.TEST_SCHEDULE);
    SchedulePrintOut schedulePrintOut = new SchedulePrintOut();

    @Test
    void printMovieSchedule() {
        schedulePrintOut.printSchedule(schedule);
    }

    @Test
    void printMovieScheduleJson() {
        schedulePrintOut.printScheduleJSON(schedule);
    }
}
