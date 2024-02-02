package com.route.islamiproject.ui.Home.fragments.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.islamiproject.R
import com.route.islamiproject.databinding.FragmentQuranBinding
import com.route.islamiproject.ui.Constants
import com.route.islamiproject.ui.Home.fragments.quran.adapter.SuraNamesAdapter
import com.route.islamiproject.ui.Home.sura_details.SuraDetailsActivity


class QuranFragment : Fragment() {

    lateinit var binding: FragmentQuranBinding
    lateinit var SurasAdapter: SuraNamesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        SurasAdapter = SuraNamesAdapter(Constants.SURAS_NAME)
        SurasAdapter.OnSuraClick= object : SuraNamesAdapter.OnItemClickListener{
            override fun onItemClick(suraName: String, index: Int) {
                val intent = Intent(activity,SuraDetailsActivity::class.java)
                 intent.putExtra(Constants.FILE_NAME,"${index +1 }.txt")
                intent.putExtra(Constants.SURA_NAME,suraName)
             startActivity(intent)
            }

        }
        binding.suraNameRv.adapter= SurasAdapter

    }
}
