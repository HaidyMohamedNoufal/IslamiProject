package com.route.islamiproject.ui.Home.fragments.quran.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.route.islamiproject.R

class SuraNamesAdapter(var suraName:List<String>):Adapter<SuraNamesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name,parent,false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName =suraName[position];
        holder.suraNameTv.text= suraName
        if(OnSuraClick != null){
            holder.itemView.setOnClickListener{
                OnSuraClick!!.onItemClick(suraName,position)
        }
    }
}
    override fun getItemCount(): Int=suraName.size
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val suraNameTv: TextView = itemView.findViewById(R.id.itemSuraNameTV)

    }
    var OnSuraClick: OnItemClickListener? = null
    interface OnItemClickListener{
        fun onItemClick (suraName:String, index: Int)
    }

}