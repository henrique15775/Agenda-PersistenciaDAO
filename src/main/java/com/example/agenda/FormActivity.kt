package com.example.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etIdade: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var dao: PessoaDAO
    private var etID: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        this.dao = PessoaDAO(this)
        this.etNome = findViewById(R.id.etFormNome)
        this.etIdade = findViewById(R.id.etFormIdade)
        this.btSalvar = findViewById(R.id.etBtSalvar)
        this.btCancelar = findViewById(R.id.etBtCancelar)
        this.btSalvar.setOnClickListener{ salvar() }
        this.btCancelar.setOnClickListener{ cancelar() }
    }

    fun salvar(){

        val nome = this.etNome.text.toString()
        val idade = this.etIdade.text.toString().toInt()
        val pessoa = Pessoa(nome, idade)
        this.dao.insert(pessoa)
        setResult(RESULT_OK, intent)
        finish()
    }

    fun cancelar(){
        finish()
    }

}