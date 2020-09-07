package com.zerir.androidrep.modules.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zerir.androidrep.modules.repository.models.Character
import com.zerir.androidrep.databinding.RowCharacterItemBinding

class CharactersAdapter(private val listener: SetOnCharacterClickedListener) :
    ListAdapter<Character, CharactersAdapter.ViewHolder>(CharactersDiffUtils()) {

    fun setCharacters(list: List<Character>){
        submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowCharacterItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val char = getItem(position)
        holder.bind(char, listener)
    }
    class ViewHolder(private val binding: RowCharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character, listener: SetOnCharacterClickedListener){
            binding.character = character
            binding.listener = listener
        }
    }
}

class CharactersDiffUtils : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.name == newItem.name && oldItem.score == newItem.score
    }
}

interface SetOnCharacterClickedListener {
    fun onCharacterClicked(character: Character)
}