/**
 *
 */
package com.aconex.challenge.vehicle;

/**
 * @author bmaturi
 */
public enum Day {
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday"),
    SUNDAY(7, "SUnday");

    private final int value;
    private final String description;

    Day(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Day fromValue(int value) {
        for (final Day e : Day.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
