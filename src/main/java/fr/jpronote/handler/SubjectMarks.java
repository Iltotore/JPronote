package fr.jpronote.handler;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public static SubjectMarks fromJSON(JsonObject object) {
        List<Mark> marks = new ArrayList<>();

        for(JsonElement rawMark : object.getAsJsonArray("marks")) {
            JsonObject markObject = rawMark.getAsJsonObject();
            marks.add(Mark.fromJSON(markObject));
        }

        return new SubjectMarks(object.get("name").getAsString(),
                object.get("average").getAsFloat(),
                object.get("studentClassAverage").getAsFloat(),
                object.get("maxAverage").getAsFloat(),
                object.get("minAverage").getAsFloat(), marks);
    }
}
