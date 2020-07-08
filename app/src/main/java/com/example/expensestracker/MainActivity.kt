package com.example.expensestracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.databinding.ActivityMainBinding
import com.example.expensestracker.model.db.ExpensesDatabase
import com.example.expensestracker.model.db.ExpensesRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var expenseViewModel: ExpenseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = ExpensesDatabase.getInstance(application).expenseDao
        val repository = ExpensesRepository(dao)
        val factory = ExpenseViewModelFactory(repository)
        expenseViewModel = ViewModelProvider(this, factory).get(ExpenseViewModel::class.java)
        binding.myViewModel = expenseViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this)
        displayExpensesList()
    }

    private fun displayExpensesList() {
        expenseViewModel.expenses.observe(this, Observer {
            Log.i("MYTAG", it.toString())
            binding.subscriberRecyclerView.adapter = MyRecyclerViewAdapter(it)
        })
    }
}