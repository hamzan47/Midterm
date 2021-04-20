package com.example.a2018134_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = findViewById(R.id.textView);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/posts/%22)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

        tweets service = retrofit.create(tweets.class);


        Call<List<tweet>> call = service.tweets();
//        Call<UsersResponse>
        call.enqueue(new Callback<List<tweet>>() {
            @Override
            public void onResponse(Call<List<tweet>> call, Response<List<tweet>> response) {

                textView.setText(response.body().get(0).getTitle().toString());


            }

            @Override
            public void onFailure(Call<List<tweet>> call, Throwable t) {
//

                Log.e("", t.getLocalizedMessage());
            }
        });
}