package fr.jpronote.handler;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Homework {

    private String subject;
    private String content;
    private long since;
    private long until;
    private boolean toGive;
    private Collection<PronoteFile> files;

    public Homework(String subject, String content, long since, long until, boolean toGive, Collection<PronoteFile> files) {
        this.subject = subject;
        this.content = content;
        this.since = since;
        this.until = until;
        this.toGive = toGive;
        this.files = files;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public long getSince() {
        return since;
    }

    public long getUntil() {
        return until;
    }

    public boolean isToGive() {
        return toGive;
    }

    public Collection<PronoteFile> getFiles() {
        return files;
    }

    public static Homework fromJSON(JsonObject object) {

        List<PronoteFile> files = new ArrayList<>();

        for(JsonElement element : object.getAsJsonArray("files")) {
            files.add(PronoteFile.fromJSON(element.getAsJsonObject()));
        }

        return new Homework(object.get("subject").getAsString(),
                object.get("content").getAsString(),
                object.get("since").getAsLong(),
                object.get("until").getAsLong(),
                object.get("toGive").getAsBoolean(),
                files);
    }
}
