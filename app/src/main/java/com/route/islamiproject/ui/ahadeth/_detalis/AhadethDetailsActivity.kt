package com.route.islamiproject.ui.ahadeth._detalis

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.islamiproject.databinding.ActivityAhadethDetailsBinding
import com.route.islamiproject.ui.Constants
import com.route.islamiproject.ui.model.HadethModel

class AhadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAhadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAhadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(Constants.HADETH, HadethModel::class.java)
        } else {
            intent.getSerializableExtra(Constants.HADETH) as HadethModel
        }
        binding.hadethNameTv.text = hadeth?.title
        binding.hadethContentTv.text = hadeth?.content
    }
}