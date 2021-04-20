package com.example.a2018134_midterm;

public interface tweets {
    import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

    public interface TweetAPI {

        @GET("/")
        Call<List<Tweet>> getTweets(
}
