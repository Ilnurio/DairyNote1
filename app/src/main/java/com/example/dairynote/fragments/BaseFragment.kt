package com.example.dairynote.fragments

import androidx.fragment.app.Fragment

/* Создаем базовый класс фрагмент, для того,
чтобы добавлять новые списки покупок или лист блокнота*/

abstract class BaseFragment : Fragment() {
    abstract fun omClickNew()
}