package com.sirdave.marvelcomicsapp.network.model

import com.sirdave.marvelcomicsapp.db.entity.Favourite
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

    fun mapFavouriteToCharacter(model: Favourite): Character {
        return Character(
            id = model.id,
            name = model.name,
            description = model.description,
            modified = model.modified,
            featuredImage = model.featuredImage
        )
    }

    fun mapCharacterToFavourite(model: Character): Favourite {
        return Favourite(
            id = model.id,
            name = model.name,
            description = model.description,
            modified = model.modified,
            featuredImage = model.featuredImage
        )
    }

    fun toDomainList(inital: List<CharacterDto>): List<Character>{
        return inital.map { mapToDomainModel(it) }
    }

    fun toCharacterList(inital: List<Favourite>): List<Character>{
        return inital.map { mapFavouriteToCharacter(it) }
    }

    private fun generateImageUrl(thumbnail: Thumbnail?): String{
        //string concatenation of path and extension
        return "${thumbnail?.path}.${thumbnail?.extension}"
    }
}