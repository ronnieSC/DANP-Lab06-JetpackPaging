package com.plcoding.composepagingyt

import kotlinx.coroutines.delay

class Repository {

    private val remoteDataSource = (1..200).map {
        ListItem(
            title = "Gimnasio Nr: $it",
            description = "Este gimnasio nr $it tiene las mejores ......",
            atention = "Horario de Atencion: de lunes a sabado 6am-8pm",
        )
    }

    suspend fun getItems(page: Int, pageSize: Int): Result<List<ListItem>> {
        delay(2000L)
        val startingIndex = page * pageSize
        return if(startingIndex + pageSize <= remoteDataSource.size) {
            Result.success(
                remoteDataSource.slice(startingIndex until startingIndex + pageSize)
            )
        } else Result.success(emptyList())
    }
}