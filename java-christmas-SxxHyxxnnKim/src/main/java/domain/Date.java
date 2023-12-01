package domain;

import java.util.Calendar;

public class Date {

    private final int YEAR = 2023;
    private final int day;
    private boolean isWeekend;
    private boolean isStarDay;
    private boolean isChristmas;

    public Date(int day) {
        this.day = day;
        determinedDate(day);
        ChristmasDay(day);
    }

    public int getDay() {
        return day;
    }

    public boolean getIsWeekend() {
        return isWeekend;
    }

    public boolean getIsStarDay() {
        return isStarDay;
    }

    public boolean getIsChristmas() {
        return isChristmas;
    }

    public void determinedDate(int date) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(YEAR, Calendar.DECEMBER, day);

        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);

        if (dayOfWeek == java.util.Calendar.MONDAY ||
                dayOfWeek == java.util.Calendar.TUESDAY ||
                dayOfWeek == java.util.Calendar.WEDNESDAY ||
                dayOfWeek == java.util.Calendar.THURSDAY) {
            isWeekend = false;
        } else if (dayOfWeek == java.util.Calendar.FRIDAY || dayOfWeek == java.util.Calendar.SATURDAY
        ) {
            isWeekend = true;
        } else if (dayOfWeek == java.util.Calendar.SUNDAY) {
            isWeekend = false;
            isStarDay = true;
        }
    }

    public void ChristmasDay(int date) {
        if (date == 25) {
            isStarDay = true;
            isChristmas = true;
            isWeekend = false;
        }
    }

}
