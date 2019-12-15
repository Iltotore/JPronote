package fr.jpronote.auth;

import fr.jpronote.handler.SubjectMarks;

import java.net.HttpURLConnection;
import java.util.List;

public class OnlineSession extends OfflineSession {

    private HttpURLConnection connection;

    public OnlineSession(SessionInfo info, HttpURLConnection connection, List<List<SubjectMarks>> marks) {
        super(info, marks);
        this.connection = connection;
    }

    public HttpURLConnection getConnection() {
        return connection;
    }

    public static OnlineSession fromOffline(OfflineSession session, HttpURLConnection connection) {
        return new OnlineSession(session.getInfo(), connection, session.getAllMarks());
    }
}
