package com.example.expensestracker.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expensestracker.model.entity.Expense

@Database(entities = [Expense::class],version = 1)
abstract class ExpensesDatabase: RoomDatabase()  {
    abstract val expenseDao:ExpenseDao
    companion object{
        @Volatile
        private var INSTANCE:ExpensesDatabase? =null
        fun getInstance(context: Context):ExpensesDatabase{
            synchronized(this){
                var instance:ExpensesDatabase? = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ExpensesDatabase::class.java,
                        "expenses_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}