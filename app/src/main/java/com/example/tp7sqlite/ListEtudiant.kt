package com.example.tp7sqlite


import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity


private var dbHelper: EtudiantDBHelper? = null
lateinit var usersDBHelper : EtudiantDBHelper
lateinit var  listetud:ListView

class ListEtudiant : AppCompatActivity() {
    private var adapter: SimpleCursorAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        usersDBHelper = EtudiantDBHelper(this)
        setContentView(R.layout.activity_list_etudiant)
        listetud=findViewById(R.id.idlistetu)
        listetud.adapter = getAdapter()

    }


    fun getAdapter(): SimpleCursorAdapter {
        if (adapter == null) {
            val db = usersDBHelper.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM " + EtudiantBcc.UserEntry.TABLE_NAME, null)
            adapter = SimpleCursorAdapter(
                this,
                R.layout.ligne_etud,
                cursor,
                arrayOf(EtudiantBcc.UserEntry.COLUMN_NAME_NOM, EtudiantBcc.UserEntry.COLUMN_NAME_LAST),
                intArrayOf(R.id.nometud, R.id.preetud),
                0
            )
        }
        return adapter!!
    }

}