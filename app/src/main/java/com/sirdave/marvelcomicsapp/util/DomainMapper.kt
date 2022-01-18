package com.sirdave.marvelcomicsapp.util

interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel
}