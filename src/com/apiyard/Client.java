package com.apiyard;
/*
 * A main client for testing purpose.
 */

import com.fasterxml.jackson.databind.ObjectMapper; // 3rd party library
import com.google.gson.Gson; // 3rd party library

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

class Client {
    public static void main(String[] args) throws InterruptedException {
        // API Endpoint url
        String urlString = "https://jsonplaceholder.typicode.com/posts/";

        Gson gson = new Gson();

        String jsonStr;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            jsonStr = response.body();

            // convert JSON array to Array objects
            // It's advised to use ObjectMapper as a singleton and reuse the instance, map JSON data to Post class.
            final ObjectMapper objectMapper = new ObjectMapper();
            Post[] posts = objectMapper.readValue(jsonStr, Post[].class);

            // put json into an arrayList
            //ArrayList<?> list = new ArrayList<>(Arrays.asList(posts));
            // print out all the posts in list
            // list.forEach( x -> System.out.println(x.toString()));

            /**
             * At his point we could access to post ID, user ID, title and body of the message.
             * we can do something with those data. preferable If we could use stream and lambda to maneuver the data set.
             */
            for (Post p : posts) {
                if (p.getId() == 1 && p.getId() != 0) {
                    System.out.println(p);
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}