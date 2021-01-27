package com.ravn.ravn_challenge_v2_jose_arteaga.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ravn.ravn_challenge_v2_jose_arteaga.R

class MainActivity : AppCompatActivity() {
    // The MainActivity just contains the FragmentHost that haves the navigation graph
    // This is to have a SingleActivityApplication and simplify some things
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}