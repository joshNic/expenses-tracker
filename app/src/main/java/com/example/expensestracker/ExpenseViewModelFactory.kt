package com.example.expensestracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expensestracker.model.db.ExpensesRepository

class ExpenseViewModelFactory(private val repository: ExpensesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExpenseViewModel::class.java)){
            return ExpenseViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown View Model Class")
    }
}