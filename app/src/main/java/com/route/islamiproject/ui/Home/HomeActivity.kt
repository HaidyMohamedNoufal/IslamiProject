package com.route.islamiproject.ui.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islamiproject.R
import com.route.islamiproject.databinding.ActivityHomeBinding
import com.route.islamiproject.ui.Home.fragments.ahadeth.AhadethFragment
import com.route.islamiproject.ui.Home.fragments.quran.QuranFragment
import com.route.islamiproject.ui.Home.fragments.radio.RadioFragment
import com.route.islamiproject.ui.Home.fragments.sebha.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startFragment(RadioFragment())
        initListeners()
    }
    private fun initListeners(){
        binding.bottomNav.setOnItemSelectedListener {

            if (it.itemId == R.id.navigation_quran) {
                startFragment(QuranFragment())
            } else if (it.itemId == R.id.navigation_ahadeth) {
                startFragment(AhadethFragment())

            } else if (it.itemId == R.id.navigation_sebha) {
                startFragment(SebhaFragment())
            } else if (it.itemId == R.id.navigation_radio) {
                startFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
    }
     private fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

    }
}