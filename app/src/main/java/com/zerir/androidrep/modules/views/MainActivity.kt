package com.zerir.androidrep.modules.views

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.zerir.androidrep.modules.repository.models.Character
import com.zerir.androidrep.R
import com.zerir.androidrep.modules.repository.RepoManager

class MainActivity : AppCompatActivity(), CharactersFragment.SetOnViewClicked,
    CharacterDetailsFragment.SetOnGenerateClickListener {

    private val charactersFragment = CharactersFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
            .add(R.id.fContainer, charactersFragment)
            .commit()
        }
    }

    override fun onAddCharacterClicked() {
        val characterDetailsFragment = CharacterDetailsFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fContainer, characterDetailsFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onCharacterClicked(character: Character) {
        val characterDetailsFragment = CharacterDetailsFragment()
        val args = Bundle()
        args.putSerializable("character", character)
        characterDetailsFragment.arguments = args
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fContainer, characterDetailsFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onGenerateClicked(character: Character) {
        onBackPressed()
        RepoManager.getInstance().addCharacter(character)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.removeAll) RepoManager.getInstance().removeAllCharacters()
        return true
    }
}