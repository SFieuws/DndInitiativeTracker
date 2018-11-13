package com.example.stanf.dndinitiativetracker.monsterList

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.stanf.dndinitiativetracker.DummyData
import com.example.stanf.dndinitiativetracker.R
import com.example.stanf.dndinitiativetracker.domain.Abilities
import com.example.stanf.dndinitiativetracker.domain.Monster
import kotlinx.android.synthetic.main.fragment_monster_info.view.*
import kotlinx.android.synthetic.main.monster_abilities_view.view.*
import kotlinx.android.synthetic.main.monster_details_view.view.*
import kotlinx.android.synthetic.main.row_monsters.view.*

class MonsterInfoFragment : Fragment() {
    private lateinit var mFab : FloatingActionButton
    private lateinit var monster : Monster
    //private lateinit var inputViewModel: InputViewModel
    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_monster_info, container, false)

        return mView
    }

    override fun onStart() {
        super.onStart()

        mFab = mView.fab

        arguments?.getSerializable("monster")?.let {
            monster = it as Monster
        }

        mView.monsterNameTxt.text = monster.name

        //Details Include
        mView.acDetailsTxt.text = monster.armourClass.toString()
        mView.hpDetailsTxt.text = monster.hitPoints.toString()
        mView.sizeTxt.text = monster.size
        mView.typeTxt.text = monster.size
        mView.speedTxt.text = monster.speed

        //Abilities Include
        mView.strTxt.text = monster.abilities.get(Abilities.STR).toString()
        mView.dexTxt.text = monster.abilities.get(Abilities.DEX).toString()
        mView.conTxt.text = monster.abilities.get(Abilities.CON).toString()
        mView.intTxt.text = monster.abilities.get(Abilities.INT).toString()
        mView.wisTxt.text = monster.abilities.get(Abilities.WIS).toString()
        mView.charTxt.text =monster.abilities.get(Abilities.CHAR).toString()

        mView.traitsList.layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false)
        mView.traitsList.adapter = MonsterAdapter(monster.traits)
        mView.actionsList.layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false)
        mView.actionsList.adapter = MonsterAdapter(monster.actions)

        mFab.setOnClickListener {
            if(DummyData.savedMonsters.value!!.indexOf(monster) == -1)
                DummyData.savedMonsters.value!!.add(monster)
            else
                Toast.makeText(mView.context, "Monster is allready saved.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()

        //clear clickListener
        mFab.setOnClickListener {
        }
    }

    companion object {
        fun newInstance(monster: Monster) : MonsterInfoFragment {
            val args = Bundle()
            args.putSerializable("monster", monster)
            val fragment = MonsterInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}