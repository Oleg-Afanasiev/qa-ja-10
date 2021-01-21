package com.academy.telesens.lesson07;

public class CustomDateTime {
    public final int DEFAULT_SECOND = 0;

    private int second = DEFAULT_SECOND;
    private int minute;
    private int hour;

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (!isValid(second, this.minute, this.hour)) {
            this.second = DEFAULT_SECOND;
            return;
        }

        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isValid(int second, int minute, int hour) {
        if (second < 0 || second > 59)
            return false;

        //...

        return true;
    }

    @Override
    public String toString() {
        return "CustomDateTime{" +
                "second=" + second +
                ", minute=" + minute +
                ", hour=" + hour +
                '}';
    }
}
