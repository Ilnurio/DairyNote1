package com.example.dairynote.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// Данный энтити нужен для сохранения элементов внутри названия списка
@Entity(tableName = "shop_list_item")
data class ShoppingListItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "name_of_products")
    val name_of_products: String,
    // Колонная для доп.информации о продукте
    @ColumnInfo(name = "itemInfo")
    val itemInfo: String?,
    // Колонная для понимания что мы уже купили из списка, а что нет
    @ColumnInfo(name = "item_checked")
    val itemChecked: Int = 0,
    // Колонная для сохранения индекаторов списка продуктов
    @ColumnInfo(name = "listId")
    val listId: Int,
    // Колонная для сохранения покупок, которые мы ужке купили до этого(история покупок)
    @ColumnInfo(name = "itemType")
    val itemType: String = "item"
)
