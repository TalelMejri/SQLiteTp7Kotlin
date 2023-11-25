package com.example.tp7sqlite

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

lateinit var Nom:EditText
lateinit var Prenom:EditText
lateinit var Tel:EditText
lateinit var Email:EditText
lateinit var Login:EditText
lateinit var Password:EditText
lateinit var etudiantdb : EtudiantDBHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etudiantdb = EtudiantDBHelper(this)
        Nom=findViewById(R.id.Nom)
        Prenom=findViewById(R.id.Prenom)
        Tel=findViewById(R.id.tel)
        Email=findViewById(R.id.Email)
        Login=findViewById(R.id.Login)
        Password=findViewById(R.id.password);
    }

    fun Valider(v:View){
        if(Nom.text.isEmpty() || Prenom.text.isEmpty() || Tel.text.isEmpty()
            || Email.text.isEmpty() || Login.text.isEmpty() || Password.text.isEmpty()){
            var alert=AlertDialog.Builder(this);
            alert.setTitle("Attention")
            alert.setMessage("Tous les champs doivent étre rempli ");
            alert.setNegativeButton("No"){alert,Wich->alert.cancel()}
            alert.show();
        }else{
            val values = ContentValues()
            values.put(EtudiantBcc.UserEntry.COLUMN_NAME_NOM, Nom.text.toString())
            values.put(EtudiantBcc.UserEntry.COLUMN_NAME_LAST, Prenom.text.toString())
            values.put(EtudiantBcc.UserEntry.COLUMN_NAME_EMAIL, Email.text.toString())
            values.put(EtudiantBcc.UserEntry.COLUMN_NAME_LOGIN, Login.text.toString())
            values.put(EtudiantBcc.UserEntry.COLUMN_NAME_PHONE, Tel.text.toString())
            values.put(EtudiantBcc.UserEntry.COLUMN_NAME_MDP, Password.text.toString())
            val mDbHelper = EtudiantDBHelper(applicationContext);
            val db: SQLiteDatabase = mDbHelper.getWritableDatabase()
            val newRowId = db.insert(EtudiantBcc.UserEntry.TABLE_NAME, null, values)
            db.close();
            etudiantdb.close();
            val intent= Intent(this,ListEtudiant::class.java)
            startActivity(intent);
        }
    }

    fun init(){
        Nom.setText("");
        Prenom.setText("")
        Email.setText("")
        Login.setText("")
        Password.setText("")
        Tel.setText("")
    }

    fun Annuler(v:View){
        var alert=AlertDialog.Builder(this);
        alert.setTitle("Attention")
        alert.setMessage("Voulez-vous vraiment remttre à zero les champs");
        alert.setPositiveButton("Oui"){alert,Wich->
            init();
        }
        alert.setNegativeButton("NON"){alert,Wich->alert.cancel()}
        alert.show();
    }
}