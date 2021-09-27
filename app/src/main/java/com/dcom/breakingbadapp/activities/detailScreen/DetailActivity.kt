package com.dcom.breakingbadapp.activities.detailScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dcom.breakingbadapp.R
import com.dcom.breakingbadapp.databinding.ActivityDetailBinding
import com.dcom.breakingbadapp.models.Character

class DetailActivity : AppCompatActivity() {

    companion object {
        const val CHARACTER_KEY = "character_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        val bundle: Bundle? = intent.extras

        if(bundle!=null){
            val character = bundle.getParcelable<Character>(CHARACTER_KEY)
            binding.nameDetail.text = character?.name.toString()
            binding.nicknameDetail.text = character?.nickname.toString()

        }

    }
}