package com.jpmc.theater.constants;

import java.time.LocalTime;

public class MovieCodes {
    public static int MOVIE_CODE_SPECIAL = 1;

    public static LocalTime MOVIE_START_TIME_FOR_DISCOUNT = LocalTime.parse("11:00:00");
    public static LocalTime MOVIE_END_TIME_FOR_DISCOUNT = LocalTime.parse("16:00:00");

    public static double TIME_DISCOUNT = 0.25;
    public static int DAY_FOR_DISCOUNT = 7;
    public static int DISCOUNT_FOR_DAY = 1;

}
