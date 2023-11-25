package com.example.tp7sqlite

import android.provider.BaseColumns

class EtudiantBcc {

    class UserEntry : BaseColumns {
        companion object {
            const val TABLE_NAME = "etudiant";
            const val COLUMN_NAME_NOM = "nom";
            const val COLUMN_NAME_LAST = "last";
            const val COLUMN_NAME_PHONE = "phone";
            const val COLUMN_NAME_EMAIL = "email";
            const val COLUMN_NAME_LOGIN = "login";
            const val COLUMN_NAME_MDP = "mdp";

        }
    }

    public val SQL_CREATE_ENTRIES =
        "CREATE TABLE " + EtudiantBcc.UserEntry.TABLE_NAME + " (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                EtudiantBcc.UserEntry.COLUMN_NAME_NOM  + " TEXT," +
                EtudiantBcc.UserEntry.COLUMN_NAME_LAST + " TEXT," +
                EtudiantBcc.UserEntry.COLUMN_NAME_PHONE + " TEXT," +
                EtudiantBcc.UserEntry.COLUMN_NAME_EMAIL + " TEXT," +
                EtudiantBcc.UserEntry.COLUMN_NAME_LOGIN + " TEXT," +
                EtudiantBcc.UserEntry.COLUMN_NAME_MDP + " TEXT" +
                ")";

    public val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + EtudiantBcc.UserEntry.TABLE_NAME

}