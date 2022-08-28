package com.example.dairynote.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dairynote.R
import com.example.dairynote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
// Создаем слушатель нажатий для нижнего меню навигации
    private fun setBottomNavlistener(){
        binding.bNav.setOnItemSelectedListener {
// Проверяем через "when" какая конкретно кнопка была нажата и даем ей действия
            when(it.itemId){
                R.id.settings ->{}
                R.id.notes ->{}
                R.id.shopp_list ->{}
                R.id.new_item ->{}
            }
            true
        }
    }
}