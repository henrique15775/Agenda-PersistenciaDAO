package com.example.agenda

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper(var context:Context): SQLiteOpenHelper(context, "dados.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table pessoa( " +
                "  id integer primary key autoincrement, " +
                "  nome text, " +
                "  idade integer)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, anterior: Int, atual: Int) {
        if (atual != anterior){
            db?.execSQL("drop table pessoa")
            this.onCreate(db)
        }
    }
}