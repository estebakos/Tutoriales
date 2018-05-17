package co.ssoftware.tests

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            if(validateForm() ){
                val intent  = Intent(this@MainActivity,  HomeActivity::class.java)
                intent.putExtra("User", etUser.text.toString())
                startActivity(intent)
            }
        }
    }

    private fun validateForm(): Boolean {
        return if (etUser.text.toString().isNotEmpty() && etPassword.text.toString().isNotEmpty()) {
            true
        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
            false
        }
    }
}
