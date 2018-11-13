package com.example.stanf.dndinitiativetracker

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TabHost
import com.example.stanf.dndinitiativetracker.addEncounter.EncounterAdapter
import com.example.stanf.dndinitiativetracker.domain.PlayableCharacter
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {
    private lateinit var spec: TabHost.TabSpec
    private var teller = 0
    private var fragmentSwitcher: FragmentSwitcher? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_main, container, false)

        return view
    }

    private fun loadTabs() {
        var spec = tabHost.newTabSpec("Tab One")
        spec.setContent(R.id.tab1)
        for(x in 1.rangeTo(teller)) {
            spec.setIndicator("Encounter $x")
            tabHost.addTab(spec)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentSwitcher = activity as FragmentSwitcher
    }

    override fun onResume() {
        super.onResume()

        tabHost.setup()
        spec = tabHost.newTabSpec("Tab One")
        spec.setContent(R.id.tab1)

        if(teller != 0)
            loadTabs()


        fab.setOnClickListener {
            fragmentSwitcher!!.createEncounterFragment()
            //addTab(arrayListOf())
        }
    }

    fun addTab(playableCharacters: ArrayList<PlayableCharacter>) {
        spec.setIndicator("Encounter ${++teller}")
        tabHost.addTab(spec)
        tab1.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        tab1.adapter = EncounterAdapter(playableCharacters)
    }
}