package fr.jpronote.handler;

import java.util.Collection;

public class Mark {

    private String subject;
    private String title;
    private float value;
    private boolean away;
    private float max;
    private float average;
    private float coefficient;
    private float higher;
    private float lower;
    private long time;
    private Collection<Mark> marks;

    public Mark(String subject, String title, float value, boolean away, float max, float average, float coefficient, float higher, float lower, long time, short period) {
        this.subject = subject;
        this.title = title;
        this.value = value;
        this.away = away;
        this.max = max;
        this.average = average;
        this.coefficient = coefficient;
        this.higher = higher;
        this.lower = lower;
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public float getValue() {
        return value;
    }

    public boolean isAway() {
        return away;
    }

    public float getMax() {
        return max;
    }

    public float getAverage() {
        return average;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public float getHigher() {
        return higher;
    }

    public float getLower() {
        return lower;
    }

    public long getTime() {
        return time;
    }

    public Collection<Mark> getMarks() {
        return marks;
    }
}
