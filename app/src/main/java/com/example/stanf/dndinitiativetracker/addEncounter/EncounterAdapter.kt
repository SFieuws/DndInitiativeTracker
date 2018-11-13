package com.example.stanf.dndinitiativetracker.addEncounter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stanf.dndinitiativetracker.R
import com.example.stanf.dndinitiativetracker.domain.Monster
import com.example.stanf.dndinitiativetracker.domain.PlayableCharacter
import com.example.stanf.dndinitiativetracker.domain.Player
import kotlinx.android.synthetic.main.row_encounter.view.*

class EncounterAdapter(var characters : List<PlayableCharacter>): RecyclerView.Adapter<EncounterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): EncounterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_encounter,parent,false)
        return EncounterViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holderCluster: EncounterViewHolder, position: Int) {
        val playableCharacter = characters.get(position)
        holderCluster.initiativeTxtView.visibility = View.GONE
        if(playableCharacter is Monster) {
            holderCluster.name.text = playableCharacter.name
            holderCluster.armourClass.text = playableCharacter.armourClass.toString()
            holderCluster.hitPoints.text = playableCharacter.hitPoints.toString()
        }
        else if(playableCharacter is Player) {
            holderCluster.name.text = playableCharacter.name
            holderCluster.armourClass.visibility = View.GONE
            holderCluster.hitPoints.visibility = View.GONE
        }
    }

}

class EncounterViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val name = view.name
    val armourClass = view.acTxtView
    val hitPoints = view.hpTxtView
    val initiativeTxtView = view.initiativeTxtView
}