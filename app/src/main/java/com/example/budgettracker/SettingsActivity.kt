package com.example.budgettracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.budgettracker.R

/*
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.budgettracker.R
import com.example.budgettracker.data.database.expense.ExpenseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class com.example.budgettracker.SettingsActivity : AppCompatActivity() {

    private lateinit var editTextMonthlyBudget: EditText
    private lateinit var spinnerCurrency: Spinner
    private lateinit var switchNotification: Switch
    private lateinit var saveSettingsButton: Button

    private lateinit var db: ExpenseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        editTextMonthlyBudget = findViewById(R.id.edit_text_monthly_budget)
        spinnerCurrency = findViewById(R.id.spinner_currency)
        switchNotification = findViewById(R.id.switch_notification)
        saveSettingsButton = findViewById(R.id.save_settings_button)

        db = ExpenseDatabase.getDatabase(this)

        saveSettingsButton.setOnClickListener {
            saveSettings()
        }

        loadSettings()
    }

    private fun loadSettings() {
        lifecycleScope.launch(Dispatchers.IO) {
            val settings = db.settingsDao().getSettings()

            withContext(Dispatchers.Main) {
                if (settings != null) {
                    editTextMonthlyBudget.setText(settings.monthlyBudget.toString())
                    spinnerCurrency.setSelection(getCurrencyIndex(settings.currency))
                    switchNotification.isChecked = settings.showNotifications
                }
            }
        }
    }

    private fun saveSettings() {
        val monthlyBudget = editTextMonthlyBudget.text.toString().toDoubleOrNull() ?: 0.0
        val currency = spinnerCurrency.selectedItem.toString()
        val showNotifications = switchNotification.isChecked

        val settings = Settings(1, monthlyBudget, currency, showNotifications)

        lifecycleScope.launch(Dispatchers.IO) {
            db.settingsDao().insertOrUpdate(settings)
        }
    }

    private fun getCurrencyIndex(currency: String): Int {
        val currencies = resources.getStringArray(R.array.currencies)
        return currencies.indexOf(currency)
    }
}
*/

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

}
