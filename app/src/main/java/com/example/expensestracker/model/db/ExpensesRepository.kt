package com.example.expensestracker.model.db

import com.example.expensestracker.model.entity.Expense

class ExpensesRepository(private val expenseDao: ExpenseDao) {
    val expenses = expenseDao.getAllExpenses()

    suspend fun insert(expense: Expense){
        expenseDao.insertExpense(expense)
    }
}