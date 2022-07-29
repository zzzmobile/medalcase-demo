package com.zzzmobile.runkeepertest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.ActionBar
import com.zzzmobile.runkeepertest.R
import com.zzzmobile.runkeepertest.ui.fragments.RecordsFragment
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI() {
        val actionBar = supportActionBar

        actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar?.setCustomView(layoutInflater.inflate(R.layout.layout_toolbar, null), ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER))
        textTitle.text = getString(R.string.nav_title)
        actionBar?.setDisplayShowCustomEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeButtonEnabled(true)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, RecordsFragment.newInstance())
            .commitAllowingStateLoss()
    }
}