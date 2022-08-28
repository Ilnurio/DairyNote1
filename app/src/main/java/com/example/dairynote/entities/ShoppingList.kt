package com.example.dairynote.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// Entity - таблицы, чтобы записывать в них данные для нашего шоппинг листа
// Данная модель(Entity) будет отвечать за название списков покупок(еда на субботу и воскресный ужин и т.д.)
@Entity(tableName = "shopping_list_names")
data class ShoppingList(
    // Это нужно чтобы нумеровать(индекатор) элементы в базе данных автоматически
    // Данная колонна обязательно, так можно создавать таблицы всегда
    @PrimaryKey (autoGenerate = true)
    val id: Int?,
    // Далее говорим room library, какие переменные мы хотим еще добавить в шрппинг лист
    // Создаем колонну,будем записывать сюда данные типа String
    @ColumnInfo(name = "name")
    val name: String,
// Чтобы создать еще колонну с данными, также делаем через ColumnInfo
// Добавим таким же образом время создания списка в шоппинг листе
    @ColumnInfo(name = "time")
    val time: String,
// Добавляем колонку с общим количеством покупок
    @ColumnInfo(name = "allItemCount")
    val allItemCounter: Int,
// Создаем колонну с покупками, которые уже купили из списка
    @ColumnInfo(name = "checkedItemsCounter")
    val checkedItemsCounter: Int,
//  Добавляем колонну для хранения идентификаторов всех элементов, чтобы их не потерять
    @ColumnInfo(name = "itemsIds")
    val itemsIds: String,
    // Будем передавать этот класс из одного активити в другой, для этого
    // нужно сдедать этот класс Serializable
    ): Serializable


