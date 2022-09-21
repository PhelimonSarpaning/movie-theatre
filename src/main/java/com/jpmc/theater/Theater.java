package com.jpmc.theater;

import com.jpmc.theater.utils.LocalDateProvider;
import com.jpmc.theater.utils.SchedulePrintOut;

import java.util.List;

public class Theater {

    LocalDateProvider provider;

    public Theater(LocalDateProvider provider) {
        this.provider = provider;
    }

    public List<Showing> getTheaterSchedule(List<Showing> schedule) {
        return schedule;
    }

    public void getTheaterSchedule(List<Showing> schedule, boolean shouldPrint) {
        SchedulePrintOut schedulePrintOut = new SchedulePrintOut();
        schedulePrintOut.printSchedule(schedule);
        schedulePrintOut.printScheduleJSON(schedule);
    }

}
