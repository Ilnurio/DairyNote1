package com.example.dairynote.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dairynote.entities.NoteItem
import kotlinx.coroutines.flow.Flow

// Данный класс мы создаем для записи и считывания базы данных
@Dao
interface DataAccessObject {
    // Создаем аннотацию для чтения данных с базы
    @Query("SELECT * FROM note_list")
    // Функция что мы будем получать, т.е. все заметки без фильтрации
    // Flow специальный класс в корутинах, который будет подключать базу данных и обновлять ее
    // и он нам выдает список List с нашими заметками
    fun getAllNotes(): Flow<List<NoteItem>>
    // Создаем аннотацию и функцию для записи данных
    @Insert
    suspend fun insertNote(note: NoteItem)
}

// Чтобы получить доступ к этому интерфейсу нужно его прописать в MainDataBase