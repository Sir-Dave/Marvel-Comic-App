package com.sirdave.marvelcomicsapp.network.model

import com.sirdave.marvelcomicsapp.domain.model.Character
import com.sirdave.marvelcomicsapp.domain.model.Thumbnail
import com.sirdave.marvelcomicsapp.domain.util.DomainMapper

class CharacterDtoMapper: DomainMapper<CharacterDto, Character> {

    override fun mapToDomainModel(model: CharacterDto): Character {
        return Character(
            id = model.id,
            name = model.name,
            description = model.description,
            modified = model.modified,
            featuredImage = generateImageUrl(model.thumbnail))
    }

    private fun generateImageUrl(thumbnail: Thumbnail?): String{
        //string concatenation of path and extension
        return thumbnail?.path + thumbnail?.extension
    }

    fun toDomainList(inital: List<CharacterDto>): List<Character>{
        return inital.map { mapToDomainModel(it) }
    }
}