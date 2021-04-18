package me.acsv.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.acsv.calculadoradenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular.setOnClickListener {
            val nota1 = binding.nota1.text.toString().toIntOrNull()
            val nota2 = binding.nota2.text.toString().toIntOrNull()
            val nota3 = binding.nota3.text.toString().toIntOrNull()
            val nota4 = binding.nota4.text.toString().toIntOrNull()
            val faltas = binding.faltas.text.toString().toIntOrNull()

            val txtResultado = binding.txtResultado

            if(nota1 == null || nota2 == null || nota3 == null || nota4 == null || faltas == null) {
                return@setOnClickListener
            }

            val media = (nota1 + nota2 + nota3 + nota4).div(4)

            // Aprovado
            if (media >= 5 && faltas <= 20) {
                txtResultado.text = "Aluno foi Arovado\nMédia final $media"
                txtResultado.setTextColor(getColor(R.color.green))
            } else if(faltas > 20) {
                txtResultado.text = "Aluno foi Reprovado por Faltas\nMédia final $media"
                txtResultado.setTextColor(getColor(R.color.red))
            } else {
                txtResultado.text = "Aluno foi Reprovado por Nota\nMédia final $media"
                txtResultado.setTextColor(getColor(R.color.red))
            }
        }
    }
}