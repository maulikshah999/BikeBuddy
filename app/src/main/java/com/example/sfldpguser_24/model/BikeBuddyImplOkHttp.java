package com.example.sfldpguser_24.model;

/**
 * Created by SFLDPGUSER-24 on 3/2/2018.
 */

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BikeBuddyImplOkHttp {
    private static final String URI_BIKESDropOff = "http://10.0.1.60:8080/getLocations?type=dropOff&latitude=40.7143528&longitude=-74.00597309999999";
    private static final String URI_BIKESPickOff = "http://10.0.1.60:8080/getLocations?type=pickOff&latitude=40.7143528&longitude=-74.00597309999999";

    public List<Bikes> getPickUp() throws Exception {
        List<Bikes> result = null;
        OkHttpClient httpclient = new OkHttpClient();
        Request request = new Request.Builder().url(URI_BIKESPickOff).get().build();
        try (Response response = httpclient.newCall(request).execute()) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Bikes>>(){});
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            result = objectReader.readValue(response.body().bytes());
            String json = objectMapper.writeValueAsString(result);
            System.out.println(json);
        }
        return result;
    }

    public List<Bikes> getDropOff() throws Exception {
        List<Bikes> result = null;
        OkHttpClient httpclient = new OkHttpClient();
        Request request = new Request.Builder().url(URI_BIKESDropOff).get().build();
        try (Response response = httpclient.newCall(request).execute()) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Bikes>>(){});
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            result = objectReader.readValue(response.body().bytes());
            String json = objectMapper.writeValueAsString(result);
            System.out.println(json);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BikeBuddyImplOkHttp example = new BikeBuddyImplOkHttp();
        try {
            List<Bikes> bikesList = example.getDropOff();
            for(Bikes bike : bikesList){
             System.out.println(bike.nameOfStation());
          }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


