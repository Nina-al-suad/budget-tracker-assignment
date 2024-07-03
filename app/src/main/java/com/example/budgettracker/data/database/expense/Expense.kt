package com.example.budgettracker.data.database.expense
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val text: String,
    val amount: Double,
    val date: String
)
