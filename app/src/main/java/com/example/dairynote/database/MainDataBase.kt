package com.example.dairynote.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dairynote.entities.LibraryItem
import com.example.dairynote.entities.NoteItem
import com.example.dairynote.entities.ShoppingList
import com.example.dairynote.entities.ShoppingListItem


// Создаем класс для создания базы данных и для доступа к базе данных
// Класс наследуется от бибилиотеки RoomDataBase
// Класс должен быть абстрактным
@Database(entities = [LibraryItem::class, NoteItem::class,
    ShoppingList::class, ShoppingListItem::class], version = 1)
abstract class MainDataBase : RoomDatabase() {
    // Данная функция возвращает интерфейс Dao
    abstract fun getDao(): DataAccessObject
    // Companion object дает быстрее инициализировать функцию
    // volatile (в Kotline в виде аннотации @volatile), которые применяются к полям и гарантируют,
    // что считываемое значение поступает из основной памяти, а не из кэша процессора,
    // поэтому все участники процесса будут ожидать окончания параллельной записи, прежде чем считать значение.
    companion object{
        @Volatile
        //Создаем инстанцию базы данных, чтобы потом обращаться к базеданных
        //volatile действует на переменную, все что мы будем записывать в переменную
        // Instance мгновенно становиться доступно для остальных потоков
        private var INSTANCE: MainDataBase? = null
        // Создаем функцию getdataBase, в нее мы будем передвать
        // Context и функция будет нам возвращать БазуДанных(класс)
        fun getDataBase(context: Context): MainDataBase{
            // опертаор Элвиса ?: означает, что если слева находится null,
            // то выдать то, что справа
            // Synchronized используется для того, чтобы обеспечить выполнение кода,
            // если несколько потоков пытаются его запустить одновремеено один раз.
            // то есть будет идти работа по одному потоку, другие будут блокироваться.
            // Блокируем этим же классом т.е. this
            return INSTANCE ?: synchronized(this){
                // создаем временную переменную, в которой создаем базу данных
                // т.е. если база не создана, то она создается
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "shopping_list.database"
                ).build()
                instance
            }
        }
    }
}