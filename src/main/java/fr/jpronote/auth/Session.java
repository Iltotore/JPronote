package fr.jpronote.auth;

import java.net.HttpURLConnection;

public class Session {

    private SessionInfo info;
    private HttpURLConnection connection;

    public Session(SessionInfo info, HttpURLConnection connection) {
        this.info = info;
        this.connection = connection;
    }

    public SessionInfo getInfo() {
        return info;
    }

    public HttpURLConnection getConnection() {
        return connection;
    }
}
