package com.example.dairynote.fragments

import androidx.appcompat.app.AppCompatActivity
import com.example.dairynote.R

/* Создаем объект, чтобы можно было использовать
функцию без инициализации класса.
Переменная CurrentFrag нужна для понимания какой
фрагмент находится в активити на данный момент,
и каждый раз его перезаписывать при переключении фрагментов*/

object FragmentManager {
    var currentFrag: BaseFragment? = null

    /*Создаем функцию, чтобы можно было переключаться
    между фрагментами.
    В скобках функции передаем базовый фргамент, так как все фрагменты будут
    унаследоваться от базового фрагмента, и передаем активити, на которое все фрагменты
    и будут выводиться.
    */
    fun setFragment(newFrag: BaseFragment, activity: AppCompatActivity) {
/* Далее создаем функции для переключения фрагментов.
С помощью transaction можно удалять/заменять фрагменты местами*/
        val transaction = activity.supportFragmentManager.beginTransaction()
        /* Указываем место placeHolder, которое нужно заменить, на новый
        фрагмент, который хотим открыть newFrag
        */
        transaction.replace(R.id.placeHolder, newFrag)
        /*Далее применяем метод, чтобы запустить все то, что
        до этого тут прописали*/
        transaction.commit()
        /*Далее нужно указать, что CurrentFragment(изначально null)
        это и есть NewFrag*/
        currentFrag = newFrag
    }
}