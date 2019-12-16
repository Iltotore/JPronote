package fr.jpronote;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.jpronote.auth.OfflineSession;
import fr.jpronote.auth.OnlineSession;
import fr.jpronote.auth.SessionInfo;
import fr.jpronote.handler.SubjectMarks;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JPronote {

    private URL url;

    public JPronote(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public OnlineSession createSession(SessionInfo info) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        JsonObject request = new JsonObject();
        request.addProperty("type", info.getType().name().toLowerCase());
        request.addProperty("username", info.getUsername());
        request.addProperty("password", info.getPassword());
        request.addProperty("url", info.getUrl().toString());
        request.addProperty("cas", info.getContext().getId());
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
        //System.out.println(response);

        return OnlineSession.fromOffline(createSession(info, response), connection);
    }

    public static OfflineSession createSession(SessionInfo info, JsonObject jsonObject) {
        List<List<SubjectMarks>> allMarks = new ArrayList<>();
        for(JsonElement rawTrimesterMarks : jsonObject.getAsJsonArray("marks")) {
            List<SubjectMarks> trimesterMarks = new ArrayList<>();
            for(JsonElement subjectMark : rawTrimesterMarks.getAsJsonObject().getAsJsonArray("marks")) {
                JsonObject object = subjectMark.getAsJsonObject();

                trimesterMarks.add(SubjectMarks.fromJSON(object));
            }
            allMarks.add(trimesterMarks);
        }
        return new OfflineSession(info, allMarks);
    }
}
