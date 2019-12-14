package fr.jpronote.auth;

import java.net.URL;

public class SessionInfo {

    private SessionType type;
    private String username;
    private String password;
    private URL url;
    private SessionContext context;

    public SessionInfo(SessionType type, String username, String password, URL url, SessionContext context) {
        this.type = type;
        this.username = username;
        this.password = password;
        this.url = url;
        this.context = context;
    }

    public SessionType getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public URL getUrl() {
        return url;
    }

    public SessionContext getContext() {
        return context;
    }
}
