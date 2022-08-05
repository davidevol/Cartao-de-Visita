package com.davideploy.cartovisita

import android.app.Application
import com.davideploy.cartovisita.data.AppDatabase
import com.davideploy.cartovisita.data.BusinessCardRepository

class App : Application() {

    val database by lazy { AppDatabase.getDatabase(this)}
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}