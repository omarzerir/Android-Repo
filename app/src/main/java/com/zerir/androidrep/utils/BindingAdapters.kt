package com.zerir.androidrep.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zerir.androidrep.modules.views.adapters.CharactersAdapter

@BindingAdapter("setupCharacters")
fun RecyclerView.setupCharacters(adapter: CharactersAdapter?){
    this.adapter = adapter
}