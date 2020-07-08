package com.example.expensestracker

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensestracker.model.db.ExpensesRepository
import com.example.expensestracker.model.entity.Expense
import kotlinx.coroutines.launch

class ExpenseViewModel(private val repository: ExpensesRepository):ViewModel(),Observable {
    val expenses = repository.expenses

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputPrice = MutableLiveData<String>()

    fun saveExpense(){
        val name = inputName.value!!
        val price = inputPrice.value!!

        insert(Expense(0,name,price))
        inputName.value = null
        inputPrice.value = null
    }

    fun insert(expense: Expense) = viewModelScope.launch {
        repository.insert(expense)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}