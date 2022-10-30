import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class movies {

    public static final String DATA_URL = "https://jsonmock.hackerrank.com/api/moviesdata/search/?Title=";

    public static void main(String[] args) {
        String filmNameSubStr = getFilmNameSubStr();
        List<String> moviesNames = getMoviesNames(filmNameSubStr);
        System.out.println("There are " + moviesNames.size() + " records");
        moviesNames.stream().sorted().forEach(System.out::println);
    }

    private static String getFilmNameSubStr() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter part of film name >>> ");
        return sc.next();
    }

    private static List<String> getMoviesNames(String filmNameSubStr) {
        List moviesNamesList = new ArrayList();
        MovieDataResponse dataForMoviesObj = new MovieDataResponse();
        int i = 1;
        while (dataForMoviesObj.page < dataForMoviesObj.totalPages) {
            dataForMoviesObj = getDataForMovies(filmNameSubStr, i);
            moviesNamesList.addAll(dataForMoviesObj.data);
            i++;
        }
        return moviesNamesList;
    }

    private static MovieDataResponse getDataForMovies(String filmNameSubStr, int page) {
        MovieDataResponse movieDataResponse = new MovieDataResponse();
        try {
            JSONObject jsonObject = readJsonFromUrl(DATA_URL + filmNameSubStr + "&page=" + page);
            movieDataResponse.populateFromJson(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieDataResponse;
    }

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

    private static class MovieDataResponse {
        int total= 0;
        int page = 0;
        int totalPages = 1;
        List<String> data = new ArrayList<>();

        public void populateFromJson(JSONObject jsonObject) {
            try {
                totalPages = jsonObject.getInt("total_pages");
                total = jsonObject.getInt("total");
                page = jsonObject.getInt("page");
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                int length = jsonArray.length();
                for (int i = 0; i < length; i++) {
                    data.add(jsonArray.getJSONObject(i).getString("Title"));
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }
}

