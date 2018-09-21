package com.testjackson;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.testjackson.googleimage.ImageSearchResponse;
import org.json.JSONObject;
import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by bod on 1/31/2015.
 */
public class GoogleImageSearch {
    public static void main(String[] strings) {
        printResponse();
        convertToJava();
    }

    static void printResponse() {
        try {
            URL url = new URL("https://ajax.googleapis.com/ajax/services/search/images?" +
                    "v=1.0&q=barack%20obama&userip=INSERT-USER-IP");
            URLConnection connection = url.openConnection();

            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONObject json = new JSONObject(builder.toString());
            System.out.println(json.toString(4));

        } catch (Exception e) {

        }
    }

    static void convertToJava() {

        ImageSearchResponse response;
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            String query = "barack obama";

            String urlStr = "https://ajax.googleapis.com/ajax/services/search/images?" +
                    "v=1.0&rsz=8&q=" + URLEncoder.encode(query, "UTF-8");
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response =  mapper.readValue(reader, ImageSearchResponse.class);

            System.out.println(response.getResponseData().getResults().size());
        } catch (JsonGenerationException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
