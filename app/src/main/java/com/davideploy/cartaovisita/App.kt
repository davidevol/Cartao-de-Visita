package com.davideploy.cartaovisita

import android.app.Application
import com.davideploy.cartaovisita.data.AppDatabase
import com.davideploy.cartaovisita.data.BusinessCardRepository

class App : Application() {

    val database by lazy { AppDatabase.getDatabase(this)}
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}