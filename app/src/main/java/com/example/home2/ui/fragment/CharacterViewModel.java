package com.example.home2.ui.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.home2.data.repositories.RickAndMortyRepository;
import com.example.home2.model.RickAndMortyCharacter;

import java.util.ArrayList;

public class CharacterViewModel extends ViewModel {

    private final RickAndMortyRepository repository = new RickAndMortyRepository();

    public MutableLiveData<ArrayList<RickAndMortyCharacter>> fetchCharacters() {
        return repository.fetchCharacters();
    }
}
