package com.example.budgettracker

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.example.budgettracker.data.database.expense.Expense
import com.example.budgettracker.data.database.expense.ExpenseDatabase
import java.util.*

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var expenseText: EditText
    private lateinit var expenseAmount: EditText
    private lateinit var expenseDate: EditText
    private lateinit var db: ExpenseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        expenseText = findViewById(R.id.expense_title)
        expenseAmount = findViewById(R.id.expense_amount)
        expenseDate = findViewById(R.id.expense_date)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        expenseDate.setOnClickListener {
            showDatePickerDialog()
        }

        findViewById<Button>(R.id.save_expense_button).setOnClickListener {
            saveExpense()
        }

        db = Room.databaseBuilder(
            applicationContext,
            ExpenseDatabase::class.java, "expense-database"
        ).build()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                expenseDate.setText(date)
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    private fun saveExpense() {
        val text = expenseText.text.toString()
        val amount = expenseAmount.text.toString().toDoubleOrNull()
        val date = expenseDate.text.toString()

        if (text.isBlank() || amount == null || date.isBlank()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val expense = Expense(0, text, amount, date)
        Thread {
            db.expenseDao().insert(expense)
            runOnUiThread {
                Toast.makeText(this, "Expense saved", Toast.LENGTH_SHORT).show()
                finish()
            }
        }.start()
    }
}
