package com.example.dairynote.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Этот энтити создаем для хранения заметок-блокнота

@Entity(tableName = "note_list")
data class NoteItem(
  @PrimaryKey(autoGenerate = true)
  val id:Int?,
  // Колонна для хранения заголовков
  @ColumnInfo(name = "title")
  val title: String,
  // Колона для хранения описания заметки
  @ColumnInfo(name = "content")
  val content: String,
  // Колонна для сохранения времени создания заметки
  @ColumnInfo(name = "time")
  val time: String,
  // Колонна для сохранения категории заметок
  @ColumnInfo(name = "category")
  val category: String
)
