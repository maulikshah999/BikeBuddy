package com.example.sfldpguser_24.model;

/**
 * Created by SFLDPGUSER-24 on 3/2/2018.
 */

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BikeBuddyImplOkHttp {
    private static final String URI_BIKES = "http://10.5.5.12:8080/getLocations?type=pickOff&latitude=40.7143528&longitude=-74.00597309999999";

    public Bikes[] getAllBikes() throws Exception {
        Bikes[] bikes = null;
        OkHttpClient httpclient = new OkHttpClient();
        Request request = new Request.Builder().url(URI_BIKES).get().build();
        try (Response response = httpclient.newCall(request).execute()) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            bikes = mapper.readValue(response.body().bytes(), Bikes[].class);
        }
        return bikes;
    }
    public static void main(String[] args) throws IOException {
        BikeBuddyImplOkHttp example = new BikeBuddyImplOkHttp();
        try {
          Bikes[] bikesList = example.getAllBikes();
            System.out.println("Length"+bikesList.length);
            for(Bikes bike : bikesList){
              System.out.println(bike.toString());
          }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}


