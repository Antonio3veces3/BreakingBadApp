package com.dcom.breakingbadapp.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dcom.breakingbadapp.R
import com.dcom.breakingbadapp.activities.detailScreen.DetailActivity
import com.dcom.breakingbadapp.fragments.adapters.viewPagersAdapter
import com.dcom.breakingbadapp.fragments.characters
import com.dcom.breakingbadapp.fragments.phrases
import com.dcom.breakingbadapp.fragments.settings
import com.dcom.breakingbadapp.models.Character
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), characters.CharacterSelectListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTabs()
    }

    override fun onCharacterSelected(character: Character){
        val intent= Intent(this, DetailActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setUpTabs(){
        val adapter = viewPagersAdapter(supportFragmentManager)
        adapter.addFragment(characters(), "Characters")
        adapter.addFragment(phrases(), "Phrases")
        adapter.addFragment(settings(), "Settings")
        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.bar_ic_character)
        tabs.getTabAt(1)!!.setIcon(R.drawable.bar_ic_phrase)
        tabs.getTabAt(2)!!.setIcon(R.drawable.settings_ic_settings)
    }
}