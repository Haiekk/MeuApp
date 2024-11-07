package com.example.meuapp

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_principal)

        // Aplicando os ajustes para as barras de sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializando os componentes da tela
        val editPeso: EditText = findViewById(R.id.edit_peso)
        val editAltura: EditText = findViewById(R.id.edit_altura)
        val btnCalcular: Button = findViewById(R.id.bt_calcular)
        val resultText: TextView = findViewById(R.id.result_text)

        // Ação do botão para calcular o IMC
        btnCalcular.setOnClickListener {
            // Obtendo os valores de peso e altura
            val peso = editPeso.text.toString().toFloatOrNull()
            val altura = editAltura.text.toString().toFloatOrNull()

            // Verificando se os valores são válidos
            if (peso != null && altura != null && altura > 0) {
                // Calculando o IMC
                val imc = peso / (altura * altura)

                // Exibindo o resultado
                resultText.text = "Seu IMC é: %.2f".format(imc)
            } else {
                // Caso os valores sejam inválidos, exibe uma mensagem de erro
                resultText.text = "Por favor, insira valores válidos!"
            }
        }
    }
}
