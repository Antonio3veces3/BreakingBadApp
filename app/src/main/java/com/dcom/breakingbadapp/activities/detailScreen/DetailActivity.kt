package com.dcom.breakingbadapp.activities.detailScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dcom.breakingbadapp.R
import com.dcom.breakingbadapp.fragments.characters
import com.dcom.breakingbadapp.models.Character

class DetailActivity : AppCompatActivity(), characters.CharacterSelectListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
    override fun onCharacterSelected(character: Character){
    }
}