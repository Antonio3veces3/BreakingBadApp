package com.dcom.breakingbadapp.activities.detailScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.dcom.breakingbadapp.R
import com.dcom.breakingbadapp.databinding.ActivityDetailBinding
import com.dcom.breakingbadapp.fragments.characters
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

            val occupationUnion = character?.occupation?.joinToString(" \n ").toString()

            binding.nameDetail.text = character?.name
            binding.nicknameDetail.text = character?.nickname
            binding.statusDetail.text = character?.status
            binding.birthday.text = character?.birthday
            binding.occupationDetail.text = occupationUnion
            binding.portrayedDetail.text = character?.portrayed

            Glide
                .with(binding.root)
                .load(character?.img)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.profileImage)

            when(character?.status){
                "Alive" ->{
                    Glide
                        .with(binding.root)
                        .load(R.drawable.detail_ic_alive)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .centerCrop()
                        .into(binding.statusIconDetail)
                }
                "Deceased" ->{
                    Glide
                        .with(binding.root)
                        .load(R.drawable.detail_ic_death)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .centerCrop()
                        .into(binding.statusIconDetail)
                }
                else->{
                    Glide
                        .with(binding.root)
                        .load(R.drawable.detail_ic_unknown)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .centerCrop()
                        .into(binding.statusIconDetail)
                }
            }


        }

    }
}