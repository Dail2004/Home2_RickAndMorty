package com.example.home2.data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.home2.App;
import com.example.home2.model.RickAndMortyCharacter;
import com.example.home2.model.RickAndMortyResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RickAndMortyRepository {
    public MutableLiveData<ArrayList<RickAndMortyCharacter>> fetchCharacters() {

        MutableLiveData<ArrayList<RickAndMortyCharacter>> data = new MutableLiveData<>();
        App.characterApiService.fetchCharacters().enqueue(new Callback<RickAndMortyResponse<RickAndMortyCharacter>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<RickAndMortyCharacter>> call, Response<RickAndMortyResponse<RickAndMortyCharacter>> response) {
                ArrayList<RickAndMortyCharacter> character = response.body().getResult();
                data.setValue(character);
            }

            @Override
            public void onFailure(@NonNull Call<RickAndMortyResponse<RickAndMortyCharacter>> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
