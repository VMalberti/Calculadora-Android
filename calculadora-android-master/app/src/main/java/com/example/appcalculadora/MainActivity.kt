package com.example.appcalculadora

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNumero01 = findViewById<EditText>(R.id.edt_Number01)
        val edtNumero02 = findViewById<EditText>(R.id.edt_Number02)
        val txtResultado = findViewById<TextView>(R.id.txt_Resultado)

        val btnSoma = findViewById<Button>(R.id.btn_Somar)
        val btnSubtrair = findViewById<Button>(R.id.btn_Subtrair)
        val btnMultiplicar = findViewById<Button>(R.id.btn_Multiplicar)
        val btnDividir = findViewById<Button>(R.id.btn_Dividir)
        val btnCalcular = findViewById<Button>(R.id.btn_Calcular)

        var operacao = ""

        btnSoma.setOnClickListener { operacao = "+" }
        btnSubtrair.setOnClickListener { operacao = "-" }
        btnMultiplicar.setOnClickListener { operacao = "*" }
        btnDividir.setOnClickListener { operacao = "/" }

        btnCalcular.setOnClickListener {

            if (edtNumero01.text.isEmpty() || edtNumero02.text.isEmpty()) {
                Toast.makeText(this, "Digite os dois números", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val numero1 = edtNumero01.text.toString().toDouble()
            val numero2 = edtNumero02.text.toString().toDouble()

            val resultado = when (operacao) {
                "+" -> numero1 + numero2
                "-" -> numero1 - numero2
                "*" -> numero1 * numero2
                "/" -> {
                    if (numero2 == 0.0) {
                        Toast.makeText(this, "Não pode dividir por zero", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    numero1 / numero2
                }
                else -> {
                    Toast.makeText(this, "Escolha uma operação", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            txtResultado.text = "Resultado: $resultado"
        }
    }
}