package com.example.home2.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.home2.data.base.BaseFragment;
import com.example.home2.databinding.FragmentCaractersBinding;
import com.example.home2.ui.adapter.CharacterAdapter;

public class CharactersFragment extends BaseFragment<CharacterViewModel, FragmentCaractersBinding> {

    private final CharacterAdapter characterAdapter = new CharacterAdapter();
    private CharacterViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCaractersBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupRequests();
    }

    protected void initialize() {
        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);

        setupCharactersRecycler();
    }

    private void setupCharactersRecycler() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(characterAdapter);
    }

    protected void setupRequests() {
        viewModel.fetchCharacters().observe(getViewLifecycleOwner(), character -> {
            characterAdapter.submitList(character);
        });
    }
}