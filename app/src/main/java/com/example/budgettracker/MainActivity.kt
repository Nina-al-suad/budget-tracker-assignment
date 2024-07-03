package com.example.budgettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen



// application initialization class
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        findViewById<AppCompatImageButton>(R.id.add_expense_button).setOnClickListener {
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }

        findViewById<AppCompatImageButton>(R.id.view_expenses_button).setOnClickListener {
            startActivity(Intent(this, ExpensesActivity::class.java))
        }

        findViewById<AppCompatImageButton>(R.id.settings_button).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}


