package com.example.budgettracker


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.budgettracker.adapter.ExpenseAdapter
import com.example.budgettracker.data.database.expense.Expense
import com.example.budgettracker.data.database.expense.ExpenseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



//expense activity class
class ExpensesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExpenseAdapter
    private lateinit var db: ExpenseDatabase
    private lateinit var noRecordsText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        noRecordsText = findViewById(R.id.no_records_text)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ExpenseAdapter(emptyList(), ::deleteExpense)
        recyclerView.adapter = adapter

        db = ExpenseDatabase.getDatabase(this)

        loadExpenses()
    }


    //function to fetch/load the expenses

    private fun loadExpenses() {
        CoroutineScope(Dispatchers.IO).launch {
            val expenses = db.expenseDao().getAll()
            withContext(Dispatchers.Main) {
                if (expenses.isEmpty()) {
                    noRecordsText.visibility = View.VISIBLE
                } else {
                    noRecordsText.visibility = View.GONE
                    adapter.updateExpenses(expenses)
                }
            }
        }
    }

    //function to delete an expense

    private fun deleteExpense(expense: Expense) {
        CoroutineScope(Dispatchers.IO).launch {
            db.expenseDao().delete(expense)
            loadExpenses()  // Reload expenses after deletion
        }
    }
}
