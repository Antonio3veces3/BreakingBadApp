package com.dcom.breakingbadapp.services

import com.dcom.breakingbadapp.api.Response
import com.dcom.breakingbadapp.api.api
import com.dcom.breakingbadapp.models.Character
import retrofit2.http.GET

interface CharacterService {

    @GET("characters/")
    suspend fun getCharacters(): Response


}

var characterService: CharacterService = api.create<CharacterService>(CharacterService::class.java)