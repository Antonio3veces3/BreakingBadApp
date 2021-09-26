package com.dcom.breakingbadapp.models

class Character(
    val char_id: Int,
    val name: String,
    val birthday: String,
    val occupation: Array<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val portrayed: String
){}