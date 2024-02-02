package com.route.islamiproject.ui.Home.fragments.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamiproject.R
import com.route.islamiproject.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {

    lateinit var binding: FragmentSebhaBinding
   var counter=0
   var azkarList= mutableListOf<String>()
    var currentDhikrIndex=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSebhaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.asmEltzker.text = azkarList [currentDhikrIndex]

        onSebhaClick()
    }

    private fun onSebhaClick() {
        binding.bodySebha.setOnClickListener{
            binding.bodySebha.rotation +=(360/30).toFloat()
            if (counter<33){
                counter++
            }else{
                counter= 0
                currentDhikrIndex= if (currentDhikrIndex< azkarList.size -1 )++ currentDhikrIndex else 0
                binding.asmEltzker.text = azkarList[currentDhikrIndex]
            }
            binding.adadEltzker.text= counter.toString()
        }
    }
}
