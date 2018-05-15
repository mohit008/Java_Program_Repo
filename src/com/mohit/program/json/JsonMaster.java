package com.mohit.program.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class JsonMaster {

    private String name, city, house, year;
    private static String key = "http://mysafeinfo.com/api/data?list=englishmonarchs&format=json";

    public JsonMaster() {
        getJSONFromUrl(key);
    }

    /**
     * get url and input stream
     *
     * @param url
     * @return
     */
    public String getJSONFromUrl(String url) {

        String json_string = "";
        try {
            URL obj = new URL(url);
            HttpURLConnection http = (HttpURLConnection) obj.openConnection();
            http.setRequestMethod("GET");
            int response = http.getResponseCode();

            System.out.println(Integer.toString(response));

            BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
            json_string = sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        parseJson(json_string);
        return null;
    }

    /**
     * parse json data
     *
     * @param json
     */
    public void parseJson(String json) {

        JSONParser parse = new JSONParser();
        try {
            Object obj = parse.parse(json);
            JSONArray forecast = (JSONArray) obj;
            for (int i = 0; i < forecast.size(); i++) {
                JSONObject fore_detail = (JSONObject) forecast.get(i);
                name = (String) fore_detail.get("nm");
                city = (String) fore_detail.get("cty");
                house = (String) fore_detail.get("hse");
                year = (String) fore_detail.get("yrs");

                System.out.println(name + "\n"+ city + "\n"+ house + "\n"+ year + "\n");
            }

            /*Object obj = parse.parse(json);
            JSONObject root = (JSONObject) obj;
            JSONArray com = (JSONArray) root.get("companydetails");
            for (int i = 0; i < com.size(); i++) {
                JSONObject comp = (JSONObject) com.get(i);
                JSONArray category = (JSONArray) comp.get("category");
                for (int j = 0; j < category.size(); j++) {
                    JSONObject pro = (JSONObject) category.get(j);
                    JSONArray products = (JSONArray) pro.get("Products");
                    for (int z = 0; z < 1; z++) {
                        JSONObject a = (JSONObject) products.get(z);
                        System.out.println(a.get("Name"));
                    }
                }
            }*/
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
