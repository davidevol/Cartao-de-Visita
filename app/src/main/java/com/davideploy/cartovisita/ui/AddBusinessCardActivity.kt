package com.davideploy.cartovisita.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davideploy.cartovisita.databinding.ActivityAddBusinessCardBinding


class AddBusinessCardActivity : AppCompatActivity() {


    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListerner()
    }

    private fun insertListerner() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirm.setOnClickListener {
            TODO("Configurar a acão de btnConfirm")
        }
    }
}