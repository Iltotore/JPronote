package fr.jpronote;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.jpronote.auth.Session;
import fr.jpronote.auth.SessionInfo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JPronote {

    private URL url;

    public JPronote(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public Session createSession(SessionInfo info) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        JsonObject request = new JsonObject();
        request.addProperty("type", info.getType().name().toLowerCase());
        request.addProperty("username", info.getUsername());
        request.addProperty("password", info.getPassword());
        request.addProperty("url", info.getUrl().toString());
        request.addProperty("cas", info.getContext().getId());
        System.out.println(request);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(request.toString().getBytes(StandardCharsets.UTF_8));
        outputStream.close();
        InputStream inputStream = connection.getInputStream();
        JsonObject response = JsonParser.parseReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).getAsJsonObject();
        System.out.println(response);
        return new Session(info, connection);
    }
}
