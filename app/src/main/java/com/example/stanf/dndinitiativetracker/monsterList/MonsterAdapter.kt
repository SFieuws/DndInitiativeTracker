package com.example.stanf.dndinitiativetracker.monsterList

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stanf.dndinitiativetracker.R
import com.example.stanf.dndinitiativetracker.domain.Specials
import kotlinx.android.synthetic.main.row_monster_specials.view.*

class MonsterAdapter(val specials : List<Specials>) : RecyclerView.Adapter<MonsterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MonsterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_monster_specials,parent,false)
        return MonsterViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return specials.size
    }

    override fun onBindViewHolder(holderClusterList: MonsterViewHolder, position: Int) {
        val special = specials.get(position)
        holderClusterList.specialName.text = special.name
        holderClusterList.specialDesc.text = special.description
    }
}

class MonsterViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val specialName = view.specialNameText
    val specialDesc = view.specialDescText
}