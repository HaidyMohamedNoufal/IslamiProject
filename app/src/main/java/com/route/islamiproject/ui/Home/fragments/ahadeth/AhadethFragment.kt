package com.route.islamiproject.ui.Home.fragments.ahadeth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamiproject.databinding.FragmentAhadethBinding
import com.route.islamiproject.ui.Constants
import com.route.islamiproject.ui.ahadeth._detalis.AhadethDetailsActivity
import com.route.islamiproject.ui.model.HadethModel
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class AhadethFragment : Fragment() {

    lateinit var binding: FragmentAhadethBinding
    var ahadeth = mutableListOf<HadethModel>()
    lateinit var ahadethAdapter: AhadethAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAhadethBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadeth()
        intRecyclerView()
    }

    private fun intRecyclerView() {
        ahadethAdapter = AhadethAdapter(ahadeth)
        ahadethAdapter.OnHadethClick = object : AhadethAdapter.OnItemClickListener {
            override fun onItemClick(hadeth: HadethModel, index: Int) {
                val intent = Intent(activity, AhadethDetailsActivity::class.java)
                intent.putExtra(Constants.HADETH,hadeth)
                startActivity(intent)

            }

        }
        binding.ahadethRv.adapter = ahadethAdapter
    }

    @SuppressLint("SuspiciousIndentation")
    private fun readAhadeth() {
        try {
            val inputStream = requireActivity().assets.open("ahadeeth.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val hadethFileContent = reader.readText()
            val ahadethList: List<String> = hadethFileContent.split("#")

            Log.e("ahadteh", ahadethList.size.toString())
            for (hadeth: String in ahadethList) {
               val singleHadethWithoutSpaces = hadeth.trim()
                val singleHadethLines: MutableList<String> = singleHadethWithoutSpaces.split("\n").toMutableList()
                val hadethTitles = singleHadethLines[0]
                singleHadethLines.removeAt(0)
                val content = singleHadethLines.joinToString(separator = "") {
                    return@joinToString it
                }
                Log.e("title", hadethTitles)
                Log.e("content", content)
                ahadeth.add(HadethModel(title = hadethTitles, content = content))

            }

            inputStream.close()

        } catch (e: IOException) {
            e.printStackTrace()
        }


    }

}


