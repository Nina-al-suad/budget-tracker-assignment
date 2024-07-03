package com.example.budgettracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.budgettracker.R
import com.example.budgettracker.data.database.expense.Expense

class ExpenseAdapter(
    private var expenses: List<Expense>,
    private val onDeleteClick: (Expense) -> Unit
) : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenses[position]
        holder.bind(expense)
        holder.deleteIcon.setOnClickListener {
            onDeleteClick(expense)
        }
    }

    override fun getItemCount(): Int = expenses.size

    fun updateExpenses(newExpenses: List<Expense>) {
        expenses = newExpenses
        notifyDataSetChanged()
    }

    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val expenseText: TextView = itemView.findViewById(R.id.expense_text)
        private val expenseAmount: TextView = itemView.findViewById(R.id.expense_amount)
        private val expenseDate: TextView = itemView.findViewById(R.id.expense_date)
        val deleteIcon: ImageView = itemView.findViewById(R.id.delete_expense)

        fun bind(expense: Expense) {
            expenseText.text = expense.text
            expenseAmount.text = expense.amount.toString()
            expenseDate.text = expense.date
        }
    }
}
