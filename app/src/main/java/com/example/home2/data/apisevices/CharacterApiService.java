package com.example.home2.data.apisevices;

import com.example.home2.model.RickAndMortyCharacter;
import com.example.home2.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterApiService {
    @GET("api/character")
    Call<RickAndMortyResponse<RickAndMortyCharacter>> fetchCharacters(
    );
}
