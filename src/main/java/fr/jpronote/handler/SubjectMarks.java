package fr.jpronote.handler;

import java.util.Collection;

public class SubjectMarks {

    private String name;
    private float average;
    private float studentClassAverage;
    private float maxAverage;
    private float minAverage;
    private Collection<Mark> marks;

    public SubjectMarks(String name, float average, float studentClassAverage, float maxAverage, float minAverage, Collection<Mark> marks) {
        this.name = name;
        this.average = average;
        this.studentClassAverage = studentClassAverage;
        this.maxAverage = maxAverage;
        this.minAverage = minAverage;
    }

    public String getName() {
        return name;
    }

    public float getAverage() {
        return average;
    }

    public float getStudentClassAverage() {
        return studentClassAverage;
    }

    public float getMaxAverage() {
        return maxAverage;
    }

    public float getMinAverage() {
        return minAverage;
    }

    public Collection<Mark> getMarks() {
        return marks;
    }
}
