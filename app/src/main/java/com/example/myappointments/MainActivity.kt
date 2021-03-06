package com.example.myappointments

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.example.myappointments.PreferenceHelper.get
import com.example.myappointments.PreferenceHelper.set
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val snackBar by lazy {
        Snackbar.make(mainLayout,R.string.press_back_again,Snackbar.LENGTH_SHORT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //share preferences
/*
        val preferences = getSharedPreferences("general", Context.MODE_PRIVATE)
        val session = preferences.getBoolean("active_session",false)
*/

        val preferences = PreferenceHelper.defaultPrefs(this)
        if (preferences["session",false])
            goToMenuActivity()

        btnLogin.setOnClickListener {

            createSessionPreference()
            goToMenuActivity()
        }

        tvGoToRegister.setOnClickListener {
          //  Toast.makeText(this,getString(R.string.please_fill_your_register_name),Toast.LENGTH_SHORT).show()
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createSessionPreference() {
        /*
        val preferences = getSharedPreferences("general", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean("active_session",true)
        editor.apply()
        */
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = true
    }

    private fun goToMenuActivity(){
      //  Toast.makeText(this,getString(R.string.please_fill_your_register_name),Toast.LENGTH_SHORT).show()
        val intent = Intent(this,MenuActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        if (snackBar.isShown)
            super.onBackPressed()
        else
            snackBar.show()
    }
}