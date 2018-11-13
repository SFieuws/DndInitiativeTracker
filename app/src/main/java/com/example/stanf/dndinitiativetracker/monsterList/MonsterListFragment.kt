package com.example.stanf.dndinitiativetracker.monsterList

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.stanf.dndinitiativetracker.DummyData
import com.example.stanf.dndinitiativetracker.FragmentSwitcher
import com.example.stanf.dndinitiativetracker.MainActivity
import com.example.stanf.dndinitiativetracker.R
import com.example.stanf.dndinitiativetracker.domain.Monster
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_list_monsters.*
import kotlinx.android.synthetic.main.fragment_list_monsters.view.*

class MonsterListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fragmentSwitcher: FragmentSwitcher

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_monsters, container, false)

        recyclerView = view.list_monsters
        //val model = ViewModelProviders.of(this).get(MyViewModel::class.java)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentSwitcher = activity as FragmentSwitcher
    }

    override fun onStart() {
        super.onStart()

        var aim = ""
        arguments?.getSerializable("AIM")?.let {
            aim = it as String
        }

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        var monsterListAdapter = MonsterListAdapter(DummyData.monsterList, fragmentSwitcher, aim)
        var savedMonstersListAdapter = MonsterListAdapter(DummyData.savedMonsters.value, fragmentSwitcher, aim)
        recyclerView.adapter = monsterListAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {
                recyclerView.adapter = null
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                if(tab.position == 0)
                    recyclerView.adapter = monsterListAdapter
                else
                    recyclerView.adapter = savedMonstersListAdapter
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
        })
    }

    override fun onStop() {
        super.onStop()
        recyclerView.adapter = null
    }

    /*private fun fillMonsters() {
        val taskService = ServiceBuilder.buildService(MonsterService::class.java)
        val call = taskService.getMonsters()

        call.enqueue(object : Callback<List<Monster>> {
            override fun onResponse(request: Call<List<Monster>>, response: Response<List<Monster>>) {
                Log.d("TAG", response.body().toString())
                if(response.isSuccessful) {
                    recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
                    var monsterListAdapter = MonsterListAdapter(response.body()!!)
                    recyclerView.adapter = monsterListAdapter
                }
                else {
                    Toast.makeText(activity, "There has been a problem loading the monsters", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(request: Call<List<Monster>>, t: Throwable) {
                //Hier is request gefaald, laat het weten aan de gebruiker
                Log.d("TAG", "ERROR")
            }
        })
    }*/

    companion object {
        fun newInstance(aim: String) : MonsterListFragment {
            val args = Bundle()
            args.putSerializable("AIM", aim)
            val fragment = MonsterListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}