package com.example.home2.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.home2.databinding.ItemCharactersBinding;
import com.example.home2.model.RickAndMortyCharacter;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private ArrayList<RickAndMortyCharacter> list = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(ItemCharactersBinding.inflate(LayoutInflater
                        .from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void submitList(ArrayList<RickAndMortyCharacter> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {

        private ItemCharactersBinding binding;

        public CharacterViewHolder(@NonNull ItemCharactersBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(view -> {
                listener.onItemClick(getAdapterPosition());
            });
        }

        public void onBind(RickAndMortyCharacter item) {
            Glide.with(binding.imageCharacters)
                    .load(item.getImage())
                    .into(binding.imageCharacters);
            binding.textCharacters.setText(item.getName());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
