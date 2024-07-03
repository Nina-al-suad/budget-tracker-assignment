package com.example.budgettracker.data.database.expense

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpenseDao {
    @Insert
    fun insert(expense: Expense)


    @Delete
    suspend fun delete(expense: Expense)

    @Query("SELECT * FROM expense")
    fun getAll(): List<Expense>
}
