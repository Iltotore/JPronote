package fr.jpronote.auth;

import fr.jpronote.handler.Homework;
import fr.jpronote.handler.SubjectMarks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OfflineSession {

    private SessionInfo info;
    private List<List<SubjectMarks>> marks;
    private List<Homework> homeworks;

    public OfflineSession(SessionInfo info, List<List<SubjectMarks>> marks, Collection<Homework> homeworks) {
        this.info = info;
        this.marks = new ArrayList<>(marks);
        this.homeworks = new ArrayList<>(homeworks);
    }

    public SessionInfo getInfo() {
        return info;
    }

    public List<List<SubjectMarks>> getAllMarks() {
        return marks;
    }

    public Collection<SubjectMarks> getTrimesterMarks(int trimester) {
        return marks.get(trimester - 1);
    }

    public SubjectMarks getMarks(int trimester, String name) {
        for(SubjectMarks mark : getTrimesterMarks(trimester)) {
            if(mark.getName().equals(name)) return mark;
        }
        return null;
    }

    public List<Homework> getHomeworks() {
        return homeworks;
    }
}
