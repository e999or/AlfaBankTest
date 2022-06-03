import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {
        JsonReader indexReader = new JsonReader();
        JSONObject jsonIndex = indexReader.readJsonFromUrl("https://openexchangerates.org/api/latest.json?app_id=f2aa75f4b0f04ad9bcb2157a8e5fbd98");
        JSONObject rates = jsonIndex.getJSONObject("rates");
        String usdIndex = rates.getString("RUB");
        System.out.println(usdIndex);

        JsonReader pastIndexReader = new JsonReader();
        String dateLater = Clock.date();
        JSONObject pastJsonIndex = pastIndexReader.readJsonFromUrl("https://openexchangerates.org/api/historical/" + dateLater + ".json?app_id=f2aa75f4b0f04ad9bcb2157a8e5fbd98");
        JSONObject pastRates = pastJsonIndex.getJSONObject("rates");
        String pastUsdIndex = pastRates.getString("RUB");
        System.out.println(pastUsdIndex);


//        JsonReader GifReader = new JsonReader();
//        JSONObject json = GifReader.readJsonFromUrl("https://api.giphy.com/v1/gifs/random?api_key=9ekhBW8jmXb47DiBR65QvezW10qXlszE&tag=rich&rating=g");
//        JSONObject data = json.getJSONObject("data");
//        String idString = data.getString("id");
//        String url = "https://i.giphy.com/" + idString + ".gif";
//        SaveGif saveGif = new SaveGif(url);



    }
}
