package com.forasoft.projecttemplate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.forasoft.projecttemplate.R
import dagger.hilt.android.AndroidEntryPoint

// TODO change root package name

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}