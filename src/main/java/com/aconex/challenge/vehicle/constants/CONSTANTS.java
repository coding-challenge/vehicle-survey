/**
 *
 */
package com.aconex.challenge.vehicle.constants;

/**
 * @author bmaturi
 */
public class CONSTANTS {

    public static final class MILLIS {

        public static final long HOUR = 60 * 60 * 1000;
        public static final long HALF_HOUR = HOUR / 2;
        public static final long QUARTER_HOUR = HOUR / 4;
        public static final long TWENTY_MINUTES = HOUR / 3;
        public static final long DAY = HOUR * 24;
        public static final long HALFDAY = HOUR * 12;
    }

    public static final class DATE_PATTERN {

        public static final String HOUR_PATTERN = "HH:mm";
    }

}
