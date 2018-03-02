package com.example.sfldpguser_24.model;

/**
 * Created by SFLDPGUSER-24 on 3/2/2018.
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BikeBuddyImplOkHttp {
    private static final String URI_BIKES = "http://10.5.5.12:8080/test";

    public Bikes[] getAllBikes() throws Exception {
        Bikes[] bikesList = null;
        OkHttpClient httpclient = new OkHttpClient();
        Request request = new Request.Builder().url(URI_BIKES).get().build();
        try (Response response = httpclient.newCall(request).execute()) {
            ObjectMapper mapper = new ObjectMapper();
            bikesList = mapper.readValue(response.body().bytes(), Bikes[].class);
        }
        return bikesList;
    }
    public static void main(String[] args) throws IOException {
        BikeBuddyImplOkHttp example = new BikeBuddyImplOkHttp();
        try {
          Bikes[] bikesList = example.getAllBikes();
            System.out.println(bikesList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}


