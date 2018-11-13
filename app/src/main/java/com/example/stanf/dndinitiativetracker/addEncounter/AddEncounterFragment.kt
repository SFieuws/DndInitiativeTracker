package com.example.stanf.dndinitiativetracker.addEncounter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.stanf.dndinitiativetracker.FragmentSwitcher
import com.example.stanf.dndinitiativetracker.MainActivity
import com.example.stanf.dndinitiativetracker.R
import com.example.stanf.dndinitiativetracker.domain.PlayableCharacter
import com.example.stanf.dndinitiativetracker.domain.Player
import kotlinx.android.synthetic.main.dialog_player_name.view.*
import kotlinx.android.synthetic.main.fragment_new_encounter.*
import java.util.ArrayList

class AddEncounterFragment: Fragment(), View.OnClickListener {
    var playableCharacters = ArrayList<PlayableCharacter>()
    private lateinit var encounterAdapter : EncounterAdapter
    private lateinit var mActivity: MainActivity
    private var fragmentSwitcher: FragmentSwitcher? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_new_encounter, container, false)

        mActivity = activity as MainActivity
        fragmentSwitcher = activity as FragmentSwitcher

        return view
    }

    override fun onStart() {
        super.onStart()

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        encounterAdapter = EncounterAdapter(playableCharacters)
        recyclerView.adapter = encounterAdapter

        fab_save.setOnClickListener {
            fragmentSwitcher!!.showMainFragmentWithNewTab(playableCharacters)
        }

    }

    override fun onResume() {
        super.onResume()

        addPlayer.setOnClickListener(this)
        addEnemy.setOnClickListener(this)
    }

    override fun onClick(button: View){
        when(button.id) {
            R.id.addPlayer -> {
                createPlayer()
            }
            R.id.addEnemy -> {
                fragmentSwitcher!!.showMonsterListAndChooseMonster()
                //playableCharacters.add(Monster("Zombie", 12, 23))
                /*encounterAdapter = EncounterAdapter(playableCharacters)
                recyclerView.adapter = encounterAdapter
                Log.d("TAG", "Add new enemy")*/
            }
        }
    }

    private fun createPlayer() {
        var playerName= ""
        val dialogBuilder = AlertDialog.Builder(mActivity)
        val dialogView = layoutInflater.inflate(R.layout.dialog_player_name, null)
        val dialog = dialogBuilder.setView(dialogView).create()
        dialog.show()

        dialogView.submitBtn.setOnClickListener {
            playerName = dialogView.playerNameTxt.text.toString().trim()
            if(playerName.isEmpty())
                Toast.makeText(mActivity, "Please fill in a name", Toast.LENGTH_SHORT).show()
            else {
                playableCharacters.add(Player(playerName))
                encounterAdapter = EncounterAdapter(playableCharacters)
                recyclerView.adapter = encounterAdapter
                dialog.dismiss()
            }
        }
    }

}

