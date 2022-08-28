package com.example.dairynote.activities

import android.app.Application
import com.example.dairynote.database.MainDataBase

// Создаем класс и унаследуемся от освного класса приложения
// чтобы иметь доступ к базеданных всегда, даже если закрыто какое-то активити
class MainApp : Application() {
    // Делаем инициализацию
    // блок lazy нужен, когда база запустится в первый раз,
    // то он пойдет по коду lazy,
    // в след раз он уже не будет запускать код, потому что уже имеет эту инстанцию
    val database by lazy {MainDataBase.getDataBase(this) }
}
// нужно теперь указать в манифесте, что этот класс и есть наше приложение