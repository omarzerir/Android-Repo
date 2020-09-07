package com.zerir.androidrep.modules.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zerir.androidrep.modules.repository.models.Character
import com.zerir.androidrep.modules.repository.models.GenerateCharacter
import com.zerir.androidrep.R
import com.zerir.androidrep.databinding.FragmentCharacterDetailsBinding

class CharacterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailsBinding

    private lateinit var listener: SetOnGenerateClickListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_character_details, container, false)

        if(savedInstanceState == null) {
            val character = arguments?.getSerializable("character") as Character?
            character?.let {
                binding.character = it
            }
        }

        binding.generateCharBt.setOnClickListener {
            val char = GenerateCharacter().generateChar(
                name = binding.nameEt.text.toString(),
                round1 = binding.round1Et.text.toString().toInt(),
                round2 = binding.round2Et.text.toString().toInt(),
                round3 = binding.round3Et.text.toString().toInt()
            )
            listener.onGenerateClicked(char)
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SetOnGenerateClickListener) {
            listener = context
        } else {
            throw ClassCastException("$context must implement PizzaMenuFragment.OnItemSelectedListener")
        }
    }

    interface SetOnGenerateClickListener{
        fun onGenerateClicked(character: Character)
    }
}