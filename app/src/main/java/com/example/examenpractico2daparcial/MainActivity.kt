package com.example.examenpractico2daparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val miUser = "dloredo" // Valor de ejemplo
    private val miContra = "david123" // Valor de ejemplo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val inputUser = editTextUsername.text.toString()
            val inputPassword = editTextPassword.text.toString()
            if(inputUser == "" || inputPassword == ""){
                Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show()
            }else{
                if (miUser == inputUser && miContra == inputPassword) {
                    // Credenciales válidas, redirige a la segunda pantalla

                    val personas = ArrayList<Persona>()
                    personas.add(Persona("David", "Loredo"))
                    personas.add(Persona("Jose", "Nabor"))

                    val intent = Intent(this, BienvenidaActivity::class.java)
                    intent.putExtra("personas", personas)
                    startActivity(intent)
                } else {
                    // Credenciales incorrectas, muestra un mensaje de error
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}