package com.dcom.breakingbadapp.activities.detailScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dcom.breakingbadapp.R
import com.dcom.breakingbadapp.databinding.ActivityDetailBinding
import com.dcom.breakingbadapp.fragments.characters
import com.dcom.breakingbadapp.models.Character
import java.util.zip.Inflater

class DetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

    }

}