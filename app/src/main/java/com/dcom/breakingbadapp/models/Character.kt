package com.dcom.breakingbadapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

class Character(
    val char_id: Int,
    val name: String,
    val birthday: String,
    val occupation: Array<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val portrayed: String
) : Parcelable {}