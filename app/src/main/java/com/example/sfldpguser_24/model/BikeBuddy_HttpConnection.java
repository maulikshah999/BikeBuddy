package com.example.sfldpguser_24.model;

/**
 * Created by SFLDPGUSER-24 on 3/2/2018.
 */
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BikeBuddy_HttpConnection {

    OkHttpClient client = new OkHttpClient();
    String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public static void main(String[] args) throws IOException {
        BikeBuddy_HttpConnection example = new BikeBuddy_HttpConnection();
        String response = example.doGetRequest("https://raw.github.com/square/okhttp/master/README.md");
        System.out.println(response);
    }
}


