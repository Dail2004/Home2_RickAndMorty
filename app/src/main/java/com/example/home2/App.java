package com.example.home2;

import android.app.Application;

import com.example.home2.data.apisevices.CharacterApiService;
import com.example.home2.data.network.RetrofitClient;

public class App extends Application {

    public static CharacterApiService characterApiService;


    @Override
    public void onCreate() {
        super.onCreate();

        characterApiService = new RetrofitClient().provideCharacterApiService();
    }
}
