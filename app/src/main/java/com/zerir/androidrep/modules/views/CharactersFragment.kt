package com.zerir.androidrep.modules.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.zerir.androidrep.modules.repository.models.Character
import com.zerir.androidrep.modules.views.adapters.CharactersAdapter
import com.zerir.androidrep.R
import com.zerir.androidrep.modules.views.adapters.SetOnCharacterClickedListener
import com.zerir.androidrep.databinding.FragmentCharactersBinding
import com.zerir.androidrep.modules.repository.RepoManager

class CharactersFragment : Fragment(), SetOnCharacterClickedListener {

    private lateinit var binding: FragmentCharactersBinding

    private lateinit var listener: SetOnViewClicked
    private lateinit var adapter: CharactersAdapter

    private lateinit var list: LiveData<List<Character>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_characters, container, false)

        adapter = CharactersAdapter(this)
        binding.adapter = adapter

        list = RepoManager.getInstance().getAllCharacters()
        list.observe(this, {
            adapter.setCharacters(it)
        })

        binding.addBt.setOnClickListener {
            listener.onAddCharacterClicked()
        }

        return binding.root
    }

    override fun onCharacterClicked(character: Character) {
        listener.onCharacterClicked(character)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SetOnViewClicked) {
            listener = context
        } else {
            throw ClassCastException("$context must implement PizzaMenuFragment.OnItemSelectedListener")
        }
    }

    interface SetOnViewClicked {
        fun onAddCharacterClicked()
        fun onCharacterClicked(character: Character)
    }
}