package com.deniscerri.ytdl.database.repository

import com.deniscerri.ytdl.database.dao.CookieDao
import com.deniscerri.ytdl.database.models.CookieItem
import kotlinx.coroutines.flow.Flow

class CookieRepository(private val cookieDao: CookieDao) {
    val items : Flow<List<CookieItem>> = cookieDao.getAllCookiesFlow()

    fun getAll() : List<CookieItem> {
        return cookieDao.getAllCookies()
    }

    fun getByURL(url: String) : CookieItem? {
        return cookieDao.getByURL(url)
    }

    suspend fun insert(item: CookieItem) : Long {
        return cookieDao.insert(item)
    }

    suspend fun delete(item: CookieItem){
        cookieDao.delete(item.id)
    }


    suspend fun deleteAll(){
        cookieDao.deleteAll()
    }

    suspend fun update(item: CookieItem){
        cookieDao.update(item)
    }

}