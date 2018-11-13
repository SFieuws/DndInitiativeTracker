package com.example.stanf.dndinitiativetracker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.example.stanf.dndinitiativetracker.addEncounter.AddEncounterFragment
import com.example.stanf.dndinitiativetracker.domain.Monster
import com.example.stanf.dndinitiativetracker.domain.PlayableCharacter
import com.example.stanf.dndinitiativetracker.monsterList.MonsterInfoFragment
import com.example.stanf.dndinitiativetracker.monsterList.MonsterListFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, FragmentSwitcher {
    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set our own toolbar instead of Android toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        mDrawerLayout = findViewById(R.id.drawer_layout)
        //val navigationView: NavigationView = findViewById(R.id.nav_view)*/

        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onStart() {
        super.onStart()
        val mainFragment = MainFragment()
        //val mainFragment = MonsterInfoFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, mainFragment, "MainFragment").addToBackStack("MainFragment")
        transaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        item.isChecked = true
        when (item.itemId) {
            R.id.encouter_view -> {
                val mainFragment = supportFragmentManager.findFragmentByTag("MainFragment")!! as MainFragment
                switchFragment(mainFragment)
            }
            R.id.monster_view -> {
                val monsterListFragment = MonsterListFragment.newInstance("LookupMonster")
                switchFragment(monsterListFragment)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun switchFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        //als fragment gelijk is aan een TalentFragment, toon de filterknop
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        if(addToBackStack)
            fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun createEncounterFragment() {
        var addEncounterFragment = AddEncounterFragment()
        switchFragment(addEncounterFragment, true)
    }

    override fun showMonsterInfoFragmentForLookup(monster: Monster) {
        var fragment = MonsterInfoFragment.newInstance(monster)
        switchFragment(fragment, true)
    }

    /*
    override fun showMonsterInfoFragmentPicking(monster: Monster) {
        var fragment = MonsterInfoFragment.newInstance(monster)
        fragment.setFabListener()
        switchFragment(fragment, true)
    }
    */

    override fun showMonsterListAndChooseMonster() {
        var fragment = MonsterListFragment.newInstance("PickMonster")
        switchFragment(fragment, true)
    }

    override fun showMainFragmentWithNewTab(playableCharacters: ArrayList<PlayableCharacter>) {
        val mainFragment = supportFragmentManager.findFragmentByTag("MainFragment")!! as MainFragment
        mainFragment.addTab(playableCharacters)
        switchFragment(mainFragment)
    }
}

interface FragmentSwitcher {
    fun showMonsterInfoFragmentForLookup(monster: Monster)
    //fun showMonsterInfoFragmentPicking(monster: Monster)
    fun createEncounterFragment()
    fun showMonsterListAndChooseMonster()
    fun showMainFragmentWithNewTab(playableCharacters: ArrayList<PlayableCharacter>)
}