package Util;

/**
 * Created by Hance on 2016-12-22.
 */
public class Clock {
    private static Clock GlobalClock = new Clock();

    public static int CurrentTime = 23451;

    public static Clock getInstance() {
        return GlobalClock;
    }

    private Clock() {
    }
}
