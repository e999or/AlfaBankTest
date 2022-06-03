import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonReader {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("https://api.giphy.com/v1/gifs/random?api_key=9ekhBW8jmXb47DiBR65QvezW10qXlszE&tag=rich&rating=g");
        JSONObject data = json.getJSONObject("data");
        String idString = data.getString("id");
        String url = "https://i.giphy.com/" + idString + ".gif";
        System.out.println(url);
        SaveGif saveGif = new SaveGif(url);


    }
}
