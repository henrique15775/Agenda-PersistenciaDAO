package com.example.agenda

import android.content.ContentValues
import android.content.Context

class PessoaDAO (private var context: Context) {
   private var banco: BancoHelper

    init {
        this.banco = BancoHelper(this.context)
    }


    fun insert(pessoa: Pessoa){
        val cv = ContentValues()
        cv.put("nome", pessoa.nome)
        cv.put("idade", pessoa.idade)
        this.banco.writableDatabase.insert("pessoa", null, cv)
    }

    fun select(): ArrayList<Pessoa>{
        val lista = arrayListOf<Pessoa>()
        val colunas = arrayOf("id", "nome", "idade")
        val cursor = this.banco.readableDatabase.query("pessoa", colunas, null, null, null, null, null)
        cursor.moveToFirst()
        for (i in 1 .. cursor.count){
            val id = cursor.getInt(colunas.indexOf("id"))
            val nome = cursor.getString(colunas.indexOf("nome"))
            val idade = cursor.getInt(colunas.indexOf("idade"))
            lista.add(Pessoa(id, nome, idade))
            cursor.moveToNext()
        }
        cursor.close()
        return lista
    }

}