package com.example.stanf.dndinitiativetracker.monsterList

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stanf.dndinitiativetracker.FragmentSwitcher
import com.example.stanf.dndinitiativetracker.R
import com.example.stanf.dndinitiativetracker.domain.Monster
import kotlinx.android.synthetic.main.row_monsters.view.*


class MonsterListAdapter(val monsters : List<Monster>?, val fragmentSwitcher: FragmentSwitcher, val aim: String) : RecyclerView.Adapter<MonsterListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MonsterListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_monsters,parent,false)
        return MonsterListViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        if(monsters == null)
            return 0
        return monsters.size
    }

    override fun onBindViewHolder(holderClusterList: MonsterListViewHolder, position: Int) {
        if(monsters == null)
            return
        val monster = monsters.get(position)
        holderClusterList.monsterName.text = monster.name
        holderClusterList.armourClass.text = monster.armourClass.toString()
        holderClusterList.hitPoints.text = monster.hitPoints.toString()
        holderClusterList.view.setOnClickListener {
            if(aim == "LookupMonster")
                fragmentSwitcher.showMonsterInfoFragmentForLookup(monster)
            //else if(aim == "PickMonster")
                //fragmentSwitcher.showMonsterInfoFragmentPicking(monster)
        }
    }

}

class MonsterListViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val monsterName = view.monsterName
    val armourClass = view.acTxtView
    val hitPoints = view.hpTxtView
}
