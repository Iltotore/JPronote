package fr.jpronote.handler;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PronoteFile {

    private String name;
    private URL url;

    public PronoteFile(String name, URL url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public URL getUrl() {
        return url;
    }

    public InputStream getInputStream() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        return connection.getInputStream();
    }

    public static PronoteFile fromJSON(JsonObject object) {
        try {
            return new PronoteFile(object.get("name").getAsString(), new URL(object.get("url").getAsString()));
        } catch(MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
