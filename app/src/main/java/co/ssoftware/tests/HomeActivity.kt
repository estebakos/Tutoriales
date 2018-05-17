package co.ssoftware.tests

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by esteb on 16/05/2018.
 */
class HomeActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_home)
         if(intent.extras != null && intent.extras.getString("User") != null){
             Toast.makeText(this, intent.extras.getString("User"), Toast.LENGTH_LONG).show()
         }

         val teams = mutableListOf<Team>()
         teams.add(Team("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4vK-bWrsBbkUC7ivW_JUmtc6jCeyhkLQkV3ng7z-YH6DrlsfFbg", "America de Cali", 13))
         teams.add(Team("https://www.atlnacional.com.co/wp-content/uploads/2018/01/loguito-web-e1517588053785.png", "Atlético nacional", 16))
         teams.add(Team("https://cdn.colombia.com/images/futbol/equipos/180x180/colombia/deportes-tolima.jpg", "Deportes Tolima", 1))
         teams.add(Team("https://ugc.kn3.net/i/origin/https://mifutbolecuador.files.wordpress.com/2017/02/delfin-sporting-club-escudo.png", "Delfín", -3))
         teams.add(Team("https://upload.wikimedia.org/wikipedia/commons/a/ae/SK_Slavia_Praha.png", "Slavia Praga", 25))

         rvTeams.layoutManager = LinearLayoutManager(this)
         rvTeams.setHasFixedSize(true)
         val teamsAdapter = TeamsAdapter(teams, {
             Toast.makeText(this@HomeActivity, it.teamName, Toast.LENGTH_LONG).show()
         })
         rvTeams.adapter = teamsAdapter
    }
}