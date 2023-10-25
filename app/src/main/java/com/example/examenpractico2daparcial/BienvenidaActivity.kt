package com.example.examenpractico2daparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BienvenidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val textViewNameAndSurname = findViewById<TextView>(R.id.textViewNameAndSurname)
        val buttonExit = findViewById<Button>(R.id.buttonExit)

        val personas = intent.getSerializableExtra("personas") as ArrayList<Persona>

        if (!personas.isNullOrEmpty()) {
            val persona = personas[1] // Obtén el primer elemento de la lista
            textViewNameAndSurname.text = "${persona.nombre} ${persona.apellidos}"
        }

        buttonExit.setOnClickListener {
            // Regresa a la pantalla de inicio de sesión
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Cierra esta actividad para que no se pueda volver atrás
        }
    }
}