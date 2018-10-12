package com.example.sfldpguser_28.model;

/**
 * Created by SFLDPGUSER-28 on 10/12/2018.
 */

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BikeBuddyImplOkHttp {
    private static final String URI_BIKES = "http://10.0.1.60:8080/getLocations?type=pickOff&latitude=40.7143528&longitude=-74.00597309999999";

    public List<Bikes> getAllBikes() throws Exception {
        List<Bikes> result = null;
        OkHttpClient httpclient = new OkHttpClient();
        Request request = new Request.Builder().url(URI_BIKES).get().build();
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
            List<Bikes> bikesList = example.getAllBikes();
            for(Bikes bike : bikesList){
             System.out.println(bike.nameOfStation());
          }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//
//
//
//}
//
//public class BikeBuddyImplOkHttp {
//    private static List<Bikes> bikes = new ArrayList<>();
//
//    public BikeBuddyImplOkHttp() {
//        bikes.add(new Bikes(1l));
//        bikes.add(new Bikes(2l));
//    }
//
//
//   // @RequestMapping(value = "/bikes", method = RequestMethod.GET)
//    public ResponseEntity<Iterable<Bikes>> getAllBooks() {
//        return new ResponseEntity<>(bikes, HttpStatus.OK);
//    }
}


